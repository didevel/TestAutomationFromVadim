package com.web_driver_manager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;

// try to fix problem with EI
public class OpenHelloSeleniumBlogInInternetExplorer {
    public static void main(String[] args) {
        WebDriver driver = null;

        File IEDriver = new File("E:\\OneDrive\\Dropbox\\GitHub\\Liubimenko_Java\\LearnAutomation\\src\\test\\resources\\drivers\\IEDriverServer_32.exe");
        System.setProperty("webdriver.ie.driver", IEDriver.getAbsolutePath());
        DesiredCapabilities capabilities = DesiredCapabilities.internetExplorer();
        capabilities.setCapability(InternetExplorerDriver.
                INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
        driver = new InternetExplorerDriver(capabilities);

//        driver.get("http://helloselenium.blogspot.com");
        driver.get("https://www.google.com");
//        driver.manage().window().maximize();

//        WebElement element = driver.findElement(By.id("main-menu"));

        WebElement q = driver.findElement(By.className("q"));

        System.out.println(driver.getTitle());
        driver.quit();
    }
}