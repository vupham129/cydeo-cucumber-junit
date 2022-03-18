Feature: Google search functionality
  Agile story: As a user, when I am on the Google search page
  I should be able to search whatever I want and see relevant information

  Scenario: Search page title verification
    When user is on Google search page
    Then user should see title is Google


  Scenario: Search functionality title verification
    When user is on Google search page
    And user types "apple" in the google search box and clicks enter
    Then user should see "apple" is in the google title