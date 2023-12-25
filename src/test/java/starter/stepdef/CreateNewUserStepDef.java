package starter.stepdef;

import io.cucumber.java.en.Given;
import net.thucydides.core.annotations.Steps;
import starter.reqres.ReqresAPI;
import starter.utils.Constants;

import java.io.File;

public class CreateNewUserStepDef {

    @Steps
    ReqresAPI reqresAPI;

//    Scenario 10 & 11
    @Given("Post create user with json {string}")
    public void postCreateUserWithJson(String json) {
        File jsonCreateUser = new File(Constants.REQ_BODY+json);
        reqresAPI.postCreateUser(jsonCreateUser);
    }
}
