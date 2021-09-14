package com.assert_various;

import org.assertj.core.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.File;
import java.util.Properties;

public class AssertBeforeTest {
    private ChromeDriver chromeDriver;

    @Test
    public void searchSelenium() {
        WebElement q = chromeDriver.findElement(By.name("q"));
        q.sendKeys("selenium webdriver");
        q.sendKeys(Keys.RETURN);

        WebElement g = chromeDriver.findElement(By.className("g"));
        System.out.println("contains: " + g.getText());

        Assert.assertTrue(g.isDisplayed(), "Element has not been displayed!");

        Assertions.assertThat(g.getText().toLowerCase())   // Use AssetJ
                .isNotEmpty().
                as("dnt contains selenium")
                .contains("selenium", "webdriver");
    }

    @Test
    public void searchCssLocator() {
        WebElement q = chromeDriver.findElement(By.name("q"));
        q.sendKeys("Q&A css locator");
        q.sendKeys(Keys.RETURN);

        WebElement g = chromeDriver.findElement(By.className("g"));
        System.out.println("contains: " + g.getText());

        Assert.assertTrue(g.isDisplayed(), "Element has not been displayed!");

        Assertions.assertThat(g.getText().toLowerCase())   // Use AssetJ
                .isNotEmpty().
                as("dnt contains selenium")
                .contains("css", "interview");
    }

    // ...............................................................................

    @AfterMethod
    public void goBack(){
        chromeDriver.navigate().back();
    }

    @BeforeTest
    public void setUp() {
        File file = new File("src/test/resources/drivers/chromedriver.exe");
        Properties properties = System.getProperties();
        properties.put("webdriver.chrome.driver", file.getAbsolutePath());
        System.setProperties(properties);
        this.chromeDriver = new ChromeDriver();
        chromeDriver.navigate().to("https://www.google.com");
    }

    @AfterTest
    public void closeTests() {
        chromeDriver.quit();
    }
}