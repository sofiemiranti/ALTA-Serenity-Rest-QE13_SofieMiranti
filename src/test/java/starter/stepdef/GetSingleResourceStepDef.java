package starter.stepdef;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.reqres.ReqresAPI;

public class GetSingleResourceStepDef {

    @Steps
    ReqresAPI reqresAPI;

//    Scenario 13 & 14
    @Given("Get single resource with {int}")
    public void getSingleResourceWith(int id) {
        reqresAPI.singleResource(id);
    }

    @When("Send request get single resource")
    public void sendRequestGetSingleResource() {
        SerenityRest.when().get(ReqresAPI.GET_SINGLE_RESOURCE);
    }
}
