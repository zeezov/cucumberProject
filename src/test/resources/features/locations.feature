Feature: campus locations

  @wip
  Scenario: VA - dark side
    Given user on the login page
    When user logs in using "mstacey8r@imdb.com" and "skylargiblin"
    Then location should be "dark-side"