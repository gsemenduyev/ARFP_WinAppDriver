package com.onesuite.utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.net.URL;

public class ChatGPTWinDriver {
    static WebDriver winDriver = null;
    public static WebDriver chatGPTWinDriver() {
        if (winDriver == null) {
            try {
                DesiredCapabilities capabilities = new DesiredCapabilities();
                capabilities.setCapability("app",
                        "C:\\CypressAutomation\\EDP_CypressAutomation_Old\\E2E\\SBMS\\Desktop\\SBMSNET.EXE");
                start();
                winDriver = new RemoteWebDriver(new URL("http://127.0.0.1:4723"), capabilities);

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

}
