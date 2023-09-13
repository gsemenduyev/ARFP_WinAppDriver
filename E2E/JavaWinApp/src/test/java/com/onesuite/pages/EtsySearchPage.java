package com.onesuite.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static com.onesuite.utilities.Driver.getDriver;

public class EtsySearchPage {
    public EtsySearchPage(){
        PageFactory.initElements(getDriver(), this);
    }

    @FindBy(id = "global-enhancements-search-query")
    public WebElement searchBur;

    @FindBy(xpath = "//button[@value='Search']")
    public WebElement searchButton;
}
