package starter.stepdef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.reqres.ReqresAPI;
import starter.reqres.ReqresResponses;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasSize;

public class GetListUsersStepDef {

    @Steps
    ReqresAPI reqresAPI;

//    Scenario 5
    @Given("Get list users without parameter")
    public void getListUsersWithoutParameter() {
    }

    @When("Send request get list users without parameter")
    public void sendRequestGetListUsersWithoutParameter() {
        SerenityRest.when().get(ReqresAPI.GET_LIST_USERS_WITHOUT_PARAM);
    }

//    Scenario 6
    @Given("Get list users with invalid parameter")
    public void getListUsersWithInvalidParameter() {
    }

    @When("Send request get list users with invalid parameter")
    public void sendRequestGetListUsersWithInvalidParameter() {
        SerenityRest.when().get(ReqresAPI.GET_LIST_USERS_INVALID_PARAM);
    }

//    Scenario 7
    @Given("Get list users with page parameter {int} and per page parameter {int}")
    public void getListUsersWithPerPageParameter(int page, int per_page) {
        reqresAPI.getListUsersWithPageAndPerPageParam(page, per_page);
    }

    @When("Send request get list users with page and per page parameter")
    public void sendRequestGetListUsersWithPageAndPerPageParameter() {
        SerenityRest.when().get(ReqresAPI.GET_LIST_USERS_WITH_PAGE_AND_PER_PAGE_PARAM);
    }

    @And("Response body page was {int} and per page was {int}")
    public void responseBodyPageWasAndPerPageWas(int page, int per_page) {
        SerenityRest.and()
                .body(ReqresResponses.PAGE , equalTo(page))
                .body(ReqresResponses.PER_PAGE , equalTo(per_page));
    }

    @And("Response body data has amount was {int}")
    public void responseBodyDataHasAmountWas(int per_page) {
        SerenityRest.and().body(ReqresResponses.DATA, hasSize(per_page));
    }
}
