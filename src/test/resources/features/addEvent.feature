Feature: Add Event Page

  @TRNS-424
  Scenario Outline: Add event page for store manager/sales manager
    Given the user logged in as "<userType>"
    And the user navigates to the "Fleet" and "Vehicles"
    When the user clicks on one of the Vehicle information
    Then the user should be able to see the "General Information" page

    Examples:

      | userType      |
      | store manager |
      | sales manager |

    @TRNS-425
  Scenario: Driver cannot add event
    Given the user logged in as "driver"
    And the user navigates to the "Fleet" and "Vehicles"
    When the user clicks on one of the Vehicle information
    Then the user should be able to see the "General Information" page
    Then Driver should not able to click on AddEvent button

      @TRNS-426
  Scenario Outline: Compulsory fields should be filled
    Given the user logged in as "<userType>"
    And the user navigates to the "Fleet" and "Vehicles"
    When the user clicks on one of the Vehicle information
    Then the user should be able to see the "General Information" page
    And the user clicks on Add event button
    Then compulsory fields are as below

      | Title                  |
      | Owner                  |
      | Organizer display name |
      | Organizer email        |
      | Start                  |
      | End                    |

    Examples:
      | userType      |
      | store manager |
      | sales manager |

        @TRNS-427
  Scenario Outline: Blank message should be displayed if any compulsory Field is empty
    Given the user logged in as "<userType>"
    And the user navigates to the "Fleet" and "Vehicles"
    When the user clicks on one of the Vehicle information
    Then the user should be able to see the "General Information" page
    And the user clicks on Add event button
    And the user leaves empty compulsory fields
    And the user clicks on save button
    Then "This value should not be blank." message should be displayed

    Examples:
      | userType      |
      | store manager |
      | sales manager |

  #Scenario Outline: color marking for urgency level
    #Given the user logged in as "<userType>"
    #And the user navigates to the "Fleet" and "Vehicles"
   # When the user clicks on one of the Vehicle information
   # Then the user should be able to see the "General Information" page
   # And the user clicks on Add event button
   # Then the user should be able to click on the event colored marks to determine urgency level

   # Examples:
     # | userType      |
     # | store manager |
    #  | sales manager |

  #Scenario Outline: color marking for urgency level
  #  Given the user logged in as "<userType>"
   # And the user navigates to the "Fleet" and "Vehicles"
   # When the user clicks on one of the Vehicle information
   # Then the user should be able to see the "General Information" page
   # And the user clicks on Add event button
   # Then the user should be able to mark on All-day event button

    #Examples:
      #| userType      |
     # | store manager |
     # | sales manager |

#  Scenario Outline: color marking for urgency level
 #   Given the user logged in as "<userType>"
 #   And the user navigates to the "Fleet" and "Vehicles"
 #   When the user clicks on one of the Vehicle information
 #   Then the user should be able to see the "General Information" page
   # And the user clicks on Add event button
   # Then occurrence interval options listed below are available
     # | Daily   |
    #  | Weekly  |
     # | Monthly |
     # | Yearly  |

 #   And ending options below are available

      #| Never |
     # | After |
     # | By    |

   # Examples:
    #  | userType      |
    #  | store manager |
    #  | sales manager |

@TRNS-428
  Scenario Outline: User can add a description
    Given the user logged in as "<userType>"
    And the user navigates to the "Fleet" and "Vehicles"
    When the user clicks on one of the Vehicle information
    Then the user should be able to see the "General Information" page
    And the user is able to add a description

    Examples:
      | userType      |
      | store manager |
      | sales manager |

