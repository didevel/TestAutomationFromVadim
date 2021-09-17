package com.patterns;

import com.patterns.tests.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class UseJavaScriptTest extends BaseTest {

    @Test
    public void clickOnElementJavaScriptTest() {
        WebDriver driver = getDriver();
        driver.get("https://www.google.com");

        WebElement element = driver.findElement(By.name("btnK"));
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click();", element);
    }

    @Test
    public void sendKeysWithJavaScriptTest() {
        WebDriver driver = getDriver();
        driver.get("https://www.google.com");

        String text = "selenium";
        WebElement field = driver.findElement(By.name("q"));
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].value= ' " + text + " ' ", field);
    }
}