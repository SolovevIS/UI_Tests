package ru.yandex.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import ru.yandex.waits.DriverWaits;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

public class Driver {

    public static Map<String, Object> collectables = new HashMap<>();

    WebDriver driver;

    public Driver() {
        this.driver = (WebDriver) collectables.get("driver");
    }

    private void basicActionsBeforeStep(String xpath) {
        DriverWaits wait = new DriverWaits(Integer.parseInt(Utils.readProperties("timeoutProps.properties").getProperty("timeoutBeforeElementIsVisible")));
        wait.waitUntilElementIsVisible(xpath);
        Utils.checkXPath(xpath);

    }

    public void clickOnElement(String xpath) {
        this.basicActionsBeforeStep(xpath);
        getDriverFromCollectables().findElement(By.xpath(xpath)).click();
    }

    public void moveToElement(String xpath) {
        this.basicActionsBeforeStep(xpath);
        Actions action = new Actions(getDriverFromCollectables());
        action.moveToElement(getDriverFromCollectables().findElement(By.xpath(xpath))).build().perform();
    }

    public File makeScreenshot() {
        return ((TakesScreenshot) getDriverFromCollectables()).getScreenshotAs(OutputType.FILE);
    }

    public WebDriver getDriverFromCollectables() {
        return (WebDriver) collectables.get("driver");
    }

    public void sendTextToField(String text, String xpath){
        driver.findElement(By.xpath(xpath)).sendKeys(text);
    }

    public void fastClick(String xpath){
        driver.findElement(By.xpath(xpath)).click();
    }

    public void simpleWaitForElement(String seconds, String xpath){
        DriverWaits waits = new DriverWaits(Integer.parseInt(seconds));
        waits.waitUntilElementIsVisible(xpath);
    }
}