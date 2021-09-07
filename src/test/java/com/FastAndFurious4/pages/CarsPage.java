package com.FastAndFurious4.pages;

import com.FastAndFurious4.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class CarsPage {

    public CarsPage(){
        PageFactory.initElements(Driver.get(), this);
    }

    @FindBy(xpath = "//a[@title='Grid Settings']//i[1]")
    public WebElement gridSettingsButton;

    @FindBy(xpath = "//td[@class='title-cell']//label")
    public List<WebElement> columnNames;

    @FindBy(xpath = "//input[@placeholder='Quick Search']")
    public WebElement quickSearchInput;

    @FindBy(xpath = "//div[@class='column-manager-actions']//a[1]")
    public WebElement selectAll;

    @FindBy(xpath = "(//table)[3]/thead/tr/th")
    public List<WebElement> tableColumnNames;

    @FindBy(xpath = "//span[@class='close']")
    public WebElement closeGridSettings;

    @FindBy(xpath = "//table/tbody")
    public WebElement firstRowCar;

}