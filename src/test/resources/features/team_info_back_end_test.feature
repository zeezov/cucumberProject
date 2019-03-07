Feature: Team information back end
 @db
  Scenario: Team members db test
    Given user on the login page
    When user logs in using "mstacey8r@imdb.com" and "skylargiblin"
    When the user goes to the "my team" page
    Then team information should match database records

   @db
  Scenario: Verify rooms and clusters
    Given there is a list of clusters in the clusters table
    And all rooms have a clusters id in room table
    Then all the clusters ids must be from the clusters table

  @db @wip
  Scenario: verify user information per database
    Given user on the login page
    When user logs in using "mstacey8r@imdb.com" and "skylargiblin"
    When the user goes to the "my self" page
    Then correct user information should be displayed for "mstacey8r@imdb.com"
