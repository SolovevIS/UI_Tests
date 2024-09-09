package ru.ozon.pages;

import com.codeborne.selenide.Condition;

import static com.codeborne.selenide.Selenide.*;

public class MainPage {

    private final String categoriesList = "//div[.='Каталог']/parent::div/following-sibling::div";

    private final String electronicCategory = "//span[.='Электроника']/parent::a";

    private final String smartphonesCategory = "//a[.='Смартфоны']";

    private final String refreshButtonBotAllert = "//button[.='Обновить']";

    private final String dismissOnAddressRequest = "//div[.='Не сейчас']/parent::div/following-sibling::div";

    private final String bootsCategory = "//span[.='Обувь']/ancestor::a";

    private final String aquaBoots = "//a[.='Женщинам']/following-sibling::a[.='Аквашузы']";

    public MainPage() {
    }

    public void clickOnCategoriesList() {
        $x(categoriesList).shouldBe(Condition.enabled).click();
    }

    public void moveToElectronicCategory() {
        actions().moveToElement($x(electronicCategory).shouldBe(Condition.visible)).perform();
    }

    public void clickOnSmartphones() {
        $x(smartphonesCategory).shouldBe(Condition.visible).shouldBe(Condition.enabled).click();
    }

    public void clickOnRefreshButton() {
        if (!$x(categoriesList).isDisplayed()) {
            $x(refreshButtonBotAllert).shouldBe(Condition.enabled).shouldBe(Condition.visible).click();
        }
    }

    public void clickOnDismissForAddress() {
            $x(dismissOnAddressRequest).shouldBe(Condition.enabled).click();
    }

    public void moveToBootsCategory(){
        actions().moveToElement($x(bootsCategory).shouldBe(Condition.visible)).perform();
    }

    public void clickOnWomenAquaBoots(){
        $x(aquaBoots).shouldBe(Condition.visible).shouldBe(Condition.enabled).click();
    }
}
