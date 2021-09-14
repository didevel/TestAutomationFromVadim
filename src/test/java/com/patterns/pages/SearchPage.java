package com.patterns.pages;

import com.helpers.WebDriverUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static org.assertj.core.api.Assertions.assertThat;

public class SearchPage extends BasePage {
    //    private final By searchFieldBy = By.name("q");
    @FindBy(name = "q")
    private WebElement searchField;
    @FindBy(name = "btnK")
    private WebElement searchButton;

    @FindBy(xpath = "//body")
    private WebElement pageBody;

    @FindBy(css = "div.XDyW0e")
    private WebElement searchByVoiceButton;

    public void fillTheSearchField(String keyword) {
        searchField.sendKeys(keyword);
    }

    public void pressEnter() {
        searchField.sendKeys(Keys.RETURN);
    }

    public void pasteToSearchFieldFromClipboard(String text) {
        WebDriverUtils.pasteTextToElementFromClipboard(searchField, text);
    }

    public void clickSearchButtonOrPressEnter() {
        try {
//            if (WebDriverUtils.isElementFound(By.name("btnK"), 3, driver)) { // working not for all cases..
            if (WebDriverUtils.waitForElement(driver.findElements(By.name("btnK")).get(0), 3)) {
                WebElement until = webDriverWait.until(ExpectedConditions.elementToBeClickable(searchButton));
                until.click();
            } else {
                pressEnter();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void clickSearchButtonOrPressEnterWithJavaScript() {
        try {
            if (WebDriverUtils.waitForElement(driver.findElements(By.name("btnK")).get(0), 3)) {
                WebElement until = webDriverWait.until(ExpectedConditions.elementToBeClickable(searchButton));
                WebDriverUtils.clickWithJavaScript(searchButton, javascriptExecutor);
            } else {
                pressEnter();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void moveToVoiceSearchButton() {
        actions.moveToElement(searchByVoiceButton).build().perform();
    }

    public void assertThatVoiceSearchTooltipContainsText(String text) {
        // 'Голосовой поиск' or 'Search by voice'
        assertThat(pageBody.findElements(By.xpath("//*[contains(text(), '" + text + "')]")).size())
                .as("Expected tooltip [" + text + "] was not found").isNotZero();
    }
}