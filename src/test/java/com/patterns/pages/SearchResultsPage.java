package com.patterns.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.testng.Assert.assertTrue;

public class SearchResultsPage extends BasePage {
    //    @FindBy(xpath = "//cite[@class='iUh30']")
    // @FindBy(xpath = "[@class='srg']//div[@class='g']//h3") // worked before, but not now
    // @FindBy(xpath = "//div[@class='g']//h3") // if need only head3 elements
    @FindBy(className = "g")
    List<WebElement> searchResultRows_URLs;
//    private final By searchResultURLsBy = By.xpath("//cite[@class='iUh30']");
//        List<WebElement> searchResultURLs = driver.findElements(searchResultURLsBy);

    public void assertThatExpectedValueIsContainsOnSearchTop(String expectedValue) {
        if (searchResultRows_URLs.isEmpty()) {
            try {
                throw new Exception("assertThatExpectedValueIsOnSearchTop dnt have elements!");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        assertTrue(searchResultRows_URLs.get(0).getText().trim().toLowerCase()
                        .contains(expectedValue.trim().toLowerCase()),
                expectedValue + " is not contains, in the first result!");

    }

    public void assertThatExpectedValueIsContainsIgnoreCaseSensitive(String expectedValue) {
        assertThat(searchResultRows_URLs.get(0).getText())
                .as(expectedValue + " - expected value, is not contains")
                .containsIgnoringCase(expectedValue);
    }

    public void assertThatExpectedValuesIsContainsIgnoreCaseAndIgnoreSpace(String expectedValue) {
        String expect = expectedValue.trim().toLowerCase();

        // wait all elements on the page results - it like: searchResultRows_URLs.isDisplayed()
//        webDriverWait.until(ExpectedConditions.visibilityOfAllElements(searchResultRows_URLs));

        assertTrue(searchResultRows_URLs.stream()
                        .filter(v -> !v.getText().isEmpty() & !v.getText().trim().equals(""))
                        .map(v -> v.getText().toLowerCase())
                        .allMatch(v -> v.contains(expect))
                , "all find elements dnt contains expected Value"
        );
    }

}