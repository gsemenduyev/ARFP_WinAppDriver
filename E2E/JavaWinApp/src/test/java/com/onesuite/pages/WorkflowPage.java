package com.onesuite.pages;

import com.onesuite.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class WorkflowPage {
    public WorkflowPage(){ PageFactory.initElements(Driver.getDriver(), this);}

    @FindBy(id = "NewWorkflow")
    private WebElement newWorkflowButton;
    public WebElement getNewWorkflowButton() { return newWorkflowButton; }

    @FindBy(id = "frame1")
    private WebElement newWorkflowIframe;
    public WebElement getNewWorkflowIframe() { return newWorkflowIframe; }

    @FindBy(id = "ui-id-3")
    private WebElement addWorkflowWindow;
    public WebElement getAddWorkflowWindow() { return addWorkflowWindow; }

    @FindBy(id = "WfName")
    private WebElement addWorkflowTextBox;
    public WebElement getAddWorkflowTextBox() { return addWorkflowTextBox; }

    @FindBy(id = "ButtonAddWf")
    private WebElement addWorkflowAddButton;
    public WebElement getAddWorkflowAddButton() { return addWorkflowAddButton; }

    @FindBy(xpath = "(//div[@class='ui-state-default slick-headerrow-column l2 r2'])[1]/*")
    private WebElement workflowNameTextBox;
    public WebElement getWorkflowNameTextBox() { return workflowNameTextBox; }

    @FindBy(xpath = "(//div[@class='slick-cell l2 r2 WorkflowName'])[1]")
    private WebElement workflowNameOption;
    public WebElement getWorkflowNameOption() { return workflowNameOption; }


    @FindBy(xpath = "(//span[@class='slick-tick'])[1]")
    private WebElement workflowActiveCheckMark;
    public WebElement getWorkflowActiveCheckMark() { return workflowActiveCheckMark; }

    @FindBy(xpath = "(//div[@class='slick-cell l0 r0 selChecbox slick-cell-readonly'])[1]/*")
    private WebElement workflowCheckBox;
    public WebElement getWorkflowCheckBox() { return workflowCheckBox; }

    @FindBy(id = "tabs-WfTracksUsers")
    private WebElement workflowTracksForm;
    public WebElement getWorkflowTracksForm() { return workflowTracksForm; }

    @FindBy(xpath = "//a[.='Workflow Users']")
    private WebElement workflowUsersTab;
    public WebElement getWorkflowUsersTab() { return workflowUsersTab; }

    @FindBy(id = "ListBoxSelectedWfUsers")
    private WebElement workflowSelectUsersBox;
    public WebElement getWorkflowSelectUsersBox() { return workflowSelectUsersBox; }

    @FindBy(xpath = "((//div[@class='grid-canvas grid-canvas-top grid-canvas-left'])[1]/div/div)[5]")
    private WebElement workflowCreatedDateField;
    public WebElement getWorkflowCreatedDateField() { return workflowCreatedDateField; }

    @FindBy(xpath = "((//div[@class='grid-canvas grid-canvas-top grid-canvas-left'])[1]/div/div)[6]")
    private WebElement workflowCreatedByField;
    public WebElement getWorkflowCreatedByField() { return workflowCreatedByField; }

    @FindBy(id = "ListBoxAvailWfUsers")
    private WebElement workflowUsersOptions;
    public WebElement getWorkflowUsersOptions() { return workflowUsersOptions; }

    @FindBy(id = "btnAddSelWfUser")
    private WebElement workflowUsersForwardButton;
    public WebElement getWorkflowUsersForwardButton() { return workflowUsersForwardButton; }

    @FindBy(id = "ListBoxSelectedWfUsers")
    private WebElement workflowSelectedUsersOptions;
    public WebElement  getWorkflowSelectedUsersOptions() { return workflowSelectedUsersOptions; }

    @FindBy(id = "btnRemoveSelWfUser")
    private WebElement workflowUsersBackwardButton;
    public WebElement  getWorkflowUsersBackwardButton() { return workflowUsersBackwardButton; }
}

