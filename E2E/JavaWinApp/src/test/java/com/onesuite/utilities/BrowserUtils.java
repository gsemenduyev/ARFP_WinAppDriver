package com.onesuite.utilities;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

import static com.onesuite.utilities.Driver.getDriver;
import static org.junit.Assert.assertFalse;

public class BrowserUtils {

    /**
     * Waits for provided element to be clickable
     *
     * @param element Web Element
     * @param timeout seconds
     * @return clickability of web element
     */
    public static WebElement waitForClickability(WebElement element, int timeout, int attempts) {
        WebDriverWait wait = new WebDriverWait(getDriver(), timeout);
        for (int i = 0; i <= attempts; i++) {
            try {
                new WebDriverWait(getDriver(), timeout).until(
                        webDriver -> ((JavascriptExecutor) webDriver).executeScript("return document.readyState").equals("complete"));
                wait.until(ExpectedConditions.elementToBeClickable(element));
                break;
            } catch (ElementNotInteractableException | StaleElementReferenceException | NoSuchElementException |
                     TimeoutException | NullPointerException ignored) {
            }
        }
        return element;
    }

    /**
     * Waits for provided element to be visible
     *
     * @param element Web Element
     * @param timeout seconds
     * @return visibility of web element
     */
    public static WebElement waitForVisibility(WebElement element, int timeout, int attempts) {
        WebDriverWait wait = new WebDriverWait(getDriver(), timeout);
        for (int i = 0; i <= attempts; i++) {
            try {
                new WebDriverWait(getDriver(), timeout).until(
                        webDriver -> ((JavascriptExecutor) webDriver).executeScript("return document.readyState").equals("complete"));
                wait.until(ExpectedConditions.visibilityOf(element));
                break;
            } catch (ElementNotInteractableException | StaleElementReferenceException | NoSuchElementException |
                     TimeoutException ignored) {
            }
        }
        return element;
    }


    /**
     * Retries to send text in to text box
     *
     * @param element  Web Element
     * @param word     any String
     * @param attempts of attempts
     */
    public static void retryingSendKeys(WebElement element, String word, int attempts) {
        for (int i = 0; i <= attempts; i++) {
            try {
                new WebDriverWait(getDriver(), attempts).until(
                        webDriver -> ((JavascriptExecutor) webDriver).executeScript("return document.readyState").equals("complete"));
                waitForVisibility(element, attempts, attempts).sendKeys(word);
                break;
            } catch (ElementNotInteractableException | StaleElementReferenceException | NoSuchElementException |
                     TimeoutException | AssertionError ignored) {
                try {
                    element.clear();
                } catch (StaleElementReferenceException ignored1) {

                }
            }
        }
    }


    /**
     * Gets all options
     *
     * @param element Web Element
     * @return list of Web Elements
     */
    public static List<WebElement> getOptions(WebElement element, int timeout, int attempts) {
        Select select = new Select(waitForVisibility(element, timeout, attempts));
        for (int i = 0; i < attempts; i++) {
            try {
                new WebDriverWait(getDriver(), timeout)
                        .until(driver -> select.getOptions().size() != 0);
                return select.getOptions();
            } catch (ElementNotInteractableException | StaleElementReferenceException | NoSuchElementException |
                     TimeoutException ignored) {
            }
        }
        return null;
    }

    /**
     * Verifies if options box is empty
     *
     * @param element  Web Element
     * @param timeout  seconds
     * @param attempts of attempts
     * @return boolean
     */
    public static boolean waitTillOptionsEmpty(WebElement element, int timeout, int attempts) {
        Select select = new Select(waitForVisibility(element, timeout, attempts));
        boolean options = false;
        for (int i = 0; i < attempts; i++) {
            try {
                new WebDriverWait(getDriver(), timeout)
                        .until(driver -> select.getOptions().isEmpty());
                options = true;
                break;
            } catch (ElementNotInteractableException | StaleElementReferenceException | NoSuchElementException |
                     TimeoutException ignored) {
            }
        }
        return options;
    }


    public static String waitTillTextIsPresent(WebElement element, String text, int timeout, int attempts) {
        WebDriverWait wait = new WebDriverWait(getDriver(), timeout);
        for (int i = 0; i < attempts; i++) {
            try {
                wait.until(ExpectedConditions.textToBePresentInElement(element, text));
                assertFalse(element.getText().isEmpty());
                return element.getText();
            } catch (ElementNotInteractableException | StaleElementReferenceException | NoSuchElementException |
                     TimeoutException ignored) {
            }
        }
        return null;
    }

    public static void launchSteelCloud(int attempts) {
        for (int i = 1; i <= attempts; i++) {
            Driver.getDriver().get(ConfigurationsReader.getProperty("stealCloud"));
            if (Driver.getDriver().getTitle().equals("Order Status")) {
                break;
            } else if (i == attempts) {
                System.out.println(ConfigurationsReader.getProperty("stealCloud") + " wasn't available after " + i + " attempts");
            }
        }
    }

    public static void launchGooglePage(int attempts) {
        for (int i = 1; i <= attempts; i++) {
            Driver.getDriver().get("https://www.google.com/");
            if (Driver.getDriver().getTitle().equals("Google")) {
                break;
            } else if (i == 3) {
                System.out.println("https://www.google.com/ wasn't available after " + i + " attempts");
            }
        }
    }

    public static void launchBVT(int attempts) {
        for (int i = 1; i <= attempts; i++) {
            Driver.getDriver().get(ConfigurationsReader.getProperty("BVT"));
            if (Driver.getDriver().getTitle().equals("Order Status")) {
                break;
            } else if (i == attempts) {
                System.out.println(ConfigurationsReader.getProperty("stealCloud") + " wasn't available after " + i + " attempts");
            }
        }
    }
}

