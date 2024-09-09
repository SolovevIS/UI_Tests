package ru.ozon.stepDefinition;

import io.cucumber.java.en.And;
import ru.ozon.pages.MainPage;
import ru.ozon.pages.SmartphonesPage;
import ru.ozon.utils.Utils;

public class StepDefOzon {

    @And("открыть каталог")
    public void openBasePage(){
        MainPage page = new MainPage();
        page.clickOnCategoriesList();
    }

    @And("перейти в раздел электроники")
    public void moveToElectronicCategory(){
        MainPage page = new MainPage();
        page.moveToElectronicCategory();
    }

    @And("выбрать подраздел смартфоны")
    public void chooseSmartphones(){
        MainPage page = new MainPage();
        page.clickOnSmartphones();
    }

    @And("селенид ждет \"(.*)\" секунд$")
    public void selenideHardWait(int seconds){
        Utils.waiting(seconds * 1000);
    }

    @And("кликнуть на кнопку обновить при старте браузера, если необходимо")
    public void clickOnRefreshButton(){
        MainPage page = new MainPage();
        page.clickOnRefreshButton();
    }

    @And("отклонить запрос на добавление адреса, если необходимо")
    public void dismissForAddressRequest(){
        MainPage page = new MainPage();
        page.clickOnDismissForAddress();
    }

    @And("сделать скриншот и назвать его \"(.*)\"$")
    public void makeScreenshot(String name){
        Utils.makeScreenshot(name);
    }

    @And("сменить текущее окно на \"(.*)\", если необходимо$")
    public void changeWindow(String window){
        Utils.swapWindows(window);
    }

    @And("перейти в раздел обувь")
    public void moveToBootsCategory(){
        MainPage page = new MainPage();
        page.moveToBootsCategory();
    }

    @And("перейти в подраздел аквашузы")
    public void moveToAquaBoots(){
        MainPage page = new MainPage();
        page.clickOnWomenAquaBoots();
    }

    @And("выставить минимальную цену в \"(.*)\"$")
    public void setMinimumPrice(String price){
        SmartphonesPage page = new SmartphonesPage();
        page.setLowerPrice(price);
    }

    @And("выставить максимальную цену в \"(.*)\"$")
    public void setMaximumPrice(String price){
        SmartphonesPage page = new SmartphonesPage();
        page.setHigherPrice(price);
    }
}
