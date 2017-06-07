Feature: Login functionality

  Scenario Outline: Positive login
    Given I am on Home page
    When I type credentials as <login>/<password>
    Then Profile name is <username>

    Examples:
      |login  |password|username|
      |epam   |1234    |PITER CHAILOVSKII|

  Scenario Outline: Negative login
    Given I am on Home page
    When I type credentials as <login2>/<password2>
    Then I get validation error message

    Examples:
      |login2  |password2|
      |Epam   |1234    |
