package com.cybertek.step_definitions;

import com.cybertek.utilities.BookITRestUtility;
import com.github.javafaker.Faker;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;


public class CreateUserAPIStepDefs {

    String token;

    @Given("the user has access token as a student")
    public void the_user_has_access_token_as_a_student() {
        token = BookITRestUtility.getStudentToken();
        System.out.println("token = " + token);
    }

    @When("the user creates a new student")
    public void the_user_creates_a_new_student() {
        Faker faker = new Faker();
        String firstName = faker.name().firstName();
        String lastName = faker.name().lastName();
        String email = firstName.toLowerCase() + lastName.toLowerCase() + "@" + faker.internet().domainName();
        String password = firstName.toLowerCase() + lastName.toLowerCase();
        String role = "student-team-member";
        int batch = 8;
        String teamName = "CodeHunters";
        String campus = "VA";


        Response post = given().
                header("Authorization", token).
                queryParam("first-name", firstName).
                queryParam("last-name", lastName).
                queryParam("email", email).
                queryParam("password", password).
                queryParam("role", role).
                queryParam("campus-location", campus).
                queryParam("batch-number", batch).
                queryParam("team-name", teamName).
                when().
                post("/api/students/student");
        post.then().log().status();

    }

    @Then("the new student should not be created")
    public void the_new_student_should_not_be_created() {
        // Write code here that turns the phrase above into concrete actions
        throw new cucumber.api.PendingException();
    }

}
