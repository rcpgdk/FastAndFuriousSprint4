package com.FastAndFurious4.Stepdefinitions;

import com.FastAndFurious4.pages.CarEntitiesPage;
import com.FastAndFurious4.utilities.BrowserUtils;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import java.util.ArrayList;
import java.util.List;

public class DriverFilterStepDefs {

    @Given("the user clicks on filter button")
    public void the_user_clicks_on_filter_button() {
        new CarEntitiesPage().filter.click();
    }

    @Then("the user clicks on manage filters")
    public void the_user_clicks_on_manage_filters() {
        new CarEntitiesPage().caret.click();
    }

    @When("the user clicks on Driver checkbox")
    public void the_user_clicks_on_Driver_checkbox() {
        new CarEntitiesPage().driver_input_box.click();
    }

    @When("the Driver button should be selected")
    public void the_Driver_button_should_be_selected() {
        Assert.assertTrue(new CarEntitiesPage().driver_input_box.isSelected());
    }

    @Then("the user clicks on Driver all")
    public void theUserClicksOnDriverAll() {

        new CarEntitiesPage().caret_all.click();
    }

    @And("the user clicks on contains tab")
    public void theUserClicksOnContainsTab() {
        new CarEntitiesPage().contains_button.click();
    }

    @Then("the user should see following options")
    public void theUserShouldSeeFollowingOptions(List<String> expectedlist) {

        List<String> actualList = BrowserUtils.getElementsText(new CarEntitiesPage().columnoptions);

        Assert.assertEquals(expectedlist, actualList);
    }

    @And("the user clicks on choose contains method")
    public void theUserClicksOnChooseContainsMethod() {

        new CarEntitiesPage().columnoptions.get(0).click();

    }




    @Then("user send {string} the results should contain the specified keyword")
    public void userSendTheResultsShouldContainTheSpecifiedKeyword(String name) {
        new CarEntitiesPage().driver_input.sendKeys(name);

        new CarEntitiesPage().update_button.click();

        new CarEntitiesPage().sizeofWebelemebts(new CarEntitiesPage().tablerows);

        Assert.assertTrue(new CarEntitiesPage().sizeofWebelemebts(new CarEntitiesPage().tablerows)>0);





    }

    @And("the user clicks on choose does not contain method")
    public void theUserClicksOnChooseDoesNotContainMethod() {
        new CarEntitiesPage().columnoptions.get(1).click();
    }

    @Then("user send {string} the results should not contain the specified keyword")
    public void userSendTheResultsShouldNotContainTheSpecifiedKeyword(String name) {
        new CarEntitiesPage().driver_input.sendKeys(name);

        new CarEntitiesPage().update_button.click();

        List<String> list=new ArrayList<>();
        for (int i = 0; i<new CarEntitiesPage().td_name.size(); i++){
            list.add(new CarEntitiesPage().td_name.get(i).getText());


        }
        System.out.println("list = " + list);
        Assert.assertFalse(list.contains(name));
    }

    @Then("user send {string} the results should not contain the number")
    public void userSendTheResultsShouldNotContainTheNumber(String number) {

        new CarEntitiesPage().driver_input.sendKeys(number);

        new CarEntitiesPage().update_button.click();

        new CarEntitiesPage().sizeofWebelemebts(new CarEntitiesPage().tablerows);

        System.out.println(new CarEntitiesPage().sizeofWebelemebts(new CarEntitiesPage().tablerows));

        Assert.assertFalse(new CarEntitiesPage().sizeofWebelemebts(new CarEntitiesPage().tablerows)>0);



    }
}

