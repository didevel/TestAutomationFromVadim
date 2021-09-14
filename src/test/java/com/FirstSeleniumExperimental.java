package com;

import com.helpers.StringUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;

import java.io.File;
import java.util.List;
import java.util.Properties;

public class FirstSeleniumExperimental {
    private ChromeDriver chromeDriver;

    @Test
    public void searchInGoogleAndGetFromFirstLineResult() {
        chromeDriver.get("https://www.google.com");
        WebElement q_uery = chromeDriver.findElement(By.name("q"));
        q_uery.sendKeys("Selenium");
        q_uery.sendKeys(Keys.RETURN);

        WebElement element = chromeDriver.findElement(By.xpath("//div[@class='g']//h3"));
        System.out.println(element.getText());
        System.out.println(element.getAttribute("class"));
    }

    @Test
    public void searchInGoogleExpTest() {
        chromeDriver.navigate().to("https://www.google.com");
        WebElement qInput = chromeDriver.findElement(By.name("q"));
        qInput.clear();
//        qInput.sendKeys("Selenium is must");
        qInput.sendKeys("Selenium");
        qInput.sendKeys(Keys.RETURN);

        WebElement searchStatResult = chromeDriver.findElement(By.id("result-stats"));
        String textResultStat = searchStatResult.getText();
        // or  88 000 000 (0,40 сек.)
//        System.out.println(textResultStat); // Результатов: примерно 34 000 000 (0,39 сек.)

        String stringNumbersFromText = StringUtil.getStringNumbersFromText(textResultStat);
        String result = StringUtil.stringSplitEvery(3, stringNumbersFromText, ".");
        System.out.println(result); // Результатов: примерно 34 000 000 (0,39 сек.)
    }

    @Test
    public void searchInGoogleFullStepsImitationTest() {
        chromeDriver.navigate().to("https://www.google.com");
        WebElement searchField = chromeDriver.findElement(By.name("q"));// lst-ib
        searchField.sendKeys("selenium java");
        // press enter on the keyboard
        searchField.sendKeys(Keys.RETURN);

        // click to search btn
//        WebElement searchBtn = chromeDriver.findElement(By.name("btnK"));
//        searchBtn.click();
    }

    @Test
    public void openGoogleComInChromeTest() {
//        new InternetExplorerDriver() // or
        chromeDriver.navigate().to("https://www.google.com");
//        chromeDriver.get("https://www.google.com"); // or
        System.out.println(chromeDriver.getTitle() + "page has been opened"); //
//        waitForFrameToAcceptCookie();
        WebElement searchField = chromeDriver.findElement(By.name("q"));
        searchField.sendKeys("java");
        searchField.submit(); // enter
//        searchField.click();
    }

    @Test
    public void openGoogleComButtonCssLocatorTest() {
        chromeDriver.navigate().to("https://www.google.com");
        // a.gb_C    or    a[title='Google apps'] - dnt wrk if not ENG
//        WebElement btn = chromeDriver.findElement(By.cssSelector("a.gb_C"));
        WebElement btn = chromeDriver.findElement(By.cssSelector("div#gbwa a"));
        btn.click(); // enter
    }

    @Test
    public void openGoogleComButtonXpathLocatorTest() {
        chromeDriver.navigate().to("https://www.google.com");
        // ElementNotInteractableException - element, not clickable
//        WebElement btn = chromeDriver.findElement(By.xpath("//input[@name=\"btnK\"]"));

        List<WebElement> elements = chromeDriver.findElements(By.xpath("//input[@name=\"btnK\"]"));
        WebElement btn = elements.get(1);
        btn.click(); // enter
    }


    // ....
    @Test
    public void openGoogleChromeAndSelectInput() {
        // CSS locator
        // input.gLFyf.gsfi
        // Xpath locator
        // //div/input[@type='text']
    }

    @Test
    public void youTubeChallengeTest() {
        chromeDriver.navigate().to("https://www.youtube.com");
        // input#search.gsfi.ytd-searchbox
        // input#search
//        WebElement searchId = chromeDriver.findElement(By.id("search")); // submit() - dnt wrk
        // dnt search field
//        WebElement searchId = chromeDriver.findElement(By.cssSelector("input#search.gsfi.ytd-searchbox"));
        WebElement searchId = chromeDriver.findElement(By.cssSelector("input#search"));
        searchId.sendKeys("CSS селекторы");
        searchId.submit();
    }

    @Test
    public void gitHubSubmitTest() {
        chromeDriver.navigate().to("https://www.github.com");
//        input.form-control.input-sm.header-search-input.jump-to-field.js-jump-to-field.js-site-search-focus
        WebElement nameQ = chromeDriver.findElement(By.name("q"));
        nameQ.sendKeys("selenium");
        nameQ.submit();

        WebElement code = chromeDriver.findElement(By.linkText("Code"));
        code.click();

    }


    // ...............................................................................................................

    private void waitForFrameToAcceptCookie() {
        // in browser click, to accept cookie
        new WebDriverWait(chromeDriver, 10).until(ExpectedConditions
                .visibilityOfElementLocated(By.id("cnsw"))); // waite for Window
        chromeDriver.switchTo().frame(0);
        chromeDriver.findElement(By.id("introAgreeButton")).click(); // click inside frame
        chromeDriver.switchTo().defaultContent();  // comeback from frame to main window
        // ...
    }

    @AfterMethod
    public void backForAnotherTest() {
        chromeDriver.navigate().back();
    }

    @BeforeTest
    public void setUp() {
        File file = new File("src/test/resources/drivers/chromedriver.exe");
        Properties properties = System.getProperties();
        properties.put("webdriver.chrome.driver", file.getAbsolutePath());
        System.setProperties(properties);
        this.chromeDriver = new ChromeDriver();
    }

    @AfterTest
    public void closeAll() {
        chromeDriver.quit(); // close all - better
//        chromeDriver.close(); // close tab
    }
}