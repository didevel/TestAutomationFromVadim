package com.patterns.driver_factory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.opera.OperaDriver;

import java.io.File;
import java.util.Properties;

public class DriverFactory {
    private static WebDriver driver;
    private static final String RESOURCES_PATH = "src/test/resources/drivers/";

    public static WebDriver getDriver(Browser browser) {
        File file;
        Properties properties = System.getProperties();

        switch (browser) {
            case CHROME: // GOOD
                file = new File(RESOURCES_PATH + "chromedriver.exe");
                properties.put("webdriver.chrome.driver", file.getAbsolutePath());
                driver = new ChromeDriver();
                break;
            case IE: // run session but dnt work
                file = new File(RESOURCES_PATH + "IEDriverServer_32.exe");
                properties.put("webdriver.ie.driver", file.getAbsolutePath());
                driver = new InternetExplorerDriver();
                break;
            case FIREFOX: // run and work but with a-lot errors
                file = new File(RESOURCES_PATH + "geckodriver_32.exe");
                properties.put("webdriver.gecko.driver", file.getAbsolutePath());
                driver = new FirefoxDriver();
                break;
            case OPERA: // GOOD
                file = new File(RESOURCES_PATH + "operadriver_32.exe");
                properties.put("webdriver.opera.driver", file.getAbsolutePath());
                driver = new OperaDriver();
                break;
            case EDGE: // GOOD
                file = new File(RESOURCES_PATH + "msedgedriver_32.exe");
                properties.put("webdriver.edge.driver", file.getAbsolutePath());
                driver = new EdgeDriver();
                break;
        }
        System.setProperties(properties);

        return driver;
    }
}