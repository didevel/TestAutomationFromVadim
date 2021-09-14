package com.web_driver_manager;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.Test;

public class UseWebDriverManager {

    public static void main(String[] args) {
        System.out.println("user.dir: " + System.getProperty("user.dir"));
        // E:\OneDrive\Dropbox\GitHub\Liubimenko_Java\LearnAutomation
    }

    @Test
    public void runChromeUsingDriverManager() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.google.com");
//        driver.manage().window().maximize();
        driver.findElement(By.name("q"));
        driver.quit();
    }

//    @Test
    public void runIeUsingDriverManager() { // ERR
        WebDriverManager.iedriver().setup();
        WebDriver driver = new InternetExplorerDriver();
        driver.get("https://www.google.com");

//        driver.manage().window().maximize();
        driver.findElement(By.name("q"));
        driver.quit();
    }

//    @Test
    public void navigateAndSearch() {
//        System.out.println("user.dir: " + System.getProperty("user.dir"));

        System.setProperty("webdriver.ie.driver", "E:\\OneDrive\\Dropbox\\GitHub\\Liubimenko_Java\\LearnAutomation\\src\\test\\resources\\drivers\\IEDriverServer_64.exe");
        WebDriver driver = new InternetExplorerDriver();

//        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
//        WebDriverWait webDriverWait = new WebDriverWait(driver, 3);
//        try {
//            webDriverWait.wait();
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }

        driver.get("http://google.ru");
//        driver.findElement(By.cssSelector("body"));
//        driver.findElement(By.id("lb"));
//        driver.findElement(By.xpath("//input[@class='gsfi'"));

        driver.getTitle();
        driver.quit();
    }
}