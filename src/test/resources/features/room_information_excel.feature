Feature: room information functionality


  Scenario: Room details
    Given user on the login page
    When user logs in using "daldie7l@seattletimes.com" and "ruthannjohnes"
    Then correct room information should be displayed for light side
#    And room information should be displayed as given in "file_path" "sheetname"

  @wip
  Scenario Outline: my information data driven test with excel <user_name>
    Given user on the login page
    And user logs in using "<user_email>" and "<user_password>"
    When my self page should display personal information for that user

    Examples:
      | user_email                    | user_password     |
      | lruffli93@dailymail.co.uk     | menardnewbatt     |
      | elaye8m@wikipedia.org         | tabordullingham   |
