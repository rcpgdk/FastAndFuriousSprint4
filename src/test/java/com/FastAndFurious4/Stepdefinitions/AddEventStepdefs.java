package com.FastAndFurious4.Stepdefinitions;

import com.FastAndFurious4.pages.*;
import com.FastAndFurious4.utilities.BrowserUtils;
import com.FastAndFurious4.utilities.ConfigurationReader;
import com.FastAndFurious4.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.List;

public class AddEventStepdefs {

    AddEventPage addEventPage = new AddEventPage();
   LoginPage loginPage = new LoginPage();



    @And("the user navigates to the {string} and {string}")
    public void theUserNavigatesToTheAnd(String tab, String module) {

        DashboardPage dashboardPage = new DashboardPage();
        dashboardPage.waitUntilLoaderScreenDisappear();
        BrowserUtils.waitForPageToLoad(5);
        dashboardPage.navigateToModule(tab,module);
    }

    @When("the user clicks on one of the Vehicle information")
    public void theUserClicksOnOneOfTheVehicleInformation() {
        BrowserUtils.waitFor(2);
        new CarsPage().firstRowCar.click();
    }




    @Then("the user should be able to see the {string} page")
    public void theUserShouldBeAbleToSeeThePage(String expectedTitle) {

        BrowserUtils.waitForVisibility(new GeneralInformationPage().generalInfoTitle,3);
        Assert.assertEquals(expectedTitle, new GeneralInformationPage().generalInfoTitle.getText());

    }

    @Then("Driver should not able to click on AddEvent button")
    public void driverShouldNotAbleToClickOnAddEventButton() {

        Assert.assertFalse("Add Event enabled", new GeneralInformationPage().addEventButton.isEnabled());
    }

    @And("the user clicks on Add event button")
    public void theUserClicksOnAddEventButton() {

        GeneralInformationPage generalInformationPage = new GeneralInformationPage();
        BrowserUtils.waitForClickablility(generalInformationPage.addEventButton,3);
        generalInformationPage.addEventButton.click();
    }

    @Then("compulsory fields are as below")
    public void compulsoryFieldsAreAsBelow(List<String> expectedCompulsoryFields) {
        BrowserUtils.waitFor(4);
        AddEventPage addEventPage = new AddEventPage();
        List<String> actualCompulsoryFields = BrowserUtils.getElementsText(addEventPage.actualCompulsoryFields);
        System.out.println("actualCompulsoryFields = " + actualCompulsoryFields);

        List<String> newActualFields = new ArrayList<>();
        for(String each : actualCompulsoryFields){
            each=each.substring(0,each.length()-1);

            newActualFields.add(each);
            System.out.println("each = " + each);
        }
        System.out.println("expectedCompulsoryFields = " + expectedCompulsoryFields);
        System.out.println("newActualFields = " + newActualFields);

        Assert.assertEquals(expectedCompulsoryFields,newActualFields);
    }


    @And("the user leaves empty compulsory fields")
    public void theUserLeavesEmptyCompulsoryFields() {

        addEventPage.startTextBox.clear();
        addEventPage.endTextBox.clear();
    }

    @And("the user clicks on save button")
    public void theUserClicksOnSaveButton() {

        BrowserUtils.waitForClickablility(addEventPage.saveBtn,3);
        BrowserUtils.clickWithJS(addEventPage.saveBtn);
        BrowserUtils.waitFor(3);
    }

    @Then("{string} message should be displayed")
    public void messageShouldBeDisplayed(String expectedMessage) {

       for(WebElement each : addEventPage.AppearedCompulsoryBlankText){
           Assert.assertEquals(expectedMessage, each.getText());

       }

       Assert.assertEquals(6,addEventPage.AppearedCompulsoryBlankText.size());

    }

    @Then("the user should be able to click on the event colored marks to determine urgency level")
    public void theUserShouldBeAbleToClickOnTheEventColoredMarksToDetermineUrgencyLevel() {
        for (WebElement each: addEventPage.colorsUrgencyLevel){
            each.clear();
            BrowserUtils.waitFor(1);
            Assert.assertTrue(each.isSelected());
        }
    }

    @Then("the user should be able to mark on All-day event button")
    public void theUserShouldBeAbleToMarkOnAllDayEventButton() {

        addEventPage.allDayEventCheckBox.click();
        for(WebElement each : addEventPage.startEndTime){
            Assert.assertFalse(each.isDisplayed());
        }
    }

    @Then("occurrence interval options listed below are available")
    public void occurrenceIntervalOptionsListedBelowAreAvailable(List<String> expectedRepeatOptions) {

        BrowserUtils.waitForPageToLoad(4);
        Select select = new Select(addEventPage.selectRepeats);
        List<WebElement> actual = select.getOptions();
        List<String> actualString = new ArrayList<>();

        for(WebElement each : actual){
            actualString.add(each.getText());
        }
        Assert.assertEquals(expectedRepeatOptions,actualString);

    }

    @And("ending options below are available")
    public void endingOptionsBelowAreAvailable(List<String> expectedOccurance) {

        List<String > actualList = BrowserUtils.getElementsText(addEventPage.endsOccurance);
        Assert.assertEquals(expectedOccurance,actualList);
    }

    @And("the user is able to add a description")
    public void theUserIsAbleToAddADescription() {
        BrowserUtils.waitFor(2);
        Driver.get().switchTo().frame("oro_calendar_event_form_description-uid-6135d24fb9ee6_ifr");

        addEventPage.addDescriptionBox.sendKeys("description");

    }
}
