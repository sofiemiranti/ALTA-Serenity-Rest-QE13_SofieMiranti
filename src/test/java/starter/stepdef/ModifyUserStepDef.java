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

public class ModifyUserStepDef {

    @Steps
    ReqresAPI reqresAPI;

//    Scenario 15
    @Given("Modify user with id {int} and valid json {string}")
    public void modifyJobUserWithValidJson(int id, String json) {
        File jsonModifyUser = new File(Constants.REQ_BODY + json);
        reqresAPI.modifyUser(id,jsonModifyUser);
    }

    @When("Send request patch to modify")
    public void sendRequestPatchToModify() {
        SerenityRest.when().patch(ReqresAPI.UPDATE_USER);
    }

    @And("Response body job was {string}")
    public void responseBodyJobWas(String editJob) {
        SerenityRest.and().body(ReqresResponses.JOB, equalTo(editJob));
    }

//    Scenario 16
    @And("Response body name was {string}")
    public void responseBodyNameWas(String editName) {
        SerenityRest.and().body(ReqresResponses.NAME, equalTo(editName));
    }
}
