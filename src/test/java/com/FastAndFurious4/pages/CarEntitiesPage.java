package com.FastAndFurious4.pages;

import com.FastAndFurious4.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class CarEntitiesPage extends BasePage {

    public CarEntitiesPage() {
        PageFactory.initElements(Driver.get(), this);
    }

    @FindBy(xpath = "(//button[@class='btn dropdown-toggle '])")
    public WebElement dropDown;

    @FindBy(xpath = "(//a[@class='dropdown-item'])[1]")
    public  WebElement dropDownFirstEl;

    @FindBy(xpath = "dropdown-item")
    public  WebElement dropDownItem;

    @FindBy(xpath = "(//a[@class='dropdown-item'])[3]")
    public  WebElement dropDownThirdEl;


    @FindBy(xpath = "(//a[@class='dropdown-item'])[4]")
    public  WebElement dropDownForthEl;



    @FindBy(xpath = "//*[text()='Driver']")
    public WebElement anyColumn;

    @FindBy(xpath = "//a[@title='Reset']/i[@class='fa-refresh']")
    public WebElement resetButton;

    @FindBy(xpath = "//*[text()='wew1231']")
    public WebElement firstCell;

    @FindBy(xpath = "//tbody[@class='grid-body']/tr")
    public List<WebElement> tablerows;

    int count=0;
    public int  sizeofWebelemebts (List<WebElement> list) {

        for (int i=1; i<=list.size();i++) {
            count++;

        }
        return  count;
    }
}

