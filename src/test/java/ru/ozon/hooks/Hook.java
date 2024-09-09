package ru.ozon.hooks;

import com.codeborne.selenide.Selenide;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import ru.ozon.utils.Utils;

public class Hook {

    @Before
    public void openBrowser(){
        Selenide.open(Utils.readProperties().getProperty("ozonBaseUrl"));
    }

    @After
    public void closeBrowser(){
        Selenide.closeWebDriver();
    }
}
