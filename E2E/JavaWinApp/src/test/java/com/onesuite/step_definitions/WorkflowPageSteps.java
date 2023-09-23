//package com.onesuite.step_definitions;
//
//
//import io.cucumber.java.en.Given;
//import org.openqa.selenium.Keys;
//import org.openqa.selenium.WebElement;
//
//import static com.onesuite.locators.Locator.getElement;
//import static com.onesuite.utilities.BrowserUtils.*;
//import static com.onesuite.utilities.MathUtils.generateRandomNumbers;
//import static org.junit.Assert.assertEquals;
//
//public class WorkflowPageSteps {
//
//    String randomNumber;
//    @Given("User verifies newly created Workflow is added")
//    public void user_verifies_newly_created_workflow_is_added() {
//        assertEquals("Newly created Workflow '" + randomNumber + "' is not added ", waitTillTextIsPresent(getElement("Workflow Name option"), randomNumber,5, 5), randomNumber);
//    }
//
//    @Given("User inputs {int} digits long number into {string}")
//    public void user_inputs_digits_long_number_into(Integer number, String locator) {
//        randomNumber = generateRandomNumbers(number);
//        WebElement element = getElement(locator);
//        waitForVisibility(element, 10, 1);
//        element.sendKeys(randomNumber);
//        element.sendKeys(Keys.TAB);
//    }
//
//    @Given("User inserts Newly created number into the {string}")
//    public void user_inserts_into_the(String locator) {
//        retryingSendKeys(getElement(locator), randomNumber, 5);
//    }
//
//
//}
