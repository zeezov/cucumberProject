package com.cybertek.step_definitions;

import com.cybertek.utilities.Driver;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class HomePageStepDefinitions {

// OPTION + ENTER       MAC
// ALT + ENTER       WINDOWS

    @When("user logs in as a team lead")
    public void user_logs_in_as_a_team_lead() {
        System.out.println("I am logging in");
    }

    @Given("user on the login page")
    public void user_on_the_login_page() {
        System.out.println("I am opening the login page");
    }

    @Then("homepage should be displayed")
    public void homepage_should_be_displayed() {
        System.out.println("I can see the home page now!!");
    }


    @Then("the title should be correct")
    public void the_title_should_be_correct() {
        // Write code here that turns the phrase above into concrete actions
        throw new cucumber.api.PendingException();
    }

}

