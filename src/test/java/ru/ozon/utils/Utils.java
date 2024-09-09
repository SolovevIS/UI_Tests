package ru.ozon.utils;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Properties;

public class Utils {

    public static Properties readProperties() {
        try {
            Properties properties = new Properties();
            properties.load(Files.newInputStream(Paths.get("src/test/resources/properities/driverProperties.properties")));
            return properties;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static void waiting(int millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void makeScreenshot(String fileName) {
        Selenide.screenshot(fileName);
    }

    public static void swapWindows(String title) {
        if (WebDriverRunner.getWebDriver().getWindowHandles().size() > 1) {
            Selenide.switchTo().window(title);
        }
    }
}
