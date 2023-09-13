package com.onesuite.pages;

import com.onesuite.utilities.Driver;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
    public HomePage(){PageFactory.initElements(Driver.getDriver(), this);}

}
