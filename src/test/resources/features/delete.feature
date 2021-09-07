@TRNS-408
Feature:

  Background:  login as driver
    Given the user logged in as "driver"
    And the "driver" navigates to the "Fleet" and "Vehicles"



  @TRNS-392
  Scenario: 002.message should be displayed if the driver attempts to delete a car.

    When Hover over ... which is the rightest side of every car's row.
    Then User can see the delete option.
    And user clicks on delete button.
    And user clicks yes on the pop up
    Then You do not have permission to perform this action." message should be displayed

  @TRNS-407
  Scenario: 003.Driver can NOT see "delete" button on "General Information" page
    When user click one the car which is listed row by row.
#		And click on General
    Then User should not be able to see the delete button at the right top of the page.

#	****************


  @TRNS-390 @wip
  Scenario: 001.Store manager can see the delete option by hovering over "..." on the table at the end of each row
    When Hover over ...  rightest side of every car's row.
    Then User should be able to see the delete option.


  @TRNS-393
  Scenario: 004.Store manager can reach the delete button on the general information page
    When user click one the car which is listed row by row.
    And click on General
    Then User should be able to see the delete button at the right top of the page.


  @TRNS-394
  Scenario: 005.Delete Confirmation pop up should be displayed when the user clicks on the delete button
    When User hover the mouse on ...
    And Delete button should be pop up
    When  user click on delete button.
    Then User should be able to successfully click on delete button and after Delete Confirmation pop up should be displayed.


  @TRNS-395
  Scenario: 006.After deleting a car, "Item deleted" message should be displayed and the corresponding vehicle should be removed from the table
    When user navigate and hover the cursor on ... at the right side of the cars.
    And user sees the delete option.
    And user clicks on delete option.
    And user clicks on Yes,Delete button
    Then user should be able to click on button and successfully see the Car deleted message on the panel.