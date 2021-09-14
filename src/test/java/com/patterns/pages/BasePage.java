package com.patterns.pages;

import com.patterns.tests.BaseTest;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {
    protected WebDriver driver;
    public final WebDriverWait webDriverWait;
    public final Actions actions;
    public final JavascriptExecutor javascriptExecutor;

    public BasePage() {
        this.driver = BaseTest.getDriver();
        // lazy initialization _ for correct use @FindBy
        PageFactory.initElements(driver, this);
        // in real prj recommended timeOut more than > 5
        this.webDriverWait = new WebDriverWait(driver, 20);
        this.actions = new Actions(driver);
        this.javascriptExecutor = (JavascriptExecutor) driver;
    }
}