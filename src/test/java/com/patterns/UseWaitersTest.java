package com.patterns;

import com.patterns.driver_factory.Browser;
import com.patterns.driver_factory.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.util.List;

public class UseWaitersTest {

    @Test
    public void useWaiters() {
        WebDriver driver = DriverFactory.getDriver(Browser.CHROME);
        driver.get("https://www.google.com");

        WebDriverWait webDriverWait = new WebDriverWait(driver, 3);

        // check head
        WebElement head = driver.findElement(By.cssSelector("head"));
        webDriverWait.until(ExpectedConditions.invisibilityOf(head)); // невидимость

        // check body
        WebElement body = driver.findElement(By.cssSelector("body"));
        webDriverWait.until(ExpectedConditions.visibilityOf(body)); // видимость

        // search field
        WebElement searchField = driver.findElement(By.name("q"));
        searchField.sendKeys("selenium waiters");

        // check search button
        // By.name("btnK") _ OR _ By.xpath("//input[@name='btnK']")
        List<WebElement> btnElements = driver.findElements(By.name("btnK"));
        // get(1) - this btn under the field, get(0) - this btn enabled, when in searchField is typing
        WebElement btnIsClickable = webDriverWait.until(ExpectedConditions.elementToBeClickable(btnElements.get(0)));
        btnIsClickable.click();

        driver.quit();
    }
}