package com.onesuite.pages;

import com.onesuite.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BasePage {
    public BasePage(){
        PageFactory.initElements(Driver.getDriver(), this);}

    @FindBy(id = "hamburger-menu")
    private WebElement hamburgerMenuButton;
    public WebElement getHamburgerMenuButton() { return hamburgerMenuButton; }

    @FindBy(id = "logout-button")
    private WebElement logoutButton;
    public WebElement getLogoutButton() { return logoutButton; }

    @FindBy(xpath = "(//a[.='Setup'])[1]")
    private WebElement setupButton;
    public WebElement getSetupButton() { return setupButton; }

    @FindBy(xpath = "(//a[.='Setup'])[2]")
    private WebElement setupDropdown;
    public WebElement getSetupDropdown(){ return setupDropdown; }

    @FindBy(xpath = "//a[.='OneTIMConfiguration']")
    private WebElement oneTIMConfigurationDropdown;
    public WebElement getOneTIMConfigurationDropdown(){ return oneTIMConfigurationDropdown; }

    @FindBy(xpath = "//a[.='Workflows']")
    private WebElement workflowsButton;
    public WebElement getWorkflowsButton() { return workflowsButton; }

    @FindBy(className = "ui-button-text")
    private WebElement welcomeCurrentUser;
    public WebElement getWelcomeCurrentUser() { return welcomeCurrentUser; }
}
