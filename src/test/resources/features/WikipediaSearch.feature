@WikipediaSearch
  Feature: Wikipedia search functionality
    As a user, I should be able to search on Wikipedia home page

    Background: For the scenarios in the feature file, user is expected on Wikipedia home page
      Given user is on Wikipedia home page
      When user types "Steve Jobs" in the wiki search box
      And user clicks wiki search button

  @title
  Scenario: Wikipedia search functionality title verification
    Then user sees "Steve Jobs" is in the wiki title

  @header
  Scenario: Wikipedia search functionality header verification
    Then user sees "Steve Jobs" is in the main header

  @imageHeader
  Scenario: Wikipedia search functionality image header verification
    Then user sees "Steve Jobs" is in the image header
