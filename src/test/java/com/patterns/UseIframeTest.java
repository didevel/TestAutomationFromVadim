package com.patterns;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

import java.util.List;

public class UseIframeTest {
    @Ignore
    @Test
    public void frameTest() {
        WebDriverManager.chromedriver().setup();
        WebDriver webDriver = new ChromeDriver();
        webDriver.get("https://www.amazon.com/");

        List<WebElement> iframes = webDriver.findElements(By.tagName("iframe"));
        System.out.println("iframes: " + iframes.isEmpty()); // Empty

//        getSomeAttribute(webDriver);

        JavascriptExecutor javascriptExecutor = (JavascriptExecutor) webDriver;
        List<WebElement> elements = (List<WebElement>)
                javascriptExecutor.executeScript("return document.getElementsByTagName('iframe')");
        System.out.println("js elements : " + elements.isEmpty()); // Found

        List<WebElement> elements2 = (List<WebElement>)
                javascriptExecutor.executeScript("return document.querySelectorAll('iframe')");
        System.out.println("j2 elements: " + elements2.isEmpty()); // Found

        System.out.println("title current page: " + webDriver.getTitle()); // Amazon.com. Spend less. Smile more.

        //............
        WebElement elementId = webDriver.findElement(By.id("DAsis"));
        System.out.println("elementId: " + elementId);

        WebDriver frame = webDriver.switchTo().frame(elementId);
        System.out.println("title from iframe: " + frame.getTitle()); // Amazon.com. Spend less. Smile more.

//        webDriver.switchTo().parentFrame();
//        webDriver.switchTo().defaultContent()
    }


    private void getSomeAttribute(WebDriver webDriver) {
        //        webDriver.get("https://www.google.com");

        //        WebElement element = webDriver.findElement(By.cssSelector("svg.gb_Ve"));
//        System.out.println("element: " + element.getText());

        List<WebElement> btn = webDriver.findElements(By.name("btnK"));
        String attribute = btn.get(0).getAttribute("aria-label");
        System.out.println("attribute: " + attribute); // Поиск в Google
    }
}
