Feature: Login functionality
  As a user
  I want to log in
  So that I can access my dashboard

  Scenario: Valid login
    Given I am on the login page
    When I enter valid username and password
    And I click the login button
    Then I should be redirected to the dashboard

  Scenario: Invalid login
    Given I am on the login page
    When I enter invalid username and password
    And I click the login button
    Then I should see an error message

  Scenario: Empty username
    Given I am on the login page
    When I leave the username field empty
    And I enter valid password
    And I click the login button
    Then I should see a validation message
