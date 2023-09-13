package com.onesuite.utilities;

import io.appium.java_client.windows.WindowsDriver;
import io.appium.java_client.windows.WindowsElement;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;


import static java.lang.Integer.parseInt;

public class OpenAppDriver {

    private OpenAppDriver() {
    }

    private static WindowsDriver<WindowsElement> winDriver;

    public static WindowsDriver<WindowsElement> getWinDriver() {

        if (winDriver == null) {
            try {
                DesiredCapabilities capability = new DesiredCapabilities();

                capability.setCapability("ms:experimental-webdriver", true);
                capability.setCapability("app", "Root");
                capability.setCapability("platformName", "Windows");
                capability.setCapability("deviceName", "Windows10Machine");
                winDriver = new WindowsDriver<>(new URL("http://127.0.0.1:4723"), capability);

                WindowsElement windowsElement = winDriver.findElementByXPath("//*[starts-with(@Name,'Strata VIEW')]");
                String tempWindowHandle = windowsElement.getAttribute("NativeWindowHandle");
                int num = parseInt(tempWindowHandle);
                String topLevelWindowHandle1 = Integer.toHexString(num);

                DesiredCapabilities capability1 = new DesiredCapabilities();

                capability1.setCapability("deviceName", "WindowsPC");
                capability1.setCapability("appTopLevelWindow", topLevelWindowHandle1);
                winDriver = new WindowsDriver<>(new URL("http://127.0.0.1:4723"), capability1);
                winDriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
                winDriver.manage().window().maximize();
            } catch (MalformedURLException e) {
                throw new RuntimeException(e);
            }
        }

        return winDriver;
    }

    public static void closeWinDriver() {
        if (getWinDriver() != null) {
            getWinDriver().quit();

        }
    }

    private static void start() {
        try {
            Desktop desktop = Desktop.getDesktop();
            File file = new File("C:\\Program Files (x86)\\Windows Application Driver\\WinAppDriver.exe");
            /* Check if there is support for Desktop or not */
            if (!Desktop.isDesktopSupported()) {
                System.out.println("not supported");
                return;
            }

            if (file.exists()) {
                System.out.println("Open WinAppDriver.exe\n");
                desktop.open(file);
            }
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Encountered Exception\n");
            throw new RuntimeException(e);
        }
    }

    public static void stop() {
        try {
            ProcessBuilder processBuilder = new ProcessBuilder("taskkill ", "/f", "/IM", "WinAppDriver.exe");
            processBuilder.start();
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }


    public static void main(String[] args) throws InterruptedException {


        OpenAppDriver.start();

        Actions act = new Actions(OpenAppDriver.getWinDriver());
        Thread.sleep(500);
        Thread.sleep(20000);
        System.out.println(OpenAppDriver.getWinDriver().getTitle());
        WebElement elementWin = OpenAppDriver.getWinDriver().findElementByName(" Scheduler View ");
        elementWin.click();
        Thread.sleep(500);
        act.moveByOffset(-100, 200).doubleClick().build().perform();
        Thread.sleep(5000);
        OpenAppDriver.getWinDriver().findElementByName("Cancel").click();
        Thread.sleep(500);
        act.moveToElement(elementWin).perform();
        act.moveByOffset(-100, 250).doubleClick().build().perform();
        OpenAppDriver.getWinDriver().findElementByName("Cancel").click();

        OpenAppDriver.getWinDriver().close();
        OpenAppDriver.getWinDriver().findElementByName("No").click();

        OpenAppDriver.closeWinDriver();
        OpenAppDriver.stop();
    }

}






