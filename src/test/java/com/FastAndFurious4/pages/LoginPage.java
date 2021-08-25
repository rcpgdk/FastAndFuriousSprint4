package com.FastAndFurious4.pages;

import com.FastAndFurious4.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    public LoginPage() {
        PageFactory.initElements(Driver.get(), this);
    }

    @FindBy(name = "_username")
    public WebElement username;

    @FindBy(name = "_password")
    public WebElement password;

    @FindBy(xpath = "//button[@id='_submit']")
    public WebElement submit;

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




    public void login(String userNameStr, String passwordStr) {
        username.sendKeys(userNameStr);
        password.sendKeys(passwordStr);
        submit.click();

    }



}
