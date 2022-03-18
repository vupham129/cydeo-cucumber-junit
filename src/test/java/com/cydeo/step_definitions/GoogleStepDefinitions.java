package com.cydeo.step_definitions;

import com.cydeo.pages.GoogleSearchPage;
import com.cydeo.utilities.ConfigurationReader;
import com.cydeo.utilities.Driver;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Keys;

public class GoogleStepDefinitions {
    @When("user is on Google search page")
    public void user_is_on_google_search_page() {
        Driver.getDriver().get(ConfigurationReader.getProperty("env"));
    }
    @Then("user should see title is Google")
    public void user_should_see_title_is_google() {
        String expectedTitle = "Google";
        String actualTitle = Driver.getDriver().getTitle();
        Assert.assertEquals(actualTitle,expectedTitle);

        Driver.closeDriver();
    }
    GoogleSearchPage googleSearchPage = new GoogleSearchPage();

    @When("user types {string} in the google search box and clicks enter")
    public void user_types_in_the_google_search_box(String searchWord) {
        googleSearchPage.searchBox.sendKeys(searchWord + Keys.ENTER);
    }

    @Then("user should see {string} is in the google title")
    public void user_should_see_is_in_the_google_title(String expectedTitle) {
        String actualTitle = Driver.getDriver().getTitle();
        Assert.assertTrue(actualTitle.contains(expectedTitle));

        Driver.closeDriver();
    }
}
