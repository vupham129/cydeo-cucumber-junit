@GoogleSearchTitle
Feature: Google search functionality title verification
  As a user, I should be able to search with search box on google webpage

  Scenario: Google search page
    When user is on Google search page
    And user types "apple" in the google search box and clicks enter
    Then user should see "Steve Jobs" is in the google title
