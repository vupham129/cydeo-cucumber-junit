package com.cydeo.utilities;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;

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

}
