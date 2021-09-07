package com.FastAndFurious4.Stepdefinitions;

import com.FastAndFurious4.pages.CarEntitiesPage;
import com.FastAndFurious4.utilities.BrowserUtils;
import com.FastAndFurious4.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class TableArrangementStepDefs {

    @When("user clicks on {string} button")
    public void user_clicks_on_button(String viewPerPage) {
        BrowserUtils.waitFor(3);
        new CarEntitiesPage().dropDown.click();

    }

    @Then("verify user can arrange displayed row numbers")
    public void verify_user_can_arrange_displayed_row_numbers() {


        BrowserUtils.waitFor(5);
        String[] options = {"10", "25", "50", "100"};

        int count = 0;

        for (int i = 0; i < options.length; i++) {

            count++;

            WebElement element = Driver.get().findElement(By.xpath("(//button[@class='btn dropdown-toggle '])"));
            WebElement element2 = Driver.get().findElement(By.xpath("(//a[@class='dropdown-item'])[" + count + "]"));
            element.click();

            Assert.assertEquals(element2.getAttribute("data-size"), options[i]);

        }

    }

    @Then("verify the value of view per page should be {int} by default")
    public void verifyTheValueOfViewPerPageShouldBeByDefault(Integer expectedNumber) {

        BrowserUtils.waitFor(6);
        CarEntitiesPage carEntitiesPage = new CarEntitiesPage();
        carEntitiesPage.dropDown.getText();
        Integer actualNumber = Integer.parseInt(carEntitiesPage.dropDown.getText());
        Assert.assertEquals(actualNumber, expectedNumber);

    }


    @Given("verify the user can select each of {string} below")
    public void verify_the_user_can_select_each_of_below(String viewPerPage) {


        BrowserUtils.waitFor(3);
        String[] options = {"10", "25", "50", "100"};

        int count = 0;

        for (int i = 0; i < options.length; i++) {

            count++;

            WebElement element = Driver.get().findElement(By.xpath("(//button[@class='btn dropdown-toggle '])"));
            WebElement element2 = Driver.get().findElement(By.xpath("(//a[@class='dropdown-item'])[" + count + "]"));
            element.click();

            Assert.assertEquals(element2.getAttribute("data-size"), options[i]);


        }

    }


    @When("the user clicks on reset button")
    public void the_user_clicks_on_reset_button() {

        BrowserUtils.waitFor(4);
        new CarEntitiesPage().resetButton.click();



    }

    @Then("Verify user can reset the table")
    public void verify_user_can_reset_the_table() {

BrowserUtils.waitFor(3);
        Assert.assertEquals(new CarEntitiesPage().firstCell.getText(),"wew1231");



    }
    @Given("user clicks any column name")
    public void user_clicks_any_column_name() {
        BrowserUtils.waitFor(3);
        new CarEntitiesPage().anyColumn.click();



    }

}



