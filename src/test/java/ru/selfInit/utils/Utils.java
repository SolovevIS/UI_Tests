package ru.selfInit.utils;

import org.junit.Assert;
import org.openqa.selenium.By;
import ru.selfInit.exception.WrongXpathException;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Properties;

public class Utils {

    public static Properties readProperties(String propName) {
        try {
            Properties props = new Properties();
            props.load(Files.newInputStream(Paths.get("src\\test\\resources\\properities\\" + propName)));
            return props;
        } catch (IOException | NullPointerException exception) {
            exception.printStackTrace();
            System.out.println("File not found");
            return null;
        }
    }

    public static void timeout(int seconds) {
        try {
            Thread.sleep(seconds * 1000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void checkXPath(String xpath) {
        Driver driver = new Driver();
        try {
            if (checkForNotNullResultFromXpath(xpath)) {
                throw new WrongXpathException("Used xpath are incorrect");
            }
            if (checkForMultipleResultsFromXpath(xpath)) {
                throw new WrongXpathException("Used xpath are incorrect by having multiple results");
            }
        } catch (WrongXpathException e) {
            e.printStackTrace();
            driver.getDriverFromCollectables().close();
            Assert.fail();
        }
    }

    private static boolean checkForMultipleResultsFromXpath(String xpath) {
        Driver driver = new Driver();
        return driver.getDriverFromCollectables().findElements(By.xpath(xpath)).size() > 1;
    }

    private static boolean checkForNotNullResultFromXpath(String xpath) {
        Driver driver = new Driver();
        return driver.getDriverFromCollectables().findElements(By.xpath(xpath)).isEmpty();
    }

    public static void saveScreenshot(String pageType) {
        Driver driver = new Driver();
        try {
            File file = new File(driver.makeScreenshot().toPath().toString());
            Files.move(file.toPath(), Paths.get("src\\test\\resources\\screenshots\\" + "screenshot_" + pageType + ".png"));
        } catch (IOException e) {
            System.out.println("Smth went wrong during copying screenshot");
            e.printStackTrace();
            driver.getDriverFromCollectables().close();
            Assert.fail();
        }
    }
}
