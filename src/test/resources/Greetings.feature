Feature: Greetings

  This greetings feature tests adding new names

  Scenario: addOneNewName
    Given the website is active
    When I add the name "Jimmy"
    Then the name should be returned with an ID and the name "Jimmy"

  Scenario Outline: addTwoNewNames
    Given the website is active
    When I add the name "<names>"
    Then the name should be returned with an ID and the name "<names>"
    Examples:
      |names|
      |mary |
      |bob  |