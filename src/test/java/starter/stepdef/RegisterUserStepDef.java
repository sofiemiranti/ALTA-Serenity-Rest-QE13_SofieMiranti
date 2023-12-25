package starter.stepdef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.reqres.ReqresAPI;
import starter.reqres.ReqresResponses;
import starter.utils.Constants;

import java.io.File;

import static org.hamcrest.Matchers.equalTo;

public class RegisterUserStepDef {

    @Steps
    ReqresAPI reqresAPI;

//    Scenario 17, 18, 19, 20, 21, 22
    @Given("Post register user with json {string}")
    public void postRegisterUserWithJson(String json) {
        File jsonRegisterUser = new File(Constants.REQ_BODY + json);
        reqresAPI.registerUser(jsonRegisterUser);
    }

    @When("Send request post register user")
    public void sendRequestPostRegisterUser() {
        SerenityRest.when().post(ReqresAPI.POST_REGISTER_USER);
    }

//    Scenario 18, 19, 20, 22
    @And("Response body error was {string}")
    public void responseBodyErrorWas(String error) {
        SerenityRest.and().body(ReqresResponses.ERROR, equalTo(error));
    }
}
