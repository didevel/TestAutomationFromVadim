package com.assert_google;

import org.assertj.core.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.File;
import java.util.Properties;

public class AssertTestsInGoogle {
    private ChromeDriver chromeDriver;

    @Test
    public void googleAssertWords() {
        chromeDriver.navigate().to("https://www.google.com");
        WebElement q = chromeDriver.findElement(By.name("q"));
        q.sendKeys("selenium webdriver");
        q.sendKeys(Keys.RETURN);

        WebElement g = chromeDriver.findElement(By.className("g"));
        boolean contains = g.getText().toLowerCase().contains("selenium");
        System.out.println("contains: " + g.getText());

        Assert.assertTrue(g.isDisplayed(), "Element has not been displayed!");
//        Assert.assertEquals(g.getText().toLowerCase(), "selenium", "Wrong text has been displayed!");


        // Use TestNG
        Assert.assertTrue(contains, "dnt contains selenium");

        // Use AssetJ
        Assertions.assertThat(g.getText().toLowerCase())
                .isNotEmpty().
                as("dnt contains selenium")
                .contains("selenium", "webdriver");
    }

    // ...............................................................................

    @BeforeTest
    public void setUp() {
        File file = new File("src/test/resources/drivers/chromedriver.exe");
        Properties properties = System.getProperties();
        properties.put("webdriver.chrome.driver", file.getAbsolutePath());
        System.setProperties(properties);
        this.chromeDriver = new ChromeDriver();
    }

    @AfterTest
    public void closeTests() {
        chromeDriver.quit();
    }
}