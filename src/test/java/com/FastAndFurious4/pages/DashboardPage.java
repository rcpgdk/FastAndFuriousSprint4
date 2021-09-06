package com.FastAndFurious4.pages;


import com.FastAndFurious4.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class DashboardPage extends BasePage{

    public DashboardPage(){
        PageFactory.initElements(Driver.get(),this);
    }
   // @FindBy(css = ".more-bar-holder>.dropdown>.dropdown-toggle")
   // public static List<WebElement> menuBar;


// a[@text()='...']
    ////a[@data-toggle='dropdown']
//
   @FindBy(css = "div.more-bar-holder")
   public List<WebElement> menuBar;


//.fa-trash-o.hide-text   css
////a[@title='Delete']
    @FindBy(css = "//a[@title='Delete']")
    public static WebElement delete;

    @FindBy(css = ".message")
    public static WebElement message;

    @FindBy(xpath = "//a[text()='Yes, Delete']")
    public static WebElement yesDeleteBtn;

    @FindBy(css= "td.string-cell.grid-cell.grid-body-cell.grid-body-cell-LicensePlate")
    public List<WebElement> row;


    @FindBy(css="div.modal.oro-modal-danger.in")
    public static WebElement DeleteConfirmationPop;

    @FindBy(xpath = "//div[@class='message']")
    public WebElement confirmationMessage;



    @FindBy(css = ".fa-trash-o.hide-text")
    public WebElement deleteButton;





}
