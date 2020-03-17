/*Bohdan Pysarenko © All right reserved.
 *
 */
package com.castilleresources.springdemo.stepdefs;


import static org.assertj.core.api.Assertions.*;

import com.castilleresources.springdemo.model.Employee;
import com.castilleresources.springdemo.sql.DbInitializer;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.After;
import org.junit.Before;

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
    private RequestSpecification request;
    private static final String URL = "http://localhost:8080/api/v1";
    private static final String ENDPOINT = "/employees";
    private static long userId;

    private DbInitializer dbInitializer = new DbInitializer();

//    @Before
//    public void initDB(){
//        dbInitializer.initDb();
//        dbInitializer.populateDb();
//    }
//
//    @After
//    public void cleanDb(){
//        dbInitializer.cleanDb();
//    }

    @Given("^I want to execute create employee endpoint$")
    public void iWantToExecuteCreateEmployeeEndpoint() {
        RestAssured.baseURI = URL;
        request = RestAssured.given()
                .contentType(ContentType.JSON)
                .body("{\n" +
                        "\"firstName\": \"BB\",\n" +
                        "\"lastName\": \"King\",\n" +
                        "\"emailId\": \"test3@gmail.com\"\n" +
                        "}");
    }

    @When("^I submit the POST request with new employee$")
    public void iSubmitThePostRequestWithNewEmployee() {
        response = request.post(ENDPOINT);
    }

    @Then("I create new employee")
    public void iCreateNewEmployee() {
        Employee emp = response.getBody().as(Employee.class);
        userId = emp.getId();
    }

    @And("I get {int} Status code")
    public void iGetStatusCode(Integer code) {
        assertThat(response.getStatusCode()).isEqualTo(code);
    }

    @Then("response contains employee's id")
    public void responseContainsEmployeeId() {

        assertThat(userId).isNotZero().isPositive();
    }

    @Given("I want to execute get employee by id endpoint")
    public void iWantToExecuteGetEmployeeByIdEndpoint() {
        RestAssured.baseURI = URL;
        request = RestAssured.given();
    }

    @When("I submit the {word} request with employee's id")
    public void iSubmitTheGETRequestWithEmployeeSId(String req) {
        String endpoint = String.format("%s/%s",ENDPOINT, userId);
        if ("GET".equals(req)) response = request.get(endpoint);
        else if ("PUT".equals(req)) response = request
                .contentType(ContentType.JSON)
                .body("{\n" +
                        "\"id\": \"" + userId + "\",\n" +
                        "\"firstName\": \"New\",\n" +
                        "\"lastName\": \"User\",\n" +
                        "\"emailId\": \"test3@gmail.com\"\n" +
                        "}")
                .put(endpoint);
        else if ("DELETE".equals(req)) response = request.delete(endpoint);
    }

    @Given("I want to execute get employee list endpoint")
    public void iWantToExecuteGetEmployeeListEndpoint() {
        RestAssured.baseURI = URL;
        request = RestAssured.given();
    }

    @When("I submit the GET request without parameters")
    public void iSubmitTheGETRequestWithoutParameters() {
        response = request.get(ENDPOINT);
    }

    @And("response contains employee list")
    public void responseContainsEmployeeList() {
        assertThat(response.getBody().as(Employee[].class).length).isNotZero().isPositive();
    }

    @Given("I want to execute update employee endpoint")
    public void iWantToExecuteUpdateEmployeeEndpoint() {
        RestAssured.baseURI = URL;
        request = RestAssured.given();
    }

    @When("I submit the PUT request with new employee data")
    public void iSubmitThePUTRequestWithNewEmployeeData() {
        response = request.put(ENDPOINT);
    }

    @And("response contains updated employee")
    public void responseContainsUpdatedEmployee() {
        Employee emp = response.getBody().as(Employee.class);
        assertThat(emp.getId()).isNotZero().isEqualTo(userId);
        assertThat(emp.getFirstName()).isNotBlank().isEqualTo("New");
        assertThat(emp.getLastName()).isNotBlank().isEqualTo("User");
    }

    @Given("I want to execute delete employee endpoint")
    public void iWantToExecuteDeleteEmployeeEndpoint() {
        RestAssured.baseURI = URL;
        request = RestAssured.given();
    }

    @When("^I submit the (.+) request with non-existing employee's id$")
    public void iSubmitTheRequestRequestWithNonExistingEmployeeId(String req) {
        String endpoint = String.format("%s/%s",ENDPOINT, userId);
        if ("GET".equals(req)) response = request.get(endpoint);
        else if ("PUT".equals(req)) response = request
                .contentType(ContentType.JSON)
                .body("{\n" +
                        "\"id\": \"" + userId + "\",\n" +
                        "\"firstName\": \"New\",\n" +
                        "\"lastName\": \"User\",\n" +
                        "\"emailId\": \"test3@gmail.com\"\n" +
                        "}")
                .put(endpoint);
        else if ("DELETE".equals(req)) response = request.delete(endpoint);
    }

}
