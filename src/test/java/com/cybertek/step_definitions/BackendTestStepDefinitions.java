package com.cybertek.step_definitions;

import com.cybertek.pages.MyTeamPage;
import com.cybertek.utilities.BrowserUtils;
import com.cybertek.utilities.DatabaseUtility;
import cucumber.api.java.en.Then;

public class BackendTestStepDefinitions {

    @Then("team information should match database records")
    public void team_information_should_match_database_records() {

        MyTeamPage myTeamPage = new MyTeamPage();
        BrowserUtils.wait(3);
        String teamName = myTeamPage.teamName.getText();
        System.out.println(teamName);

        String sql = "select id from team where name = '"+teamName+"'";
        DatabaseUtility.createConnection();
        System.out.println(sql);
        String id = DatabaseUtility.getCellValue(sql).toString();
        System.out.println(id);
    }

}
