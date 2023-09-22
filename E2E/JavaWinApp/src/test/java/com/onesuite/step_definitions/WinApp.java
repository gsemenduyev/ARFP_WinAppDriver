package com.onesuite.step_definitions;

import org.apache.maven.shared.utils.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.onesuite.utilities.ChatGPTWinDriver;
import com.onesuite.utilities.Driver;
import com.onesuite.utilities.WinDriver;

import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Set;

public class WinApp {
  public static void main(String[] args) throws IOException {

    // xcopy Y:\SBMSNET_Eleven_QA
    // C:\CypressAutomation\EDP_CypressAutomation_Old\E2E\SBMS\Desktop /s

    File sourceLocation = new File("Y:\\SBMSNET_Eleven_QA");
    File targetLocation = new File("C:\\CypressAutomation\\EDP_CypressAutomation_Old\\E2E\\SBMS\\Desktop");

    FileUtils.copyDirectory(sourceLocation, targetLocation);
  }

  @Given("Launch View")
  public void launch_view() throws InterruptedException, IOException {
    ChatGPTWinDriver.chatGPTWinDriver().findElement(By.xpath("//Edit[@AutomationId='txtUserName']")).sendKeys("admins");
    // WinDriver.getWinDriver().findElementByXPath("//Button[@Name='OK']").click();
    // Thread.sleep(10000);
    // String title = WinDriver.getWinDriver().getTitle();
    // System.out.println(title);
    // Set<String> wind = WinDriver.getWinDriver().getWindowHandles();
    // for (String a : wind) {
    // System.out.println(a);
    // }
    // Actions act = new Actions(WinDriver.getWinDriver());
    // Thread.sleep(500);
    // Thread.sleep(20000);
    // System.out.println(WinDriver.getWinDriver().getTitle());
    // WebElement elementWin = WinDriver.getWinDriver().findElementByName("
    // Scheduler View ");
    // elementWin.click();
    // Thread.sleep(500);
    // act.moveByOffset(-100, 200).doubleClick().build().perform();
    // Thread.sleep(5000);
    // WinDriver.getWinDriver().findElementByName("Cancel").click();
    // Thread.sleep(500);
    // act.moveToElement(elementWin).perform();
    // act.moveByOffset(-100, 250).doubleClick().build().perform();
    // WinDriver.getWinDriver().findElementByName("Cancel").click();
    //
    // WinDriver.getWinDriver().close();
    // WinDriver.getWinDriver().findElementByName("No").click();

    // WinDriver.closeWinDriver();
    // WinDriver.stop();
  }

}
