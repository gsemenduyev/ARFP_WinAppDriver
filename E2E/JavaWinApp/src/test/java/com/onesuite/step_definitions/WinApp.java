package com.onesuite.step_definitions;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.onesuite.utilities.WinDriver;

import io.cucumber.java.en.Given;

public class WinApp {

  @Given("Launch View")
  public void launch_view() throws InterruptedException {
    Actions act = new Actions(WinDriver.getWinDriver());
    Thread.sleep(500);
    Thread.sleep(20000);
    System.out.println(WinDriver.getWinDriver().getTitle());
    WebElement elementWin = WinDriver.getWinDriver().findElementByName(" Scheduler View ");
    elementWin.click();
    Thread.sleep(500);
    act.moveByOffset(-100, 200).doubleClick().build().perform();
    Thread.sleep(5000);
    WinDriver.getWinDriver().findElementByName("Cancel").click();
    Thread.sleep(500);
    act.moveToElement(elementWin).perform();
    act.moveByOffset(-100, 250).doubleClick().build().perform();
    WinDriver.getWinDriver().findElementByName("Cancel").click();

    WinDriver.getWinDriver().close();
    WinDriver.getWinDriver().findElementByName("No").click();

    WinDriver.closeWinDriver();
    WinDriver.stop();
  }
}
