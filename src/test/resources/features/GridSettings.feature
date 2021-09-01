@TRNS-409
Feature:

  Background:
    Given the user is on the login page
    When the user is logged in as a "driver"
    And the user navigates to "Fleet" and "Vehicles"

  @TRNS-397
  Scenario: Column names
    When the user clicks on grid settings button
    Then the user should see following column names
      | Id                        |
      | License Plate             |
      | Tags                      |
      | Driver                    |
      | Location                  |
      | Chassis Number            |
      | Model Year                |
      | Last Odometer             |
      | Immatriculation Date      |
      | First Contract Date       |
      | Catalog Value (VAT Incl.) |
      | Seats Number              |
      | Doors Number              |
      | Color                     |
      | Transmission              |
      | Fuel Type                 |
      | CO2 Emissions             |
      | Horsepower                |
      | Horsepower Taxation       |
      | Power (KW)                |

  @TRNS-398
  Scenario: Quick Search
    When the user clicks on grid settings button
    And the user searches for available options
    Then the corresponding results should be displayed

  @TRNS-399
  Scenario: Selecting columns
    When the user clicks on grid settings button
    And the user clicks on Select all button
    Then the corresponding columns should be displayed

  @TRNS-400
  Scenario: Arranging order of columns
    When the user clicks on grid settings button
    And the user clicks on Select all button
    When the user arranges corresponding columns by dragging and dropping
    Then the user should see corresponding changes on the Cars table