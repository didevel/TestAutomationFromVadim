package com.patterns;

import com.patterns.pages.SearchPage;
import com.patterns.pages.SearchResultsPage;
import com.patterns.tests.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class OurTestClass extends BaseTest {

    @Test(dataProvider = "dataProviderArray")
    public void searchByKeyword_FindAll_LinesResultsIsContains_withDataProvider_UseClipboard(String keyWord) {
        steps.searchByKeywordFromCLipboard(keyWord)
                .verifyThatValuesIsContainsIgnoreCaseAndIgnoreSpace(keyWord)
                .verifyThatTopValueIsContains(keyWord);
    }

    @Test(dataProvider = "dataProviderArray")
    public void searchByKeyword_FindAll_LinesResultsIsContains_withDataProvider(String keyWord) {
        steps.searchByKeyword(keyWord)
                .verifyThatValuesIsContainsIgnoreCaseAndIgnoreSpace(keyWord)
                .verifyThatTopValueIsContains(keyWord);
    }

    @Test
    public void searchByKeyword_FindAll_LinesResultsIsContains_withStepsPattern() {
        String keyWord = "Selenium";
        // almost _ like : chain of responsibility
        steps.searchByKeyword(keyWord)
                .verifyThatValuesIsContainsIgnoreCaseAndIgnoreSpace(keyWord)
                .verifyThatTopValueIsContains(keyWord);
    }

    @Test
    public void searchByKeywordSeleniumFindSeleniumFirstLineIsContains_withStepsPattern() {
        steps.searchByKeyword("Selenium")
                .verifyThatValueIsContainsIgnoreCaseSensitive("selenium");
    }

    @Test
    public void searchByKeywordSeleniumHaveToFindSeleniumHqInTop_v2_withPageObjPattern() {
        SearchPage searchPage = new SearchPage();
        searchPage.fillTheSearchField("css locator");
        searchPage.pressEnter();

        WebDriver driver = getDriver();
        List<WebElement> resultURLs = driver.findElements(By.className("g")); // By.xpath("//cite[@class='iUh30']")

        assertThat(resultURLs.get(0).getText())
                .as("css is not the first result!")
                .containsIgnoringCase("css"); // "https://www.seleniumhq.org/"

        SearchResultsPage searchResultsPage = new SearchResultsPage();
        searchResultsPage.assertThatExpectedValueIsContainsIgnoreCaseSensitive("css");
    }

    @Test
    public void searchByKeywordSeleniumHaveToFindSeleniumHqInTop() {
        WebDriver driver = getDriver();

        WebElement searchField = driver.findElement(By.name("q"));
        searchField.sendKeys("Selenium");
        searchField.sendKeys(Keys.RETURN);

        List<WebElement> resultURLs = driver.findElements(By.className("g")); // By.xpath("//cite[@class='iUh30']")

        assertThat(resultURLs.get(0).getText())
                .as("selenium is not the first result!")
                .containsIgnoringCase("selenium"); // "https://www.seleniumhq.org/"
    }
}