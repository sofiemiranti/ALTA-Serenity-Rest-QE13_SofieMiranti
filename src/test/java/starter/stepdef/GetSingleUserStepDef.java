package starter.stepdef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.reqres.ReqresAPI;
import starter.reqres.ReqresResponses;

import static org.hamcrest.Matchers.equalTo;


public class GetSingleUserStepDef {

    @Steps
    ReqresAPI reqresAPI;

//    Scenario 8
    @Given("Get single user with user id {int}")
    public void getSingleUserWithUserId(int id) {
        reqresAPI.singleUser(id);
    }

    @When("Send request get single user")
    public void sendRequestGetSingleUser() {
        SerenityRest.when().get(ReqresAPI.GET_SINGLE_USER);
    }

    @And("Response body data id was {int}")
    public void responseBodyDataIdWas(int id) {
        SerenityRest.and().body(ReqresResponses.ID, equalTo(id));
    }

//    Scenario 9
    @Given("Get unregistered user with user id {int}")
    public void getUnregisteredUserWithUserId(int id) {
        reqresAPI.singleUser(id);
    }

    @When("Send request get unregistered user")
    public void sendRequestGetUnregisteredUser() {
        SerenityRest.when().get(ReqresAPI.GET_SINGLE_USER);
    }
}
