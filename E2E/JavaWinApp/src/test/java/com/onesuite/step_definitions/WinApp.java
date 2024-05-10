 package com.onesuite.step_definitions;

import com.onesuite.utilities.ChatGPTWinDriver;
import io.cucumber.java.en.Given;
import org.apache.maven.shared.utils.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import io.appium.java_client.windows.WindowsDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import java.net.URL;

import java.io.File;
import java.io.IOException;
import java.util.Set;

public class WinApp {
//    public static void main(String[] args) throws IOException {
//
//        // xcopy Y:\SBMSNET_Eleven_QA
//        // C:\CypressAutomation\EDP_CypressAutomation_Old\E2E\SBMS\Desktop /s
//
//        File sourceLocation = new File("Y:\\SBMSNET_Eleven_QA");
//        File targetLocation = new File("C:\\CypressAutomation\\EDP_CypressAutomation_Old\\E2E\\SBMS\\Desktop");
//
//        FileUtils.copyDirectory(sourceLocation, targetLocation);
//    }

    @Given("Launch View")
    public void launch_view() throws InterruptedException, IOException {
        Thread.sleep(30000);
        ChatGPTWinDriver.chatGPTWinDriver().findElement(By.xpath("//Edit[@AutomationId='txtUserName']")).sendKeys("admins");
        String originalWindow = ChatGPTWinDriver.chatGPTWinDriver().getWindowHandle();
        Thread.sleep(30000);
        ChatGPTWinDriver.chatGPTWinDriver().findElement(By.name("OK")).click();
        Thread.sleep(30000);
        Thread.sleep(10000);
        Set<String> wind = ChatGPTWinDriver.chatGPTWinDriver().getWindowHandles();
        for (String a : wind) {
            if (!a.equals(originalWindow)) {
                ChatGPTWinDriver.chatGPTWinDriver().switchTo().window(a);
            }
        }
        ChatGPTWinDriver.chatGPTWinDriver().findElement(By.name("Buy")).click();
        Thread.sleep(30000);
    }

    @Given("Click on Estimates and Goals button")
    public void click_on_estimates_and_goals_button() {
        Actions act = new Actions(ChatGPTWinDriver.chatGPTWinDriver());
        WebElement ele = ChatGPTWinDriver.chatGPTWinDriver().findElement(By.name("Estimates and Goals"));
        act.doubleClick(ele).perform();
        System.out.println(ChatGPTWinDriver.chatGPTWinDriver().getTitle());
    }

    @Given("Close SBMS")
    public void close_SBMS() throws InterruptedException {
        Thread.sleep(5000);
        ChatGPTWinDriver.chatGPTWinDriver().findElement(By.name("File")).click();
        ChatGPTWinDriver.chatGPTWinDriver().findElement(By.name("Exit SBMS")).click();
    }

    public static void main(String[] args) throws InterruptedException {
        System.out.println("hello");
        for (int i = 0; i < 1000; i++) {
            System.out.println(i + " ---- Hello ");
            ChatGPTWinDriver.start();
            ChatGPTWinDriver.chatGPTWinDriver().findElement(By.xpath("//Edit[@AutomationId='txtUserName']"))
                    .sendKeys("admins");
            System.out.println(ChatGPTWinDriver.chatGPTWinDriver().getTitle());
            String originalWindow = ChatGPTWinDriver.chatGPTWinDriver().getWindowHandle();

            ChatGPTWinDriver.chatGPTWinDriver().findElement(By.name("OK")).click();
            Thread.sleep(10000);
            Set<String> wind = ChatGPTWinDriver.chatGPTWinDriver().getWindowHandles();
            for (String a : wind) {
                if (!a.equals(originalWindow)) {
                    ChatGPTWinDriver.chatGPTWinDriver().switchTo().window(a);
                }
            }
            Thread.sleep(10000);
            ChatGPTWinDriver.closeChatGPTWinDriver();
            ChatGPTWinDriver.stop();
            Thread.sleep(10000);
        }

    }

}
