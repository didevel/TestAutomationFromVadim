package com.use_oop_in_test;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class CheckFirstResultPageOnTheGoogle extends BaseTest_oop {

    @Test
    public void checkAllResultsOthTheFirstPage() {
        WebElement searchField = chromeDriver.findElement(By.name("q"));
        searchField.sendKeys("selenium");
        searchField.sendKeys(Keys.RETURN);

        WebElement resultsHtmlBox = chromeDriver.findElement(By.id("search"));
        List<WebElement> searchResults = resultsHtmlBox.findElements(By.className("g"));

        boolean flag = true;
        for (WebElement element : searchResults) {
            String currentResultLine = element.getText().toLowerCase();
            if (!currentResultLine.contains("selenium") & !currentResultLine.trim().isEmpty()) {
                System.out.println("is::::::::::::::::::::::::::::: " + currentResultLine);
                flag = false;
            }
        }

        Assert.assertTrue(flag, "selenium, dnt contains in all elements");
//        ListAssert<WebElement> selenium = Assertions.assertThat(searchResults).as("").contains("selenium");

    }
}