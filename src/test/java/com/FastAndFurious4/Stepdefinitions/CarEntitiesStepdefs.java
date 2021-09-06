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
 import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.List;
import java.util.Locale;

//import sun.rmi.runtime.Log;


public class CarEntitiesStepdefs {

    DashboardPage dashboardPage = new DashboardPage();


    @Given("the user logged in as {string}")
    public void theUserLoggedInAs(String usertype) {

        Driver.get().get(ConfigurationReader.get("url"));
        String username = null;
        String password = null;

        if (usertype.equals("driver")) {
            username = ConfigurationReader.get("driver_username");
            password = ConfigurationReader.get("driver_password");
            new LoginPage().loginWithData(username, password);
            Assert.assertEquals("Quick Launchpad", new DashboardPage().getPageSubTitle());

        } else if (usertype.equals("sales manager")) {

            username = ConfigurationReader.get("sales_manager_username");
            password = ConfigurationReader.get("sales_manager_password");
            new LoginPage().loginWithData(username, password);
            Assert.assertEquals("Dashboard", new DashboardPage().getPageSubTitle());

        } else if (usertype.equals("store manager")) {

            username = ConfigurationReader.get("store_manager_username");
            password = ConfigurationReader.get("store_manager_password");
            new LoginPage().loginWithData(username, password);
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
    //1-392-driver********************************************


    @When("Hover over ... which is the rightest side of every car's row.")
    public void hoverOverWhichIsTheRightestSideOfEveryCarSRow() {

        System.out.println(dashboardPage.menuBar.size());
        List<WebElement> menus = dashboardPage.menuBar;
        for (WebElement menu : menus) {
            Assert.assertTrue(menu.isDisplayed());

        }
        System.out.println("displayeeeeed");

        BrowserUtils.waitForVisibility(dashboardPage.menuBar.get(1), 10);

        BrowserUtils.clickWithJS(dashboardPage.menuBar.get(0));
        BrowserUtils.hover(dashboardPage.menuBar.get(0));
        System.out.println("hovered");
        DashboardPage.delete.click();
        DashboardPage.yesDeleteBtn.click();

        String actualMessage = DashboardPage.message.getText();
        String expectedMessage = "You do not have permission to perform this action.";

        Assert.assertEquals(expectedMessage, actualMessage);
    }

    @Then("User can see the delete option.")
    public void userCanSeeTheDeleteOption() {

    }

    @And("user clicks on delete button.")
    public void userClicksOnDeleteButton() {
    }

    @And("user clicks yes on the pop up")
    public void userClicksYesOnThePopUp() {
    }

    @Then("You do not have permission to perform this action.\" message should be displayed")
    public void youDoNotHavePermissionToPerformThisActionMessageShouldBeDisplayed() {


    }


    //390 -store manager****************************************


    @When("Hover over ...  rightest side of every car's row.")
    public void hoverOverRightestSideOfEveryCarSRow() {


    }


    @Then("User should be able to see the delete option.")
    public void userShouldBeAbleToSeeTheDeleteOption() {
        System.out.println(dashboardPage.menuBar.size());
       // List<WebElement> menus = dashboardPage.menuBar;
      //  for (WebElement menu : menus) {
        //    Assert.assertTrue(menu.isDisplayed());

       // }
        System.out.println("displayeeeeed");

        BrowserUtils.waitForVisibility(dashboardPage.menuBar.get(1), 10);

        BrowserUtils.clickWithJS(dashboardPage.menuBar.get(0));
        BrowserUtils.hover(dashboardPage.menuBar.get(1));
        System.out.println("hovered");
BrowserUtils.waitFor(3);
        DashboardPage.delete.click();
        DashboardPage.yesDeleteBtn.click();

        //dashboardPage.waitUntilLoaderScreenDisappear();
       // Assert.assertTrue(dashboardPage.delete.isSelected());










    }
//407-**********************************************

    @When("user click one the car which is listed row by row.")
    public void userClickOneTheCarWhichIsListedRowByRow(String row) {

        BrowserUtils.waitFor(3);
        System.out.println(dashboardPage.row.size());
        List<WebElement> rows = dashboardPage.row;
       // for (WebElement row : rows) {
        //    Assert.assertTrue(row.isDisplayed());
       // }

        BrowserUtils.hover(dashboardPage.row.get(1));
        dashboardPage.row.get(1).click();

        dashboardPage.waitUntilLoaderScreenDisappear();
        Assert.assertFalse(dashboardPage.deleteButton.isDisplayed());


    }


    @And("click on General")
    public void clickOnGeneral() {
    }

    @Then("User should not be able to see the delete button at the right top of the page.")
    public void userShouldNotBeAbleToSeeTheDeleteButtonAtTheRightTopOfThePage() {
    }

    //393-***************************************

    @Then("User should be able to see the delete button at the right top of the page.")
    public void userShouldBeAbleToSeeTheDeleteButtonAtTheRightTopOfThePage() {


////        System.out.println(dashboardPage.row.size());
//        List<WebElement> table = dashboardPage.row;
//        for (WebElement rows : table) {
//            rows.getText();
//            Assert.assertTrue(rows.isDisplayed());
//        }
//        BrowserUtils.waitForVisibility(dashboardPage.row.get(0), 10);
//     // BrowserUtils.waitFor(3);
//      dashboardPage.row.get(1).click();


//        System.out.println(dashboardPage.row.size());
//        List<WebElement> menus = dashboardPage.row;
//        for (WebElement menu : menus) {
//            Assert.assertTrue(menu.isDisplayed());
//
//        }
//        System.out.println("displayeeeeed");
//
//        BrowserUtils.waitForVisibility(dashboardPage.row.get(1), 10);
//
//        BrowserUtils.clickWithJS(dashboardPage.row.get(0));
//        BrowserUtils.hover(dashboardPage.row.get(0));
//        System.out.println("hovered");
//        dashboardPage.row.get(1).click();


        BrowserUtils.waitFor(3);
        System.out.println(dashboardPage.row.size());
        List<WebElement> menus = dashboardPage.row;
        for (WebElement menu : menus) {
            Assert.assertTrue(menu.isDisplayed());
        }

        BrowserUtils.hover(dashboardPage.row.get(0));
        dashboardPage.row.get(1).click();

        dashboardPage.waitUntilLoaderScreenDisappear();
        Assert.assertTrue(dashboardPage.deleteButton.isDisplayed());





    }




    //394-*********************************************

    @When("User hover the mouse on ...")
    public void userHoverTheMouseOn(String menuBar) {

        System.out.println(dashboardPage.menuBar.size());
        List<WebElement> menus = dashboardPage.menuBar;
        for (WebElement menu : menus) {
            Assert.assertTrue(menu.isDisplayed());

        }
        System.out.println("displayeeeeed");

        BrowserUtils.waitForVisibility(dashboardPage.menuBar.get(1), 10);

        BrowserUtils.clickWithJS(dashboardPage.menuBar.get(0));
        BrowserUtils.hover(dashboardPage.menuBar.get(0));
        System.out.println("hovered");
        DashboardPage.delete.click();
        BrowserUtils.waitFor(3);

        Assert.assertTrue(dashboardPage.DeleteConfirmationPop.isDisplayed());
    }

    @And("Delete button should be pop up")
    public void deleteButtonShouldBePopUp() {
    }

    @When("user click on delete button.")
    public void userClickOnDeleteButton() {
    }

    @Then("User should be able to successfully click on delete button and after Delete Confirmation pop up should be displayed.")
    public void userShouldBeAbleToSuccessfullyClickOnDeleteButtonAndAfterDeleteConfirmationPopUpShouldBeDisplayed() {
    }

    //395-***************************************
    @When("user navigate and hover the cursor on ... at the right side of the cars.")
    public void userNavigateAndHoverTheCursorOnAtTheRightSideOfTheCars() {

        System.out.println(dashboardPage.menuBar.size());
        List<WebElement> menus = dashboardPage.menuBar;
        for (WebElement menu : menus) {
            Assert.assertTrue(menu.isDisplayed());

        }
        System.out.println("displayeeeeed");

        BrowserUtils.waitForVisibility(dashboardPage.menuBar.get(1), 10);

        BrowserUtils.clickWithJS(dashboardPage.menuBar.get(0));
        BrowserUtils.hover(dashboardPage.menuBar.get(0));
        System.out.println("hovered");
        DashboardPage.delete.click();
        DashboardPage.yesDeleteBtn.click();

        Assert.assertTrue(dashboardPage.confirmationMessage.isDisplayed());

    }

    @And("user sees the delete option.")
    public void userSeesTheDeleteOption() {
    }

    @And("user clicks on delete option.")
    public void userClicksOnDeleteOption() {
    }

    @And("user clicks on Yes,Delete button")
    public void userClicksOnYesDeleteButton() {
    }

    @Then("user should be able to click on button and successfully see the Car deleted message on the panel.")
    public void userShouldBeAbleToClickOnButtonAndSuccessfullySeeTheCarDeletedMessageOnThePanel() {
    }



}





