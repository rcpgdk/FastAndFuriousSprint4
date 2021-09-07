package com.FastAndFurious4.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class GeneralInformationPage extends BasePage {

    @FindBy (xpath = "//span[text()='General Information']")
    public WebElement generalInfoTitle;

    @FindBy(css = "[title='Add an event to this record']")
    public WebElement addEventButton;
}
