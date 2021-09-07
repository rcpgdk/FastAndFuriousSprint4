package com.FastAndFurious4.Stepdefinitions;

import com.FastAndFurious4.pages.CarsPage;
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
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.List;

public class GridSettingsDefs {


    LoginPage loginPage = new LoginPage();
    DashboardPage dashboardPage = new DashboardPage();
    CarsPage carsPage = new CarsPage();

    @Given("the user is on the login page")
    public void the_user_is_on_the_login_page() {
        Driver.get().get(ConfigurationReader.get("url"));
    }

    @When("the user is logged in as a {string}")
    public void the_user_is_logged_in_as_a(String userType) {

        String username = null;
        String password = null;

        switch (userType){

            case "driver":
                username = ConfigurationReader.get("driver_username");
                password = ConfigurationReader.get("driver_password");
                break;
            case "store manager":
                username = ConfigurationReader.get("sales_manager_username");
                password = ConfigurationReader.get("sales_manager_password");
                break;
            case "sales manager":
                username = ConfigurationReader.get("store_manager_username");
                password = ConfigurationReader.get("store_manager_password");
                break;
            default:
                System.out.println("INVALID user type");
                break;

        }
        loginPage.login(username, password);
    }

    @When("the user navigates to {string} and {string}")
    public void the_user_navigates_to_and(String tab, String module) {

        dashboardPage.waitUntilLoaderScreenDisappear();
        dashboardPage.navigateToModule(tab, module);

    }

    @When("the user clicks on grid settings button")
    public void theUserClicksOnGridSettingsButton() {
        dashboardPage.waitUntilLoaderScreenDisappear();
        carsPage.gridSettingsButton.click();
    }

    @Then("the user should see following column names")
    public void theUserShouldSeeFollowingColumnNames(List<String> expectedColumnNames) {

//        List<String> actualList = new ArrayList<>();
//
//        for (WebElement actualColumnNames : carsPage.columnNames) {
//            actualList.add(actualColumnNames.getText());
//            System.out.println(actualColumnNames.getText());
//        }
//
//        Assert.assertEquals(expectedColumnNames, actualList);

        List<String> actualList = BrowserUtils.getElementsText(carsPage.columnNames);
        Assert.assertEquals(expectedColumnNames, actualList);
    }

    @And("the user clicks on Select all button")
    public void theUserClicksOnSelectAllButton() {
        BrowserUtils.clickWithJS(carsPage.selectAll);
    }

    @Then("the corresponding columns should be displayed")
    public void theCorrespondingColumnsShouldBeDisplayed() {

        carsPage.closeGridSettings.click();
        //asserting that first 15 elements are displayed
        for (int i = 1; i <= 15; i++) {
            WebElement element = Driver.get().findElement(By.xpath("(//table)[3]/thead/tr/th[" + i + "]"));
            Assert.assertTrue(element.isDisplayed());
        }
    }

    @Then("the user arranges corresponding columns by dragging and dropping")
    public void theUserArrangesCorrespondingColumnsByDraggingAndDropping() {

        int count = 1;

        for (int i = 0; i < carsPage.columnNames.size()-1; i++) {
            count++;

            Actions actions = new Actions(Driver.get());
            WebElement source = Driver.get().findElement(By.xpath("(//td[@class='sort-cell']//i)[" + count + "]"));
            WebElement target = Driver.get().findElement(By.xpath("(//td[@class='sort-cell']//i)[1]"));

            actions.dragAndDrop(source,target).perform();
        }

        //for checking separate items with drag and drop
//        Actions actions = new Actions(Driver.get());
//        WebElement source = Driver.get().findElement(By.xpath("(//td[@class='sort-cell']//i)[1]"));
//        WebElement target = Driver.get().findElement(By.xpath("(//td[@class='sort-cell']//i)[15]"));
//
//        actions.dragAndDrop(source,target).perform();
    }


    @And("the user searches for available options")
    public void theUserSearchesForAvailableOptions() {

        String[] options = {"Id", "License Plate", "Tags", "Driver", "Location", "Chassis Number",
                "Model Year", "Last Odometer", "Immatriculation Date", "First Contract Date", "Catalog Value (VAT Incl.)",
                "Seats Number", "Doors Number", "Color", "Transmission", "Fuel Type", "CO2 Emissions",
                "Horsepower", "Horsepower Taxation", "Power (KW)"};

        for (int i = 0; i <options.length ; i++) {

            carsPage.quickSearchInput.sendKeys(options[i]);

            carsPage.quickSearchInput.clear();
            System.out.println(options[i]);
        }

    }

    @Then("the corresponding results should be displayed")
    public void theCorrespondingResultsShouldBeDisplayed() {

        String[] options = {"Id", "License Plate", "Tags", "Driver", "Location", "Chassis Number",
                "Model Year", "Last Odometer", "Immatriculation Date", "First Contract Date", "Catalog Value (VAT Incl.)",
                "Seats Number", "Doors Number", "Color", "Transmission", "Fuel Type", "CO2 Emissions",
                "Horsepower", "Horsepower Taxation", "Power (KW)"};

        int count = 0;

        for (int i = 0; i <options.length ; i++) {

            carsPage.quickSearchInput.sendKeys(options[i]);
            count++;

            WebElement element = Driver.get().findElement(By.xpath("(//td[@class='title-cell']//label)[" + count + "]"));
            Assert.assertTrue(element.isDisplayed());

            carsPage.quickSearchInput.clear();
            System.out.println(options[i]);
        }

    }

    @Then("the user should see corresponding changes on the Cars table")
    public void theUserShouldSeeCorrespondingChangesOnTheCarsTable() {

        int count = 1;

        for (int i = 0; i < carsPage.columnNames.size()-1; i++) {
            count++;

            Actions actions = new Actions(Driver.get());
            WebElement source = Driver.get().findElement(By.xpath("(//td[@class='sort-cell']//i)[" + count + "]"));
            WebElement target = Driver.get().findElement(By.xpath("(//td[@class='sort-cell']//i)[1]"));

            actions.dragAndDrop(source,target).perform();

            String first = Driver.get().findElement(By.xpath("(//table)[3]/thead/tr/th[1]")).getText();
            String second = Driver.get().findElement(By.xpath("(//td[@class='title-cell']//label)[1]")).getText();

            Assert.assertEquals(first.equalsIgnoreCase(second), second.equalsIgnoreCase(first));

        }


    }
}