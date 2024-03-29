package testcases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.ExamplePOM;


import java.io.File;
import java.util.concurrent.TimeUnit;


public class ExampleTestPOM {

    private WebDriver driver;

    ExamplePOM map;

    @BeforeClass
    public void setup() {
        /** Be sure you set the correct path name that
         *  points to the location of your chromedriver
         */

        System.setProperty("webdriver.chrome.driver", "/Users/muhammadamin/Desktop/chromedriver");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("no-sandbox");
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get("https://kubra.io/stormcenter/views/f362d0d7-4493-4d66-bdd5-6b66609744b7");
        map = new ExamplePOM(driver);
    }

    @Test()
    public void checkHeaderText () {
        map.checkLogo();
    }

    @AfterClass
    public void cleanup () {
        driver.quit();
    }
}
