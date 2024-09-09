package ru.ozon.pages;

import com.codeborne.selenide.Condition;
import org.openqa.selenium.Keys;

import static com.codeborne.selenide.Selenide.*;

public class SmartphonesPage {

    private final String lowerPrice = "//p[contains(text(),'от')]/preceding-sibling::input";

    private final String higherPrice = "//p[contains(text(),'до')]/preceding-sibling::input";

    public void setLowerPrice(String price){
        clearInput(lowerPrice);
        $x(lowerPrice).shouldBe(Condition.visible).shouldBe(Condition.enabled).setValue(price).pressEnter();
    }

    public void setHigherPrice(String price){
        clearInput(higherPrice);
        $x(higherPrice).setValue(price).pressEnter();
    }

    private void clearInput(String xpath){
        $x(xpath).sendKeys(Keys.CONTROL + "a");
        $x(xpath).sendKeys(Keys.DELETE);
    }
}
