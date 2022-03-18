package com.cydeo.step_definitions;

import com.cydeo.utilities.ConfigurationReader;
import com.cydeo.utilities.Driver;
import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeStep;

import java.util.concurrent.TimeUnit;

/*
In the class we will be able to pass pre- & post- conditions to
each scenario and each step
 */
public class Hooks {

    // import from io.cucumber.java, not from junit
    @Before (order = 1)
    public void setupScenario(){
        System.out.println("===Setting up browser using cucumber @Before");
    }

    @Before (value = "@login", order = 2)
    public void setupScenarioForLogins(){
        System.out.println("===this will only apply to scenarios with @login tag");
    }
    @Before (value = "@db", order = 0)
    public void setupForDatabaseScenarios(){
        System.out.println("===this will only apply to scenarios with @db tag");
    }
    @After
    public void teardownScenario(){
        System.out.println("===Closing browser using cucumber @After");
        System.out.println("===Scenario ended/ take screenshot if failed!");
    }

    @BeforeStep
    public void setupStep(){
        System.out.println("-------->applying setup using @BeforeStep");
    }

    @AfterStep
    public void afterStep(){
        System.out.println("--------->applying tearDown using @AfterStep");
    }

    @Before ("@GoogleSearchTitle")
    public void setupForGoogleSearchTitle(){
        Driver.getDriver().get(ConfigurationReader.getProperty("env"));
    }

    @After ("@GoogleSearchTitle")
    public void closingForGoogleSearchTitle(){
        Driver.closeDriver();
    }

    @Before ("@WikipediaSearch")
    public void setupForWikipediaSearch(){
        Driver.getDriver().get(ConfigurationReader.getProperty("env1"));
    }

    @After ("@WikipediaSearch")
    public void closingForWikipediaSearch(){
        Driver.closeDriver();
    }




}
