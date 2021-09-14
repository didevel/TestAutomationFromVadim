package com.patterns.driver_factory;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.File;
import java.util.Properties;

public class TmpUseDriverFactoryPattern {

    @Test
    public void driverFactoryWayTest() {
        // Get Driver using Factory
//        WebDriver driver = DriverFactory.getDriver(Browser.CHROME);

        // OR get Driver by Enum
//        WebDriver driver = Browser_My.CHROME.getDriver();
        // Or use like that..
        WebDriver driver = Browser_My.getDriver(Browser_My.OPERA);
        some_test(driver);
    }

    @Test
    public void earlyWayTest() {
        File file = new File("src/test/resources/drivers/chromedriver.exe");
        Properties properties = System.getProperties();
        properties.put("webdriver.chrome.driver", file.getAbsolutePath());
        System.setProperties(properties);

        WebDriver driver = new ChromeDriver();
        some_test(driver);
    }

    private void some_test(WebDriver driver) {
        driver.navigate().to("https://www.google.com");

        WebElement searchField = driver.findElement(By.name("q"));
        searchField.sendKeys("automation");
        searchField.submit();

        try {
            Thread.sleep(1500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        WebElement firstResultOnTheTop = driver.findElement(By.className("g"));

        Assert.assertTrue(firstResultOnTheTop.getText().toLowerCase().contains("automation"),
                "first result page on the top, does not contains expected value!");

        driver.quit();
    }
}