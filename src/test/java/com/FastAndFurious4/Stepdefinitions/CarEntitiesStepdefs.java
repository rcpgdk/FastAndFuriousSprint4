package com.FastAndFurious4.Stepdefinitions;

import com.FastAndFurious4.pages.CarEntitiesPage;
import com.FastAndFurious4.pages.DashboardPage;
import com.FastAndFurious4.pages.LoginPage;
import com.FastAndFurious4.utilities.BrowserUtils;
import com.FastAndFurious4.utilities.ConfigurationReader;
import com.FastAndFurious4.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import sun.rmi.runtime.Log;

import java.util.concurrent.CopyOnWriteArrayList;

public class CarEntitiesStepdefs {
    @Given("the user logged in as {string}")
    public void theUserLoggedInAs(String usertype) {

        Driver.get().get(ConfigurationReader.get("url"));
        String username = null;
        String password = null;

        if (usertype.equals("driver")) {
            username = ConfigurationReader.get("driver_username");
            password = ConfigurationReader.get("driver_password");
            new LoginPage().login(username, password);
            Assert.assertEquals("Quick Launchpad", new DashboardPage().getPageSubTitle());

        } else if (usertype.equals("sales manager")) {

            username = ConfigurationReader.get("sales_manager_username");
            password = ConfigurationReader.get("sales_manager_password");
            new LoginPage().login(username, password);
            Assert.assertEquals("Dashboard", new DashboardPage().getPageSubTitle());

        } else if (usertype.equals("store manager")) {

            username = ConfigurationReader.get("store_manager_username");
            password = ConfigurationReader.get("store_manager_password");
            new LoginPage().login(username, password);
            Assert.assertEquals("Dashboard", new DashboardPage().getPageSubTitle());

        }


    }


    @And("the {string} navigates to the {string} and {string}")
    public void theNavigatesToTheAnd(String usertype, String tab, String module) {


        new DashboardPage().navigateToModule(tab, module);
        BrowserUtils.waitFor(3);

        if (usertype.equals("driver")) {
            Assert.assertEquals("Cars", new CarEntitiesPage().getPageSubTitle());


        }

        if (usertype.equals("sales manager") || usertype.equals("store manager")) {
            Assert.assertEquals("All Cars", new CarEntitiesPage().getPageSubTitle());

        }

    }


    @Then("the {string} should see all Vehicle information")
    public void theShouldSeeAllVehicleInformation(String usertype) {
        if (usertype.equals("driver") || usertype.equals("sales manager") || usertype.equals("store manager"))

            new CarEntitiesPage().sizeofWebelemebts((new CarEntitiesPage().tablerows));
        new CarEntitiesPage().verifyelementsDisplayed(new CarEntitiesPage().tablerows);


    }


    @Then("all users should see the page number")
    public void allUsersShouldSeeThePageNumber() {
        String pagenumber = new CarEntitiesPage().page_number_text.getText().substring(3, 4);
        Assert.assertEquals("2", pagenumber);

    }


    @Then("user goes next page clicking > button and can go to previous page clicking < button")
    public void userGoesNextPageClickingButtonAndCanGoToPreviousPageClickingButton() {

        String pagenumber = new CarEntitiesPage().total_page_number.getAttribute("value");
        new CarEntitiesPage().next_page.click();
        BrowserUtils.waitFor(3);
        System.out.println(new CarEntitiesPage().total_page_number.getAttribute("value"));
        Assert.assertEquals("2", new CarEntitiesPage().total_page_number.getAttribute("value"));
        new CarEntitiesPage().previous_page.click();
        BrowserUtils.waitFor(3);
        System.out.println(new CarEntitiesPage().total_page_number.getAttribute("value"));
        Assert.assertEquals("1", new CarEntitiesPage().total_page_number.getAttribute("value"));


    }

    @Then("user  should see total recordings of vehicles")
    public void userShouldSeeTotalRecordingsOfVehicles() {

        CarEntitiesPage carEntitiesPage = new CarEntitiesPage();

        int count=0;
        for (int i=1; i<2; i++){
            carEntitiesPage.sizeofWebelemebts(carEntitiesPage.tablerows);
             carEntitiesPage.next_page.click();
             BrowserUtils.waitFor(3);
             count=carEntitiesPage.sizeofWebelemebts(carEntitiesPage.tablerows);

    }

        int recording=Integer.parseInt(carEntitiesPage.total_recording.getText().substring(9,11));
        System.out.println(recording);
        Assert.assertEquals(recording,count);

    }

    @When("the user clicks on CSV or XLSX flash message should displayed")
    public void theUserClicksOnCSVOrXLSXFlashMessageShouldDisplayed() {

        CarEntitiesPage carEntitiesPage=new CarEntitiesPage();

        carEntitiesPage.export_grid.click();
        BrowserUtils.waitFor(3);
        carEntitiesPage.CSV_file.click();
        BrowserUtils.waitFor(3);
        Assert.assertTrue(carEntitiesPage.flash_message_holder.isDisplayed());
        BrowserUtils.waitFor(3);
        carEntitiesPage.export_grid.click();
        BrowserUtils.waitFor(3);
        carEntitiesPage.XLSX_file.click();
        BrowserUtils.waitFor(3);
        Assert.assertTrue(carEntitiesPage.flash_message_holder.isDisplayed());
    }
}

