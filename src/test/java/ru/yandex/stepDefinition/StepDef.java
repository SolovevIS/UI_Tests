package ru.yandex.stepDefinition;


import io.cucumber.java.en.And;
import ru.yandex.utils.Driver;
import ru.yandex.utils.Utils;

public class StepDef {

    @And("открыть страницу яндекс маркета")
    public void openYandexPage(){
        Driver driver = new Driver();
        driver.getDriverFromCollectables().get(Utils.readProperties("driverProperties.properties").getProperty("yandexMarketBaseUrl"));
    }

    @And("браузер ждет \"(.*)\" секунд$")
    public void driverTimeout(String seconds){
        Utils.timeout(Integer.parseInt(seconds));
    }
    @And("закрыть браузер")
    public void closeBrowser(){
        Driver driver = new Driver();
        driver.getDriverFromCollectables().close();
    }

    @And("дождаться появление элемента \"(.*)\" на странице и кликнуть по нему$")
    public void openCatalog(String xpath){
        Driver driver = new Driver();
        driver.clickOnElement(xpath);
    }

    @And("навести курсор на элемент \"(.*)\"$")
    public void moveView(String xpath){
        Driver driver = new Driver();
        driver.moveToElement(xpath);
    }

    @And("сделать скриншот страницы \"(.*)\"$")
    public void makeScreenshot(String pageType){
        Utils.saveScreenshot(pageType);
    }

    @And("ввести текст \"(.*)\" в поле \"(.*)\"$")
    public void enterText(String price, String xpath){
        Driver driver = new Driver();
        driver.moveToElement(xpath);
        driver.sendTextToField(price, xpath);
    }

    @And("кликнуть на элемент \"(.*)\"$")
    public void clickOnElement(String xpath){
        Driver driver = new Driver();
        driver.clickOnElement(xpath);
    }

    @And("дождаться в течении \"(.*)\" секунд появление элемента \"(.*)\" на странице$")
    public void waitingForElement(String seconds, String xpath){
        Driver driver = new Driver();
        driver.simpleWaitForElement(seconds, xpath);
    }
}
