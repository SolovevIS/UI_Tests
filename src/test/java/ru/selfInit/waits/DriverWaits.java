package ru.selfInit.waits;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.selfInit.utils.Driver;

import java.time.Duration;

public class DriverWaits {
    Wait<WebDriver> wait;
    WebDriver driver;

    public DriverWaits (int timeoutSeconds){
        this.driver = (WebDriver) Driver.collectables.get("driver");
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutSeconds));
    }

    public void waitUntilElementIsVisible(String xpath){
        this.wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
    }
}
