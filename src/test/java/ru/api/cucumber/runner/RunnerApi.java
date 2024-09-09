package ru.api.cucumber.runner;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "classpath:features",
        tags = "@baseApi",
        glue = {"ru.api.cucumber.stepdef"}
)
public class RunnerApi {
}
