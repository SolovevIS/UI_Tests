package ru.yandex.runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import ru.yandex.utils.Utils;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "classpath:features",
        tags = "",
        glue = {"ru.yandex.stepDefinition",
                "ru.yandex.hooks"}
)
public class RunnerYandex {
    @BeforeClass
    public static void setUp() {
        System.setProperty("webdriver.chrome.driver", Utils.readProperties("driverProperties.properties").getProperty("driverLocation"));
    }
}
