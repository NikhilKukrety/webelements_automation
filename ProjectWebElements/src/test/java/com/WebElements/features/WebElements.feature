@WebElementsPractice
Feature: To verify user is able to practice all the webelements in the practice page

  @FullRegression
  Scenario: Verify user is able to select the radio button successfully
    Given User is on the Web Elements practice page
    When User selects a radio button
    Then Selected radio button should be printed as a string
    And user selects a country from country suggestion field
    And User selects a dropdown value
    And User selects an option from checkbox
    And User performs window switching operation successfully
    And User performs tab switching operation successfully
    And User performs alert operations successfully
    And User enters row and column number to fetch the table content
    And User clicks on Hide button
    And User clicks on Show button
    And user enters row and column number to fetch the fixed header table content
    And User performs mouse hover activities
    And User closes the browser
