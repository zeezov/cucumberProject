package com.cybertek.step_definitions;

import com.cybertek.pages.MapPage;
import com.cybertek.utilities.BrowserUtils;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;

import java.util.List;

public class MapDetailsStepDefinitions {


    @Then("I should be able to see {string} room")
    public void i_should_be_able_to_see_room(String roomName) {
        // get list of all the room names and convert into list string
        MapPage mapPage = new MapPage();
        // getting the list of rooms as a webelement from the mappage
        // and returning it as a list of string using the utility method
        List<String> allRooms = BrowserUtils.getElementsText(mapPage.allRooms);
        // verify that list contains the expected room name
        Assert.assertTrue("Room was not found: "+roomName, allRooms.contains(roomName));

    }


    @Then("the user should be able to see following conference rooms:")
    public void the_user_should_be_able_to_see_following_conference_rooms(List<String> rooms) {
        System.out.println(rooms);
        System.out.println(rooms.size());
    }


    @When("the user goes to the {string} page")
    public void the_user_goes_to_the_page(String page) {
        MapPage mapPage = new MapPage();
        switch (page){
            case "map":
                mapPage.map.click();
                break;
            case "hunt":
                mapPage.hunt.click();
                break;
            case "my self":
                mapPage.goToSelf();
                break;
            case "my team":
                mapPage.goToTeam();
                break;
        }

    }

    @Then("following team members should be displayed:")
    public void following_team_members_should_be_displayed(io.cucumber.datatable.DataTable dataTable) {
        // Write code here that turns the phrase above into concrete actions
        // For automatic transformation, change DataTable to one of
        // E, List<E>, List<List<E>>, List<Map<K,V>>, Map<K,V> or
        // Map<K, List<V>>. E,K,V must be a String, Integer, Float,
        // Double, Byte, Short, Long, BigInteger or BigDecimal.
        //
        // For other transformations you can register a DataTableType.
        throw new cucumber.api.PendingException();
    }


}
