package com.helpers;

import org.openqa.selenium.*;

import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.util.List;

public class WebDriverUtils {
    private WebDriver driver;

    public WebDriverUtils() {
    }

    public WebDriverUtils(WebDriver driver) {
        this.driver = driver;
    }

    // Custom waiter
    public boolean isElementFound(By by, int timeOut) throws InterruptedException {
        return isElementFound(by, timeOut, driver);
    }

    public static boolean isElementFound(By by, int timeOut, WebDriver driver) throws InterruptedException {
        List<WebElement> elements = driver.findElements(by);
        for (int i = 0; (i < timeOut) && (elements.size() == 0); i++) {
            Thread.sleep(1000);
            elements = driver.findElements(by);
        }
        return elements.size() > 0;  // !elements.isEmpty()
    }

    public static boolean waitForElement(WebElement element, int timeOut) throws InterruptedException {
        for (int i = 0; i < timeOut * 2; i++) {
            if (element.isEnabled() & element.isDisplayed()) return true;
            Thread.sleep(500);
        }
        return false;
    }

    // Simulating CTRL + V    action
    public static void pasteTextToElementFromClipboard(WebElement element, String text) {
        // copy text to memory buffer
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Clipboard systemClipboard = toolkit.getSystemClipboard();
        StringSelection stringSelection = new StringSelection(text);
        systemClipboard.setContents(stringSelection, null);

        // paste it to the field
        element.sendKeys(Keys.CONTROL, "v");
    }

    public static void clickWithJavaScript(WebElement element, JavascriptExecutor executor) {
        executor.executeScript("arguments[0].click()", element);
    }
}