/*Bohdan Pysarenko © All right reserved.
 *
 */
package com.castilleresources.springdemo.stepdefs;


import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;
import static org.assertj.core.api.Assertions.*;

import io.cucumber.java.PendingException;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

/**
 * An implementation of
 *
 * @param
 * @author Bohdan Pysarenko
 * @version 1.0
 * @since 1.0
 */
public class EmployeeEndpointStepDefs {

    private Response response;
    private ValidatableResponse json;
    private RequestSpecification request;
    private static final String URL = "localhost:8080/api/v1/employees";

    @Given("^I want to execute create employee endpoint$")
    public void iWantToExecuteCreateEmployeeEndpoint() throws Throwable {
        request = given().contentType(ContentType.JSON).body("{\n" +
                "\"firstName\": \"BB\",\n" +
                "\"lastName\": \"King\",\n" +
                "\"emailId\": \"test3@gmail.com\"\n" +
                "}");
    }

    @When("^I submit the POST request with new employee$")
    public void iSubmitThePostRequestWithNewEmployee() throws Throwable{

    }

    @Then("I get {int} Status code")
    public void iGetStatusCode(Integer code) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @Then("response contains employee's id")
    public void responseContainsEmployeeId() throws Throwable{
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }
}
