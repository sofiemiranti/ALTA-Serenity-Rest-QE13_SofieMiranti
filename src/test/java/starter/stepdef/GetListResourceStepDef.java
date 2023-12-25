package starter.stepdef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.reqres.ReqresAPI;
import starter.reqres.ReqresResponses;

import static org.hamcrest.Matchers.equalTo;

public class GetListResourceStepDef {

    @Steps
    ReqresAPI reqresAPI;

//    Scenario 12
    @Given("Get list resource")
    public void getListResource() {
    }

    @When("Send request get list resource")
    public void sendRequestGetListResource() {
        SerenityRest.when().get(ReqresAPI.GET_LIST_RESOURCE);
    }

    @And("Response body page was {int}, per page was {int}, total was {int}, and total page was {int}")
    public void responseBodyPageWasPer_pageWasTotalWasAndTotalPageWas(int page, int per_page, int total, int total_page) {
        SerenityRest.and()
                .body(ReqresResponses.PAGE, equalTo(page))
                .body(ReqresResponses.PER_PAGE, equalTo(per_page))
                .body(ReqresResponses.TOTAL, equalTo(total))
                .body(ReqresResponses.TOTAL_PAGES, equalTo(total_page));
    }
}
