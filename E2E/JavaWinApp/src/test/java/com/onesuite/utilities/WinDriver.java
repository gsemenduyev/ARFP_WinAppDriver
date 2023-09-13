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
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

public class WinDriver {

    private WinDriver() {
    }

    private static WindowsDriver<WindowsElement> winDriver;

    public static WindowsDriver<WindowsElement> getWinDriver() {

        if (winDriver == null) {
            try {
                String appPath = "C:\\View_4.0.3\\nx64.exe";

                DesiredCapabilities capability = new DesiredCapabilities();

                capability.setCapability("ms:experimental-webdriver", true);
                capability.setCapability("app", appPath);
                capability.setCapability("platformName", "Windows");
                capability.setCapability("deviceName", "Windows10Machine");
                /* Start WinAppDriver.exe so that it can start listening to incoming requests */
                start();
                winDriver = new WindowsDriver<WindowsElement>(new URL("http://127.0.0.1:4723"), capability);
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


     //   WinDriver.start();
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

    //   closeWinDriver();

    private static WindowsDriver winDriver1;

    public static void main1(String[] args) throws MalformedURLException {

        DesiredCapabilities capability = new DesiredCapabilities();

        capability.setCapability("ms:experimental-webdriver", true);
        capability.setCapability("app", "C:\\View_4.0.3\\nx64.exe");
        capability.setCapability("platformName", "Windows");
        capability.setCapability("deviceName", "Windows10Machine");
        winDriver1 = new WindowsDriver<WindowsElement>(new URL("http://127.0.0.1:4723"), capability);

        AtomicReference<WindowsElement> applicationWindow = null;
        List openWindows = winDriver1.findElementsByName("Window");
        openWindows.stream().filter(it -> it.equals("Strata VIEW for Cable")).forEach(it -> applicationWindow.set((WindowsElement) it));

// Attaching to existing Application Window
        String topLevelWindowHandle = applicationWindow.get().getAttribute("NativeWindowHandle");
        //  topLevelWindowHandle = int.Parse(topLevelWindowHandle).ToString("X");

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("deviceName", "WindowsPC");
        capabilities.setCapability("appTopLevelWindow", topLevelWindowHandle);
        winDriver1 = new WindowsDriver<WindowsElement>(new URL("http://127.0.0.1:4723"), capabilities);


    }
}






