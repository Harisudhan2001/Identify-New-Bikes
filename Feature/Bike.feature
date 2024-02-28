Feature: Identify New Bikes

  Scenario: Upcoming Bikes
    Given Navigate to ZigWheels website
    When User Hover to New Bikes Option
    And User click Upcoming Bikes from the dropdown
    Then User navigate to Upcoming Bikes Page
    When User select Honda from Manufacturers dropdown
    And User click ReadMore option
    Then User displays Upcoming Honda Bikes which is less than 4lac

  Scenario: Popular Cars
    When User Hover Used Cars
    And User click Chennai option from the dropdown
    Then User navigate to UsedCars in Chennai page
    And User displays Popular models in the list

  Scenario: Login
    When User clicks login button
    And User gives invalid input
    Then User gets the error message
