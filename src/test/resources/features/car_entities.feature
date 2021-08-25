


Feature: Car Entities Future
  @wip
  Scenario Outline: Login with different usertypes

    Given the user logged in as "<usertype>"
    And the "<usertype>" navigates to the "Fleet" and "Vehicles"
    Examples:

      | usertype      |
      | driver        |
      | sales manager |
      | store manager |