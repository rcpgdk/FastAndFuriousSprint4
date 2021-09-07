package com.FastAndFurious4.Stepdefinitions;

import com.FastAndFurious4.pages.DashboardPage;
import com.FastAndFurious4.utilities.BrowserUtils;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebElement;

import java.util.List;

public class DeleteStepdefs {

    DashboardPage dashboardPage=new DashboardPage();

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
        dashboardPage.delete.click();
        dashboardPage.yesDeleteBtn.click();

        String actualMessage = dashboardPage.message.getText();
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
    public void youDoNotHavePermissionToPerformThisActionMessageShouldBeDisplayed() throws Throwable {    // Write code here that turns the phrase above into concrete actions    throw new cucumber.api.PendingException();}
    }
//------------------------------------
    @When("user click one the car which is listed row by row.")
    public void userClickOneTheCarWhichIsListedRowByRow() {
        BrowserUtils.waitFor(3);
        System.out.println(dashboardPage.row.size());
        List<WebElement> rows = dashboardPage.row;
        // for (WebElement row : rows) {
        //    Assert.assertTrue(row.isDisplayed());
        // }

       // if(usertype.equals("driver")){
         //   Assert.assertEquals("Cars", new DeleteStepdefs().getPageSubTitle());
            BrowserUtils.hover(dashboardPage.row.get(1));
            dashboardPage.row.get(1).click();

            dashboardPage.waitUntilLoaderScreenDisappear();
            Assert.assertFalse(dashboardPage.deleteButton.isDisplayed());


        }

    @Then("User should not be able to see the delete button at the right top of the page.")
    public void userShouldNotBeAbleToSeeTheDeleteButtonAtTheRightTopOfThePage() {
    }
//-------------------------
    @When("Hover over ...  rightest side of every car's row.")
    public void hoverOverRightestSideOfEveryCarSRow() {
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
        dashboardPage.delete.click();
        dashboardPage.yesDeleteBtn.click();

        //dashboardPage.waitUntilLoaderScreenDisappear();
        // Assert.assertTrue(dashboardPage.delete.isSelected());


    }

    @Then("User should be able to see the delete option.")
    public void userShouldBeAbleToSeeTheDeleteOption() {
    }
//-----------------------------------
    @And("click on General")
    public void clickOnGeneral() {
        System.out.println(dashboardPage.row.size());
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

        //if(usertype.equals("sales manager")|| usertype.equals("store manager")){
         //   Assert.assertEquals("All Cars", new DeleteStepdefs.getPageSubTitle());
            BrowserUtils.hover(dashboardPage.row.get(0));
            dashboardPage.row.get(1).click();

            dashboardPage.waitUntilLoaderScreenDisappear();
            Assert.assertTrue(dashboardPage.deleteButton.isDisplayed());





        }

    @Then("User should be able to see the delete button at the right top of the page.")
    public void userShouldBeAbleToSeeTheDeleteButtonAtTheRightTopOfThePage() {
    }
//--------------------------
    @When("User hover the mouse on ...")
    public void userHoverTheMouseOn() {
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
        dashboardPage.delete.click();
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
//------------------------------
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
        dashboardPage.delete.click();
        dashboardPage.yesDeleteBtn.click();

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