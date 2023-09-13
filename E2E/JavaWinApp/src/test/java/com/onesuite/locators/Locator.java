package com.onesuite.locators;

import com.onesuite.pages.BasePage;
import com.onesuite.pages.WorkflowPage;
import org.openqa.selenium.WebElement;

import java.util.HashMap;

/**
 * Stack Web Elements into the map and returns Web Element as map value by key name.
 */
public class Locator {

    private static WebElement  stackLocator(String key){
        HashMap<String, WebElement> stackElements = new HashMap<>();

        // Stack Web Elements from BasePage class
        BasePage basePage = new BasePage();
        stackElements.put("Menu", basePage.getHamburgerMenuButton());
        stackElements.put("Setup button", basePage.getSetupButton());
        stackElements.put("Setup dropdown", basePage.getSetupDropdown());
        stackElements.put("OneTIMConfiguration dropdown", basePage.getOneTIMConfigurationDropdown());
        stackElements.put("Workflows button", basePage.getWorkflowsButton());
        stackElements.put("Welcome current user", basePage.getWelcomeCurrentUser());
        stackElements.put("Logout button", basePage.getLogoutButton());

        // Stack Web Elements from WorkflowPage class getNewWorkflowButton
        WorkflowPage workflowPage = new WorkflowPage();
        stackElements.put("New Workflow button", workflowPage.getNewWorkflowButton());
        stackElements.put("Workflow page", workflowPage.getNewWorkflowIframe());
        stackElements.put("Add Workflow", workflowPage.getAddWorkflowWindow());
        stackElements.put("Add Workflow text box", workflowPage.getAddWorkflowTextBox());
        stackElements.put("Add Workflow \"Add\" button", workflowPage.getAddWorkflowAddButton());
        stackElements.put("Workflow Name text box", workflowPage.getWorkflowNameTextBox());
        stackElements.put("Workflow Name option", workflowPage.getWorkflowNameOption());
        stackElements.put("Workflow Active check mark", workflowPage.getWorkflowActiveCheckMark());
        stackElements.put("Workflow check box", workflowPage.getWorkflowCheckBox());
        stackElements.put("Workflow Tracks form", workflowPage.getWorkflowTracksForm());
        stackElements.put("Workflow Users Tab", workflowPage.getWorkflowUsersTab());
        stackElements.put("Workflow Select Users box", workflowPage.getWorkflowSelectUsersBox());
        stackElements.put("Workflow Created date field", workflowPage.getWorkflowCreatedDateField());
        stackElements.put("Workflow Created By field", workflowPage.getWorkflowCreatedByField());
        stackElements.put("Workflow Users Options", workflowPage.getWorkflowUsersOptions());
        stackElements.put("Workflow Users forward button", workflowPage.getWorkflowUsersForwardButton());
        stackElements.put("Workflow Selected Users Options", workflowPage.getWorkflowSelectedUsersOptions());
        stackElements.put("Workflow Users backward button", workflowPage.getWorkflowUsersBackwardButton());

        return stackElements.get(key);
    }
    public static WebElement getElement(String key){ return stackLocator(key); }
}
