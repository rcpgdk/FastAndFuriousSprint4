


Feature: Car Entities Future

  @TRNS-401
  Scenario Outline: Login with different usertypes

    Given the user logged in as "<usertype>"
    And the "<usertype>" navigates to the "Fleet" and "Vehicles"
    Then the "<usertype>" should see all Vehicle information

    Examples:

      | usertype      |
      | driver        |
      | sales manager |
      | store manager |


  @TRNS-402
    Scenario Outline: pages changes
      Given the user logged in as "<usertype>"
      And the "<usertype>" navigates to the "Fleet" and "Vehicles"
      Then all users should see the page number

    Examples:

      | usertype      |
      | driver        |
      | sales manager |
      | store manager |

    @TRNS-403
    Scenario Outline: page click
      Given the user logged in as "<usertype>"
      And the "<usertype>" navigates to the "Fleet" and "Vehicles"
      Then user goes next page clicking > button and can go to previous page clicking < button
      Examples:

        | usertype      |
        | driver        |
        | sales manager |
        | store manager |


    @TRNS-404

  Scenario Outline: User can see total recordings of vehicles
    Given the user logged in as "<usertype>"
    And the "<usertype>" navigates to the "Fleet" and "Vehicles"
    Then user  should see total recordings of vehicles
    Examples:

      | usertype      |
      | driver        |
      | sales manager |
      | store manager |



  @TRNS-405
  Scenario Outline: User can see total recordings of vehicles
    Given the user logged in as "<usertype>"
    And the "<usertype>" navigates to the "Fleet" and "Vehicles"
    When the user clicks on CSV or XLSX flash message should displayed


    Examples:
      | usertype      |
      | driver        |
      | sales manager |
      | store manager |














