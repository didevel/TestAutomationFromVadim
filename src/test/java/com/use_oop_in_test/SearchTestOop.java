package com.use_oop_in_test;

import org.assertj.core.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class SearchTestOop extends BaseTest_oop {

    @Test(dataProvider = "seleniumSearchDP")
    public void openGoogleAndUseDataProvider(String text) {
        WebElement searchField = chromeDriver.findElement(By.name("q"));
        searchField.clear();
        searchField.sendKeys(text); // "selenium java"
        searchField.sendKeys(Keys.RETURN);

        WebElement resultRow = chromeDriver.findElement(By.xpath("//div[@class='g']//h3"));
        Assertions.assertThat(resultRow.isDisplayed()).as("Element has not been displayed!").isTrue();

        Assertions.assertThat(resultRow.getText()).isNotEmpty()
                .as("wrong text in search result")
                .containsIgnoringCase("selenium");
    }


    @Test
    public void openGoogleOrgContainsFeelingLuchyButtonTest() {
        WebElement feelingLuchyButton = chromeDriver.findElement(By.name("btnK"));
//        assertEquals(feelingLuchyButton.getAttribute("value"),
//                "I'm Feeling Lucky", "Wrong text has been displayed!");
        assertEquals(feelingLuchyButton.getAttribute("value"),
                "Поиск в Google", "Wrong test has been displayed!");
    }

//    @Ignore
    @Test
    public void windowSizeExperimental() {
        chromeDriver.manage().window().maximize();
        Dimension size = chromeDriver.manage().window().getSize();
        // height: 1056, width: 2576
        System.out.println("height: " + size.height + ", width: " + size.width);

        chromeDriver.manage().window().fullscreen();
        Dimension size2 = chromeDriver.manage().window().getSize();
        // size 2 height: 1080, width: 2560
        System.out.println("size 2 height: " + size2.height + ", width: " + size2.width);

        chromeDriver.manage().window().setSize(new Dimension(300, 300));
    }
}