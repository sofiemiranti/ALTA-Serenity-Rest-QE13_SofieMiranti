package starter.stepdef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.module.jsv.JsonSchemaValidator;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.reqres.ReqresAPI;
import starter.reqres.ReqresResponses;
import starter.utils.Constants;

import java.io.File;

import static org.hamcrest.Matchers.equalTo;

public class ReqresStepDef {

    @Steps
    ReqresAPI reqresAPI;

//    Scenario 1
    @Given("Get list users with page parameter {int}")
    public void getListUsersWithPageParameter(int page) {
        reqresAPI.getListUsersWithPageParam(page);
    }

    @When("Send request get list users with page parameter")
    public void sendRequestGetListUsersWithPageParameter() {
        SerenityRest.when().get(ReqresAPI.GET_LIST_USERS_WITH_PAGE_PARAM);
    }

    @And("Response body page should be {int}")
    public void responseBodyPageShouldBe(int page) {
        SerenityRest.and().body(ReqresResponses.PAGE, equalTo(page));
    }

//    Scenario 2
    @Given("Post create user with valid json {string}")
    public void postCreateUserWithValidJsonCreateUserJson(String json) {
        File jsonCreateUser = new File(Constants.REQ_BODY + json);
        reqresAPI.postCreateUser(jsonCreateUser);
    }

    @When("Send request post create user")
    public void sendRequestPostCreateUser() {
        SerenityRest.when().post(ReqresAPI.POST_CREATE_USER);
    }


//    Scenario 3
    @Given("Update user with valid id {int} and json {string}")
    public void updateUserWithValidIdAndJson(int id, String json) {
        File jsonUpdateUser = new File(Constants.REQ_BODY + json);
        reqresAPI.updateUser(id, jsonUpdateUser);
    }

    @When("Send request update user")
    public void sendRequestUpdateUser() {
        SerenityRest.when().put(ReqresAPI.UPDATE_USER);
    }

//    Scenario 4
    @Given("Delete user with valid id {int}")
    public void deleteUserWithValidIdInt(int id) {
        reqresAPI.deleteUser(id);
    }

    @When("Send request delete user")
    public void sendRequestDeleteUser() {
        SerenityRest.when().delete(ReqresAPI.DELETE_USER);
    }

    @And("Response body name was {string} and job was {string}")
    public void responseBodyNameWasAndJobWas(String name, String job) {
        SerenityRest.and()
                .body(ReqresResponses.NAME, equalTo(name))
                .body(ReqresResponses.JOB, equalTo(job));
    }

//    All Scenarios
    @Then("Status code should be {int}")
    public void statusCodeShouldBe(int statusCode) {
        SerenityRest.then().statusCode(statusCode);
    }

    @And("Validate json schema {string}")
    public void validateGetListUsersJsonSchema(String json) {
        File jsonSchema = new File(Constants.JSON_SCHEMA+json);
        SerenityRest.and()
                .assertThat()
                .body(JsonSchemaValidator.matchesJsonSchema(jsonSchema));
    }
}
