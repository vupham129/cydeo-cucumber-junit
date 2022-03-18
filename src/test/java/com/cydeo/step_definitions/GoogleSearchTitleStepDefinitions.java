package com.cydeo.step_definitions;

import com.cydeo.pages.GoogleSearch_Title;
import com.cydeo.utilities.Driver;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Keys;

public class GoogleSearchTitleStepDefinitions {

    GoogleSearch_Title googleSearch_title = new GoogleSearch_Title();

    @When("user types {string} in the google search box and clicks enter")
    public void user_types_in_the_google_search_box(String searchWord) {
        googleSearch_title.searchBox.sendKeys(searchWord + Keys.ENTER);
    }

    @Then("user should see {string} is in the google title")
    public void user_should_see_is_in_the_google_title(String title) {
        String actualTitle = Driver.getDriver().getTitle();
        String expectedTitle = title;
        Assert.assertEquals(expectedTitle,actualTitle);
    }

}
