package com.onesuite.utilities;

import io.appium.java_client.windows.WindowsDriver;
import io.appium.java_client.windows.WindowsElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import static java.lang.Integer.parseInt;

public class ChatGPTWinDriver {
    private static WindowsDriver<WindowsElement> winDriver;

    public static WebDriver chatGPTWinDriver() {
        if (winDriver == null) {
            try {
                DesiredCapabilities capabilities = new DesiredCapabilities();
                capabilities.setCapability("app",
                        "C:\\Automation\\CypressAutomation\\EDP_CypressAutomation_Old\\E2E\\SBMS\\Desktop\\SBMSNET.EXE");
                // start();
                winDriver = new WindowsDriver<>(new URL("http://127.0.0.1:4723"), capabilities);

                // Perform your testing actions here

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return winDriver;
    }

    public static void closeChatGPTWinDriver() {
        if (chatGPTWinDriver() != null) {
            chatGPTWinDriver().quit();
            winDriver = null;
        }
    }

    public static void start() {
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
            winDriver = null;
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    private static WindowsDriver<WindowsElement> openWinDriver;

    public static WindowsDriver<WindowsElement> getOpenWinDriver() {

        if (openWinDriver == null) {
            try {
                DesiredCapabilities capability = new DesiredCapabilities();

                capability.setCapability("ms:experimental-webdriver", true);
                capability.setCapability("app", "Root");
                capability.setCapability("platformName", "Windows");
                capability.setCapability("deviceName", "Windows10Machine");
                openWinDriver = new WindowsDriver<>(new URL("http://127.0.0.1:4723"), capability);

                WindowsElement windowsElement = openWinDriver
                        .findElementByXPath("//*[starts-with(@Name,' SBMS for Spot')]");
                String tempWindowHandle = windowsElement.getAttribute("NativeWindowHandle");
                int num = parseInt(tempWindowHandle);
                String topLevelWindowHandle1 = Integer.toHexString(num);

                DesiredCapabilities capability1 = new DesiredCapabilities();

                capability1.setCapability("deviceName", "WindowsPC");
                capability1.setCapability("appTopLevelWindow", topLevelWindowHandle1);
                openWinDriver = new WindowsDriver<>(new URL("http://127.0.0.1:4723"), capability1);
                openWinDriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
                openWinDriver.manage().window().maximize();
            } catch (MalformedURLException e) {
                throw new RuntimeException(e);
            }
        }

        return openWinDriver;
    }

    public static void main(String[] args) {
        start();
        ChatGPTWinDriver.getOpenWinDriver().findElement(By.name("Buy")).click();
    }

}
