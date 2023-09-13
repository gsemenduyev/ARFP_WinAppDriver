package com.onesuite.utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.IOException;
import java.util.Map;
import java.util.Set;

public class OpenChromeDriver {

    public static void main(String [] args)  {
/*
Always check the port
 **/
        try {
            Runtime.getRuntime().exec("chrome.exe -remote-debugging-port=9014 --user-data-dir=\"C:\\Idea Projects\\OpenChrome\"");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        System.setProperty("webdriver.chrome.driver", "C:\\Users\\gsemen196\\.cache\\selenium\\chromedriver\\win32\\111.0.5563.64\\chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.setExperimentalOption("debuggerAddress", "localhost:9014");

        ChromeDriver driver = new ChromeDriver(options);
        Set<String> handles = driver.getWindowHandles();
        for(String each: handles){
            System.out.println(driver.switchTo().window(each).getTitle());
        }

  //      driver.switchTo().frame("frmMain");
        WebElement sourceText = driver.findElement(By.tagName("textarea"));
        sourceText.sendKeys("Hello");
      //  element.click();


    }
//debuggerAddress=localhost:59475
    public static void main1(String[] args) {
        ChromeOptions options = new ChromeOptions();
        options.setExperimentalOption("debuggerAddress", "localhost:59475");
        WebDriverManager.chromedriver().setup();
        ChromeDriver driver = new ChromeDriver(options);
        Capabilities capabilities = driver.getCapabilities();
        Map<String, Object> asMap = capabilities.asMap();
        asMap.forEach((key, value) -> {
            System.out.println("Key " + key + " Value " + value);
        });
  //      driver.get("https://translate.google.com/");
        WebElement sourceText = driver.findElement(By.tagName("textarea"));
        sourceText.sendKeys("Hello");
    }
}