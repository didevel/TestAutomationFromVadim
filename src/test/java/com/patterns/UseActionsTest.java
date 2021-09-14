package com.patterns;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import java.util.List;

import static org.testng.Assert.assertTrue;

//public class UseActionsTest extends BaseTest {
public class UseActionsTest {
    @Test
    public void useActionsAndJavaScriptTest() {
        WebDriverManager.chromedriver().setup();
        ChromeDriver driver = new ChromeDriver();
        driver.get("https://www.google.com");
        // WebDriver driver = getDriver();

        WebElement searchField = driver.findElement(By.name("q"));

        // ............... click to search field with Actions ...............
        Actions builder = new Actions(driver);
        builder.moveToElement(searchField).click().build().perform();

        // ............... insert test to search field with javaScript ...............
        JavascriptExecutor javascriptExecutor = (JavascriptExecutor) driver;
        javascriptExecutor.executeScript("arguments[0].value= ' " + "selenium" + " ' ", searchField);

        // ............... click to enter button with actions click ...............
        // dnt working
        // new Actions(driver).moveToElement(driver.findElement(By.name("btnK"))).click().build().perform();

        // Working )
        new Actions(driver).sendKeys(searchField, Keys.RETURN).build().perform();

        // dnt working _ because element do not clickable
        // WebDriverWait wait1 = new WebDriverWait(driver, 10);
        // WebElement element1 = wait1.until(ExpectedConditions.elementToBeClickable(By.name("btnK")));
        // element1.click();

        // click dnt working ( submit() - working )
        // driver.findElement(By.name("btnK")).click();

        // working..
        // Because Permanently overlaying another WebElement on a WebElement of our interest
        // and JS avoid it
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        // executor.executeScript("arguments[0].click();", driver.findElement(By.name("btnK")));


        // ............... get result page content using javaScript and check if it contains tex used for search ...............
        // jsExperimental(executor, driver);

        List<WebElement> elementList = (List<WebElement>) executor.executeScript("return document.getElementsByClassName('g')");
        // OR
        // List<WebElement> elementList = (List<WebElement>) executor.executeScript("return document.querySelectorAll('g')");

        assertTrue(elementList.stream()
                        .filter(e -> !e.getText().isEmpty() & !e.getText().trim().equals(""))
                        .map(e -> e.getText().toLowerCase())
                        .allMatch(e -> e.contains("selenium")),
                "all find elements, dnt contains expected value"
        );


    }

}