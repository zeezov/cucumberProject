package com.cybertek.step_definitions;

import com.cybertek.pages.MySelfPage;
import com.cybertek.pages.MyTeamPage;
import com.cybertek.utilities.BrowserUtils;
import com.cybertek.utilities.DatabaseUtility;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import org.junit.Assert;

import java.util.List;
import java.util.Map;

public class BackendTestStepDefinitions {

    @Then("team information should match database records")
    public void team_information_should_match_database_records() {
        // get the name of the team, it will be used to get tem id
        MyTeamPage myTeamPage = new MyTeamPage();
        BrowserUtils.wait(3);
        String teamName = myTeamPage.teamName.getText();
        System.out.println(teamName);
        // build the sql based on the team name
        String sql = "select u.firstname " +
                " from users u join team t on t.id = " +
                "u.team_id and t.name = '" + teamName + "';";
        // getColumnData returns data of a single column
        List<Object> names = DatabaseUtility.getColumnData(sql, "firstname");

        System.out.println(names);
        // get the actual name
        List<String> actualNames = BrowserUtils.getElementsText(myTeamPage.allNames);

        Assert.assertEquals(names.size(), actualNames.size());
        // make sure all names appear in the expected list
        for (Object name : names) {
            Assert.assertTrue(actualNames.contains(name.toString()));
        }


    }

    List<Object> clusterTable;

    @Given("there is a list of clusters in the clusters table")
    public void there_is_a_list_of_clusters_in_the_clusters_table() {
        // get the list of id from the cluster table
        String sql = "select * from cluster;";
        clusterTable = DatabaseUtility.getColumnData(sql, "id");
        System.out.println(clusterTable);
    }

    List<Object> roomTable;

    @Given("all rooms have a clusters id in room table")
    public void all_rooms_have_a_clusters_id_in_room_table() {
        // get the list of cluster_id from tjeh room table
        String sql = "select * from room;";
        roomTable = DatabaseUtility.getColumnData(sql, "cluster_id");
        System.out.println(roomTable);
    }


    @Then("all the clusters ids must be from the clusters table")
    public void all_the_clusters_ids_must_be_from_the_clusters_table() {
        // compare
        for (Object o : roomTable) {
            Assert.assertTrue(clusterTable.contains(o));
        }
    }

    @Then("correct user information should be displayed for {string}")
    public void correct_user_information_should_be_displayed_for(String email) {
        String sql = "SELECT firstname, lastname, t.name " +
                "FROM users u " +
                "JOIN team t " +
                "ON t.id =u.team_id " +
                "WHERE email = '"+email+"';";
        Map<String, Object> userInfo = DatabaseUtility.getRowMap(sql);

        System.out.println(userInfo);
        String eName = userInfo.get("firstname") + " " +userInfo.get("lastname");
        String eTeam = userInfo.get("name").toString();
        System.out.println(eName);
        System.out.println(eTeam);

        MySelfPage mySelfPage = new MySelfPage();

        Assert.assertEquals(eName, mySelfPage.name.getText());
        Assert.assertEquals(eTeam, mySelfPage.team.getText());

    }


}
