package com.onesuite.step_definitions;

import com.onesuite.utilities.Driver;
import com.onesuite.utilities.MathUtils;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.List;
import java.util.Objects;
import static com.onesuite.locators.Locator.getElement;
import static com.onesuite.utilities.BrowserUtils.*;
import static com.onesuite.utilities.Driver.getDriver;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class BasePageSteps {
    WebDriver driver = Driver.getDriver();
    private static String currentUser;
    public static String getCurrentUser() {
        return currentUser;
    }
    String currentDate = MathUtils.getCurrentDate();

    @Given("Save current user")
    public void save_current_user() {
        String fullText = getElement("Welcome current user").getText();
        currentUser = fullText.replace("Welcome ", "").replace("!", "");
        assertTrue("Order Status page doesn't contain user name", fullText.contains(currentUser));
    }
    @Given("User lands on {string} page")
    public void user_land_on_page(String title) {
        String actualTitle = driver.getTitle();
        assertEquals("Expected title " + title + " is not equal to Actual title " + actualTitle, title, actualTitle);
    }
    @Then("User hover over on hamburger {string}")
    public void user_hover_over_on_hamburger(String locator) {
        hoverOverHamburgerManu(getElement(locator), 3, 3);
    }

    @Then("User clicks on {string}")
    public void click_on_option(String locator) {
        Objects.requireNonNull(waitForClickability(getElement(locator), 5, 2)).click();
    }

    @Then("User clicks on {string} on {string}")
    public void click_on_dropdown(String element, String iframe) {
        driver.switchTo().frame(getElement(iframe));
        Objects.requireNonNull(waitForClickability(getElement(element), 5, 5)).click();
    }

    @Given("User verifies {string} window pops up")
    public void user_verifies_pops_up_at_workflow_page(String window) {
        assertTrue(window + " is not present on the screen", waitForVisibility(getElement(window), 10, 1).isDisplayed());
    }

    @Given("User verifies {string} is present")
    public void user_verifies_is_present(String locator) {
        assertTrue(locator + " is present on screen", getElement(locator).isDisplayed());
    }

    @Given("User verifies {string} is empty")
    public void user_verifies_is_empty(String locator) {
        assertTrue(locator + " is not empty", waitTillOptionsEmpty(getElement(locator), 5, 10));
    }

    @Given("User verifies {string} is current date")
    public void user_verifies_is_current_date(String locator) {
        String newWorkflowDate = getElement(locator).getText();
        assertEquals(locator + " contains " + newWorkflowDate + " it's not equal to current date " + currentDate, newWorkflowDate, currentDate);
    }

    @Given("User verifies {string} contains current user")
    public void user_verifies_contains_current_user(String locator) {
        assertEquals(locator + " doesn't contain current user", getCurrentUser(), getElement(locator).getText());
    }

    @Given("User chose {int} options under {string}")
    public void user_chose_options_under(Integer number, String locator) throws InterruptedException {
        List<WebElement> elements = getOptions(waitForVisibility(getElement(locator), 5, 5), 5, 5);
        for (int i = 0; i < number; i++) {
            waitForClickability(elements.get(i), 5, 5).click();
        }
    }
    @Given("User verifies {int} options under {string} is present")
    public void user_verifies_options_under(int number, String locator) {
        assertEquals(number + " Options  is not present under " + locator, number, Objects.requireNonNull(getOptions(waitForVisibility(getElement(locator), 5, 5), 5, 5)).size());
    }

    /**
     * Moves the mouse to Hamburger Menu
     *
     * @param element on which to hover
     */
    public static void hoverOverHamburgerManu(WebElement element, int timeout, int attempts) {
        Actions action = new Actions(getDriver());
        WebDriverWait wait = new WebDriverWait(getDriver(), timeout);

        for (int i = 0; i < attempts; i++) {
            try {
                action.moveToElement(element).perform();
                wait.until(ExpectedConditions.attributeContains(element, "class", "open"));
                break;
            } catch (TimeoutException ignored) {
            }
            launchGooglePage(3);
            launchSteelCloud(3);
        }
    }
}



