package com.web_driver_manager;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

// Try to use _ failure (( ___ (running but dnt show any browser or window.. )
// https://bonigarcia.dev/webdrivermanager/
// The requirement to use this feature is to have installed a Docker Engine in the machine running the tests.
public class DockerChromeVncTest {
    WebDriver driver;

    WebDriverManager wdm = WebDriverManager.chromedriver().browserInDocker();

    //    @BeforeTest
    void setupTest() {
        driver = wdm.create();
    }

    //    @AfterTest
    void teardown() {
        wdm.quit();
    }

    //    @Test
    void test() {
        driver.get("https://bonigarcia.dev/selenium-webdriver-java/");
//        assertThat(driver.getTitle()).contains("Selenium WebDriver");
        System.out.println("getTitle: " + driver.getTitle());
    }
}