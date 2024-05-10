package com.onesuite.utilities;

import java.awt.AWTException;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Set;

import javax.imageio.ImageIO;

import org.openqa.selenium.By;

public class ScreenshotUtility {
    public static void captureScreenshot(String screenshotPath) {
        try {
            Robot robot = new Robot();
            Rectangle screenRect = new Rectangle(Toolkit.getDefaultToolkit().getScreenSize());
            BufferedImage screenshot = robot.createScreenCapture(screenRect);
            ImageIO.write(screenshot, "png", new File(screenshotPath));
        } catch (AWTException | IOException e) {
            e.printStackTrace();
        }
    }
}
