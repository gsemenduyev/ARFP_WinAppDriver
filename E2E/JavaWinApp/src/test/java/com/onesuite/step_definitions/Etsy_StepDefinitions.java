package com.onesuite.step_definitions;

import com.onesuite.pages.EtsySearchPage;
import com.onesuite.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;

import static com.onesuite.utilities.ConfigurationsReader.getProperty;

public class Etsy_StepDefinitions {

    @Given("user is on the Etsy landing page")
    public void user_is_on_the_etsy_landing_page() {
        String url = getProperty("etsyUrl");
        Driver.getDriver().get(url);
    }
    @Then("user should see Etsy title as expected")
    public void user_should_see_etsy_title_as_expected() {
        String expectedTitle = "Etsy - Shop for handmade, vintage, custom, and unique gifts for everyone";
        String actualTitle = Driver.getDriver().getTitle();
        System.out.println(actualTitle);
        Assert.assertEquals("Title is not as expected", actualTitle, expectedTitle);
    }

    EtsySearchPage etsySearchPage = new EtsySearchPage();

    @When("user types Wooden Spoon in the search bar")
    public void user_types_wooden_spoon_in_the_search_bar() {
        etsySearchPage.searchBur.sendKeys("Cat");

    }
    @When("user clicks to search button")
    public void user_clicks_to_search_button() {
        etsySearchPage.searchButton.click();

    }
    @Then("user sees title is Cat - Etsy")
    public void user_sees_title_is_cat_etsy() {

        String expectedTitle = "Dog - Etsy";
        String actualTitle = Driver.getDriver().getTitle();
        Assert.assertEquals("Title is nat as expected", actualTitle, expectedTitle);


    }

    public static void main(String[] args) throws InterruptedException {
        Driver.getDriver().get("https://osweb-wc-relqa.cable.comcast.com/OMT/Order/Edit/1187336");
        Thread.sleep(5000);
        Driver.getDriver().findElement(By.id("liLines")).click();
        System.out.println(Driver.getDriver().findElement(By.xpath("//div[contains(text(),'dropped')]")).getText());
    }


}
