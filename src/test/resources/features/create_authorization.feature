Feature: Create student permissions
@wip
  Scenario: Students should not be able to create
    Given the user has access token as a student
    When the user creates a new student
    Then the new student should not be created


  Scenario: Teachers should not be able to create
    Given the user has access token as a student
    When the user creates a new student
    Then the new student should be created