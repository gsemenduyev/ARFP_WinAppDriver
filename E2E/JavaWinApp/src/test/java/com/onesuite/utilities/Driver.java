package com.onesuite.utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class Driver {

    private Driver(){}

    private static ThreadLocal<WebDriver> driverPool = new ThreadLocal<>();

    public static WebDriver getDriver(){
        if (driverPool.get() == null){
            synchronized (Driver.class){

                String browserType = ConfigurationsReader.getProperty("browser");

                switch (browserType){
                    case "chrome":
                        WebDriverManager.chromedriver().setup();
                        driverPool.set(new ChromeDriver());
                        driverPool.get().manage().window().maximize();
                        driverPool.get().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
                        break;
                    case "chrome-headless":
                        WebDriverManager.chromedriver().setup();
                        final ChromeOptions options = new ChromeOptions();
                        options.addArguments("--headless");
                        options.addArguments("--window-size=1280,800");
                        driverPool.set(new ChromeDriver(options.setHeadless(true)));
                        WebDriver driver = new ChromeDriver(options);
                        break;
                    case "firefox":
                        WebDriverManager.firefoxdriver().setup();
                        driverPool.set(new FirefoxDriver());
                        driverPool.get().manage().window().maximize();
                        driverPool.get().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
                }
            }
        }
        return driverPool.get();
    }

    public static void closeDriver(){
        if (driverPool.get() != null){
            driverPool.get().quit();
            driverPool.remove();
        }
    }
}


