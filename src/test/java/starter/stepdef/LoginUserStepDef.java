package starter.stepdef;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.reqres.ReqresAPI;
import starter.utils.Constants;

import java.io.File;

public class LoginUserStepDef {

    @Steps
    ReqresAPI reqresAPI;

//    Scenario 23, 24, 25, 26, 27, 28
    @Given("Login user with json {string}")
    public void loginUserWithJson(String json) {
        File jsonLoginUser = new File(Constants.REQ_BODY + json);
        reqresAPI.loginUser(jsonLoginUser);
    }

    @When("Send request post to login user")
    public void sendRequestPostToLoginUser() {
        SerenityRest.when().post(ReqresAPI.POST_LOGIN_USER);
    }
}
