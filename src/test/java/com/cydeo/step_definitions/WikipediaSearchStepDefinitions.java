package com.cydeo.step_definitions;

import com.cydeo.pages.WikipediaSearchPage;
import com.cydeo.utilities.ConfigurationReader;
import com.cydeo.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Keys;

import java.util.concurrent.TimeUnit;

public class WikipediaSearchStepDefinitions {

    WikipediaSearchPage wikipediaSearchPage = new WikipediaSearchPage();

    @Given("user is on Wikipedia home page")
    public void user_is_on_wikipedia_home_page() {
        Driver.getDriver().get(ConfigurationReader.getProperty("env1"));
    }

    @When("user types {string} in the wiki search box")
    public void user_types_in_the_wiki_search_box(String searchData) {
        wikipediaSearchPage.wikipediaSearchBox.sendKeys("Steve Jobs" + Keys.ENTER);
    }

    @When("user clicks wiki search button")
    public void user_clicks_wiki_search_button() {
        wikipediaSearchPage.searchButton.click();
        wikipediaSearchPage.SteveJobsLink.click();
    }

    @Then("user sees {string} is in the wiki title")
    public void user_sees_is_in_the_wiki_title(String wordSearch) {
        String expectedTitle = wordSearch+" - Wikipedia";
        String actualTitle = Driver.getDriver().getTitle();
        Assert.assertEquals(expectedTitle,actualTitle);
    }

    @Then("user sees {string} is in the main header")
    public void user_sees_is_in_the_main_header(String expectedHeader) {
        String actualHeader = wikipediaSearchPage.header.getText();
        Assert.assertEquals(expectedHeader,actualHeader);
    }

    @Then("user sees {string} is in the image header")
    public void user_sees_is_in_the_image_header(String expectedTextImage) {
        String actualTextImage = wikipediaSearchPage.imageHeader.getText();
        Assert.assertEquals(expectedTextImage,actualTextImage);

    }

}
