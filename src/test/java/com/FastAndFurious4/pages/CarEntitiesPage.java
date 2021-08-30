package com.FastAndFurious4.pages;

import com.FastAndFurious4.utilities.Driver;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

public class CarEntitiesPage extends BasePage {

@FindBy(xpath = "//input[@type='number']")
    public WebElement total_page_number;

@FindBy(xpath = "//label[text()='Total of 40 records']")
    public WebElement total_recording;

@FindBy(xpath = "//tbody[@class='grid-body']/tr")
    public List<WebElement> tablerows;

@FindBy(xpath = "//a/i[@class='fa-chevron-right hide-text']")
    public WebElement next_page;

@FindBy(xpath = "//a/i[@class='fa-chevron-left hide-text']")
    public WebElement previous_page;

@FindBy(xpath = "//label[@class='dib'][2]")
public WebElement page_number_text;

@FindBy(xpath = "(//i[@class='fa-upload'])[1]")
public WebElement export_grid;

@FindBy(xpath = "(//i[@class='fa-upload'])[2]")
public WebElement XLSX_file;

@FindBy (xpath = "(//i[@class='fa-upload'])[3]")
public WebElement CSV_file;

@FindBy(xpath = "//div[@class='flash-messages-holder']")
public WebElement flash_message_holder;





    public void  verifyelementsDisplayed(List<WebElement> list) {

        for (WebElement el : list) {
            Assert.assertTrue(el.isDisplayed());
        }
    }
    int count=0;
    public int  sizeofWebelemebts(List<WebElement> list) {

        for (int i=1; i<=list.size();i++) {
            count++;

        }
        return  count;
    }






}





