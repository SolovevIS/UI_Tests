package ru.selfInit.hooks;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeAll;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import ru.selfInit.utils.Driver;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class Hook {

    @BeforeAll
    public static void cleanScreens(){
        try {
            Files.walk(Path.of("src\\test\\resources\\screenshots")).filter(Files::isRegularFile).forEach(x -> {
                try {
                    Files.delete(x);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });
        } catch (IOException e){
            e.printStackTrace();
        }
    }

    @Before
    public static void startDriver(){
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        Driver.collectables.put("driver", driver);
    }

    @After
    public static void closeDriver(){
        WebDriver driver = (WebDriver) Driver.collectables.get("driver");
        driver.close();
        Driver.collectables.remove("driver");
    }
}
