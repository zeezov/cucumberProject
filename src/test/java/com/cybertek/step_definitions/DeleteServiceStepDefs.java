package com.cybertek.step_definitions;

import com.cybertek.pages.SignInPage;
import com.cybertek.utilities.BookITRestUtility;
import com.cybertek.utilities.ConfigurationReader;
import com.cybertek.utilities.DatabaseUtility;
import com.cybertek.utilities.Driver;
import com.github.javafaker.Faker;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.response.Response;
import org.openqa.selenium.WebDriverException;

import java.util.concurrent.TimeoutException;

import static io.restassured.RestAssured.given;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class DeleteServiceStepDefs {

    Response postResponse, deleteResponse;
    String firstName, lastName, email, password;

    @Given("there is a student available")
    public void there_is_a_student_available_in() {
        Faker faker = new Faker();
        firstName = faker.name().firstName();
        lastName = faker.name().lastName();
        email = firstName.toLowerCase() + lastName.toLowerCase() + "@" + faker.internet().domainName();
        password = firstName.toLowerCase() + lastName.toLowerCase();
        String role = "student-team-member";
        int batch = 8;
        String teamName = "CodeHunters";
        String campus = "VA";

        postResponse = given().
                header("Authorization", BookITRestUtility.getTeacherToken()).
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

        postResponse.then().log().all();

    }

    @When("student deleted using the exclude service")
    public void student_deleted_using_the_exclude_service() {
        // to delete we need id
        // get the id from database
        String sql = " select id from users where email = '" + email + "';";
        System.out.println(sql);
        String id = DatabaseUtility.getCellValue(sql).toString();
        System.out.println("id = " + id);

        // using the id we delete that student
        deleteResponse = given().
            header("Authorization", BookITRestUtility.getTeacherToken()).
                pathParam("id", id).
            when().
                delete("/api/students/{id}");

    }

    @Then("the student should be deleted")
    public void the_student_should_be_deleted() {
        deleteResponse.then().log().all().
                assertThat().statusCode(204);

    }

    @Then("the new student information should not be in the database")
    public void the_new_student_information_should_not_be_in_the_database() {
        String sql = " select id from users where email = '" + email + "';";
        try {
            Object res = DatabaseUtility.getCellValue(sql);
            assertThat(res, is(nullValue()));
        } catch (IndexOutOfBoundsException e){
            System.out.println("User with email: "+email+" was not found");
        }
    }

    @Then("the user should not be able to login with the new student info")
    public void the_user_should_not_be_able_to_login_with_the_new_student_info() {

        Driver.getDriver().get(ConfigurationReader.getProperty("url"));
        SignInPage signInPage = new SignInPage();
        try {
            signInPage.login(email, password);
        } catch (WebDriverException e){
            System.out.println("Login was not successful");
        }
        assertThat(Driver.getDriver().getCurrentUrl(), containsString("sign"));

    }


}
