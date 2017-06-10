Feature: Login functionality

  Scenario Outline: Positive login
    Given I am on Home page
    When I sign in as <login>/<password>
    Then I check that name is <username> and logout

    Examples:
      |login  |password|username|
      |epam   |1234    |PITER CHAILOVSKII|

  Scenario Outline: Negative login
    Given I am on Home page
    When I sign in as <login2>/<password2>
    Then I get validation error message

    Examples:
      |login2  |password2|
      |Epam   |1234    |
