Feature: Employee API testing
  As developer I want have possibility
  To do CRUD operation with employee DB Using API

  Scenario: Add new employee
    Given I want to execute create employee endpoint
    When I submit the POST request with new employee
    Then I get 200 Status code
    And response contains employee's id

  Scenario: Get employee by his id
    Given I want to execute get employee by id endpoint
    When I submit the GET request with employee's id
    Then I get 200 Status code
    And response contains employee's id

  Scenario: Get employee list
    Given I want to execute get employee list endpoint
    When I submit the GET request
    Then I get 200 Status code
    And response contains employee list

  Scenario: Update employee by id
    Given I want to execute update employee endpoint
    When I submit the PUT request with new employee data
    Then I get 200 Status code
    And response contains updated employee

  Scenario: Delete employee by id
    Given I want to execute delete employee endpoint
    When I submit the DELETE request with employee id
    Then I get 200 Status code

  Scenario: Get non-existing employee by id
    Given I want to execute get employee by id endpoint
    When I submit the GET request with non-existing employee id
    Then I get 404 Status code