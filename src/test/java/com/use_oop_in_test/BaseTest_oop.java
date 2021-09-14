package com.use_oop_in_test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;

import java.io.File;
import java.util.Properties;

public abstract class BaseTest_oop {
    protected WebDriver chromeDriver, internetExplorerDriver;

    @DataProvider(name = "seleniumSearchDP")
    public Object[][] seleniumSearchDataProvider() {
        return new Object[][]{
                {"selenium java"}, {"selenium javascript"},
        };
    }

    @AfterMethod
    public void goBack() {
        chromeDriver.navigate().back();
//        internetExplorerDriver.navigate().back();
    }


    @BeforeClass
    public void setUp() {
        File chromeFile = new File("src/test/resources/drivers/chromedriver.exe");
        File iExplorerFile = new File("src/test/resources/drivers/IEDriverServer_32.exe");

        Properties properties = System.getProperties();
        properties.put("webdriver.chrome.driver", chromeFile.getAbsolutePath());
        properties.put("webdriver.ie.driver", iExplorerFile.getAbsolutePath());
        System.setProperties(properties);
        chromeDriver = new ChromeDriver();
//        internetExplorerDriver = new InternetExplorerDriver();

        //...
        chromeDriver.navigate().to("https://www.google.com");
    }

    @AfterClass
    public void tearDown() {
        chromeDriver.quit();
//        internetExplorerDriver.quit();
    }
}