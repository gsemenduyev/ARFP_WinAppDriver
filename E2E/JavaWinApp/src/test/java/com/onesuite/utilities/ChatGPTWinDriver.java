package com.onesuite.utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.URL;

public class ChatGPTWinDriver {

    public static WebDriver chatGPTWinDriver() {
        WebDriver driver = null;

        try {
            DesiredCapabilities capabilities = new DesiredCapabilities();
            capabilities.setCapability("app",
                    "C:\\CypressAutomation\\EDP_CypressAutomation_Old\\E2E\\SBMS\\Desktop\\SBMSNET.EXE");

            driver = new RemoteWebDriver(new URL("http://127.0.0.1:4723"), capabilities);

            // Perform your testing actions here

        } catch (Exception e) {
            e.printStackTrace();
        }
        return driver;
    }
}
