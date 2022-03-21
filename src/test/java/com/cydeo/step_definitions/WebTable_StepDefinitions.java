package com.cydeo.step_definitions;

import com.cydeo.pages.WebTableLoginPage;
import com.cydeo.utilities.BrowserUtils;
import com.cydeo.utilities.ConfigurationReader;
import com.cydeo.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import java.util.List;
import java.util.Map;

public class WebTable_StepDefinitions {
    WebTableLoginPage webTableLoginPage = new WebTableLoginPage();

    @Given("user is on the login page of web table app")
    public void user_is_on_the_login_page_of_web_table_app() {
        Driver.getDriver().get(ConfigurationReader.getProperty("web.table.url"));
    }
    @When("user clicks to login button")
    public void user_clicks_to_login_button() {
        webTableLoginPage.loginButton.click();
    }
    @Then("user should see url contains orders")
    public void user_should_see_url_contains_orders() {
        BrowserUtils.verifyURLContains("orders");
    }

    @When("user enters username {string}")
    public void userEntersUsername(String username) {
        webTableLoginPage.inputUsername.sendKeys(username);
    }

    @And("user enters password {string}")
    public void userEntersPassword(String password) {
        webTableLoginPage.inputPassword.sendKeys(password);
    }

    @When("user enters username {string} password {string} and logins")
    public void userEntersUsernamePasswordAndLogins(String username, String password) {
//        webTableLoginPage.inputUsername.sendKeys(username);
//        webTableLoginPage.inputPassword.sendKeys(password);
//        webTableLoginPage.loginButton.click();
        webTableLoginPage.login(username,password);
    }

    @When("User enters below credentials")
    public void userEntersBelowCredentials(Map<String,String> credentials) {

        //
        webTableLoginPage.login(credentials.get("username"), credentials.get("password"));

    }
}
