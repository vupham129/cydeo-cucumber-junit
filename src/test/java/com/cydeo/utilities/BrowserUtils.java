package com.cydeo.utilities;

import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;


import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class BrowserUtils {
    /*
   This method will accept int second and execute Thread.sleep for given duration
    */
    public static void sleep(int second) {
        second *= 1000;
        try {
            Thread.sleep(second);
        } catch (InterruptedException e) {

        }

    }

    // This method accepts 3 arguments
    public static void switchWindowAndVerify(String expectedInUrl, String expectedInTitle){

        Set<String> allHandles = Driver.getDriver().getWindowHandles();
        for (String eachHandle : allHandles) {
            Driver.getDriver().switchTo().window(eachHandle);
            System.out.println("Current url: " + Driver.getDriver().getCurrentUrl()); // all of the four browsers
            if(Driver.getDriver().getCurrentUrl().contains(expectedInUrl)){
                break; // if the current URl has Etsy then stop at this page by using break keyword.
            }
        }
        String actualTitle = Driver.getDriver().getTitle();

        Assert.assertTrue(actualTitle.contains(expectedInTitle));
    }

    // This method accepts a String expectedTitle and Asserts if it is true
    public static void verifyTitle(String expectedTitle){

        Assert.assertEquals(Driver.getDriver().getTitle(), expectedTitle);

    }

    /**
     * This method will accept a String as expected value and verify actual URL contains the value
     * @param expectedInURL
     */
    public static void verifyURLContains(String expectedInURL){
        Assert.assertTrue(Driver.getDriver().getCurrentUrl().contains(expectedInURL));
    }

    /**
     * This method will accept a dropdown as a WebElement
     * and return all of the options' text in a list of String
     * @param dropdownElement
     * @return List<String> actualOptionsAsString
     */
    public static List<String> dropdownOptionsAsString(WebElement dropdownElement){
        Select select = new Select(dropdownElement);
        //List of all month <options> as a web element
        List<WebElement> actualOptionsAsWebElement = select.getOptions();
        //List of all month <options> as a string
        List<String> actualOptionsAsString = new ArrayList<>();
        for (WebElement webElement : actualOptionsAsWebElement) {
            actualOptionsAsString.add(webElement.getText());
        }
        return actualOptionsAsString;
    }

}
