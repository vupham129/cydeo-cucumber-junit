package com.cydeo.pages;

import com.cydeo.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class WikipediaSearchPage {

    public WikipediaSearchPage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//input[@name='search']")
    public WebElement wikipediaSearchBox;

    @FindBy(css = "h1#firstHeading")
    public WebElement header;

    @FindBy(xpath = "//div[@class='fn']")
    public WebElement imageHeader;

    @FindBy(xpath = "//div[@id='mw-page-base']/..")
    public WebElement searchButton;

    @FindBy(xpath = "//a[@title='Steve Jobs']")
    public WebElement SteveJobsLink;
}
