package ru.selfInit.runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import ru.selfInit.utils.Utils;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "classpath:features",
        tags="@filters_accessories_yandex",
        glue = {"ru.selfInit.stepDefinition",
                "ru.selfInit.hooks"}
)
 public class Runner {
    @BeforeClass
    public static void setUp(){
        System.setProperty("webdriver.chrome.driver", Utils.readProperties("driverProperties.properties").getProperty("driverLocation"));
    }
}
