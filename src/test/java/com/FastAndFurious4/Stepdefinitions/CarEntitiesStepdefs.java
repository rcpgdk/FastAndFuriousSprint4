package com.FastAndFurious4.Stepdefinitions;

import com.FastAndFurious4.pages.CarEntitiesPage;
import com.FastAndFurious4.pages.DashboardPage;
import com.FastAndFurious4.pages.LoginPage;
import com.FastAndFurious4.utilities.BrowserUtils;
import com.FastAndFurious4.utilities.ConfigurationReader;
import com.FastAndFurious4.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import org.junit.Assert;
import org.openqa.selenium.By;
import sun.rmi.runtime.Log;

public class CarEntitiesStepdefs {
    @Given("the user logged in as {string}")
    public void theUserLoggedInAs(String usertype) {

        Driver.get().get(ConfigurationReader.get("url"));
        String username=null;
        String password=null;

        if(usertype.equals("driver")){
            username=ConfigurationReader.get("driver_username");
            password=ConfigurationReader.get("driver_password");
            new LoginPage().login(username,password);
            Assert.assertEquals("Quick Launchpad", new DashboardPage().getPageSubTitle());

        }

        else if(usertype.equals("sales manager")){

            username=ConfigurationReader.get("sales_manager_username");
            password=ConfigurationReader.get("sales_manager_password");
            new LoginPage().login(username,password);
            Assert.assertEquals("Dashboard",new DashboardPage().getPageSubTitle());

        }
        else if(usertype.equals("store manager")){

            username=ConfigurationReader.get("store_manager_username");
            password=ConfigurationReader.get("store_manager_password");
            new LoginPage().login(username,password);
            Assert.assertEquals("Dashboard",new DashboardPage().getPageSubTitle());

        }









    }



    @And("the {string} navigates to the {string} and {string}")
    public void theNavigatesToTheAnd(String usertype, String tab, String module) {


        new DashboardPage().navigateToModule(tab,module);
        BrowserUtils.waitFor(3);

        if(usertype.equals("driver")){
            System.out.println(new CarEntitiesPage().pageSubTitle);
            Assert.assertEquals("Cars", new CarEntitiesPage().getPageSubTitle());


        }

        if(usertype.equals("sales manager")|| usertype.equals("store manager")){
            System.out.println(new CarEntitiesPage().pageSubTitle);
            Assert.assertEquals("All Cars", new CarEntitiesPage().getPageSubTitle());

        }





    }
}

