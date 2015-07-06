Feature: Greetings

  This greetings feature tests adding new names

  Scenario: addOneNewName
    Given the website is active
    When I want to add the name "Jimmy"
    Then the name should be returned with an ID and the name "Jimmy"