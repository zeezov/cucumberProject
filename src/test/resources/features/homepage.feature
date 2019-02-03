Feature: Home page
  As a user, when I enter correct login information,
  I should be able to login

  @leader
  Scenario: login as team lead
    Given user on the login page
    When user logs in as a team lead
    Then homepage should be displayed
    And the title should be correct

  @member
  Scenario: login as team member
    Given user on the login page
    When user logs in as a team member
    Then homepage should be displayed

  @teacher
  Scenario: login as teacher
    Given user on the login page
    When user logs in as a teacher
    Then homepage should be displayed

