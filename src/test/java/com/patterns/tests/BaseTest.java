package com.patterns.tests;

import com.helpers.PropertyReader;
import com.patterns.driver_factory.DriverFactory;
import com.patterns.steps.SearchSteps;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;

import java.util.concurrent.TimeUnit;

public class BaseTest {
    private static WebDriver driver;
    public SearchSteps steps;

    @DataProvider(name = "dataProviderArray")
    public Object[][] dataProviderKeyWords() {
        return new Object[][]{
                {"selenium"}, {"selenide"},
                {"css"}, {"xpath"},
        };
    }

    @DataProvider(name = "dataProviderArray_words")
    public Object[][] dataProviderKeyWords_words() {
        return new Object[][]{
                {"selenium web driver"}, {"selenide framework"},
                {"css cascading style sheet"}, {"xpath xml path language"},
        };
    }

    // ! With that DataProvider. Button in searchField dnt displayed.
    @DataProvider(name = "dataProviderArray_copyCopyCopy")
    public Object[][] dataProviderKeyWords_copyCopyCopy() {
        return new Object[][]{
                {"selenium selenium selenium"}, {"selenide selenide selenide"},
                {"css css css css css css"}, {"xpath xpath xpath xpath xpath xpath"},
        };
    }

    // ............................................................................

    public static WebDriver getDriver() {
        return driver;
    }

    // ............................................................................

    @BeforeClass
    public void setUp() {
        driver = DriverFactory.getDriver(PropertyReader.getBrowser()); // Browser.CHROME
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get(PropertyReader.getBaseUrl()); // "https://www.google.com"

        if (PropertyReader.isBrowserWindowMaximize()) driver.manage().window().maximize();

        steps = new SearchSteps();
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }

    @AfterMethod
    public void goBack() {
        driver.navigate().back();
    }
}