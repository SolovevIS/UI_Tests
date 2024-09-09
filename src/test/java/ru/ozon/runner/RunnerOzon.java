package ru.ozon.runner;

import com.codeborne.selenide.Configuration;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "classpath:features",
        tags = "@ozon-filters",
        glue = {"ru.ozon.stepDefinition",
                "ru.ozon.hooks"}
)
public class RunnerOzon {

    @BeforeClass
    public static void configuration() {
        Configuration.browserSize = "2560x1440";
        Configuration.timeout = 5000;
        Configuration.reportsFolder = "src/test/resources/screenshots";
    }
}
