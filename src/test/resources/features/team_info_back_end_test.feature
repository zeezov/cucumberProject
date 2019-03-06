Feature: Team information back end
  @wip @db
  Scenario: Team members db test
    Given user on the login page
    When user logs in using "mstacey8r@imdb.com" and "skylargiblin"
    When the user goes to the "my team" page
    Then team information should match database records
