package com.FastAndFurious4.pages;

import com.FastAndFurious4.utilities.ConfigurationReader;
import com.FastAndFurious4.utilities.Driver;
import io.cucumber.java.en.Given;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.Locale;

public class LoginPage {

    public LoginPage() {
        PageFactory.initElements(Driver.get(), this);
    }

    @FindBy(name = "_username")
    public WebElement usernameInput;

    @FindBy(name = "_password")
    public WebElement passwordInput;

    @FindBy(xpath = "//button[@id='_submit']")
    public WebElement loginBtn;

    @FindBy (xpath = "//input[@id='remember_me']")
    public WebElement remember_me_checkbox;

    @FindBy(css = ".custom-checkbox__text")
    public WebElement remember_me_checkbox_text;

    @FindBy(xpath = "//div[text()='Invalid user name or password.']")
    public WebElement invalid_credentials;

    @FindBy (linkText = "Forgot your password?")
    public WebElement forgot_passwordlink;

    @FindBy(xpath = "//h2[@class='title']")
    public WebElement forgot_password_title;

    public void login(){
        String username = (ConfigurationReader.get("username")); //driver
        String password = (ConfigurationReader.get("password"));//driver password
        usernameInput.sendKeys(username);
        passwordInput.sendKeys(password);
        loginBtn.click();
    }
    public void loginAsStoreManager(){
        String username = (ConfigurationReader.get("storemanager_username"));
        String password = (ConfigurationReader.get("storemanager_password"));

        usernameInput.sendKeys(username);
        passwordInput.sendKeys(password);
        loginBtn.click();
    }
    public void loginAsSalesManager(){
        String username= ConfigurationReader.get("salesmanager_username");
        String password= ConfigurationReader.get("salesmanager_password");

        usernameInput.sendKeys(username);
        passwordInput.sendKeys(password);
        loginBtn.click();

    }

    public void loginWithData(String username,String password){

        usernameInput.sendKeys(username);
        passwordInput.sendKeys(password);
        loginBtn.click();






    }



}

