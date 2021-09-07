@TRNS-422
Feature:

  Background: user navigates vehicles
    Given the user logged in as "driver"
    And the "driver" navigates to the "Fleet" and "Vehicles"
    Given the user clicks on filter button
    Then the user clicks on manage filters
    When the user clicks on Driver checkbox

@417
  Scenario: Driver button
    And the Driver button should be selected
@418
  Scenario:options

    Then the user clicks on Driver all
    And the user clicks on contains tab
    Then the user should see following options
      | Contains         |
      | Does Not Contain |
      | Is Equal To      |
      | Starts With      |
      | Ends With        |
      | Is Any Of        |
      | Is Not Any Of    |
      | Is Empty         |
      | Is Not Empty     |

 @419
  Scenario: Contains method with a keyword

    Then the user clicks on Driver all
    And the user clicks on contains tab
    And the user clicks on choose contains method
    Then user send "Ali" the results should contain the specified keyword
@420
  Scenario: Does Not Contain method with a keyword

    Then the user clicks on Driver all
    And the user clicks on contains tab
    And the user clicks on choose does not contain method
    Then user send "Ali" the results should not contain the specified keyword


  @421 @wip
  Scenario:Methods should accept only alphabetical characters

    Then the user clicks on Driver all
    And the user clicks on contains tab
    And the user clicks on choose contains method
    Then user send "5" the results should not contain the number
