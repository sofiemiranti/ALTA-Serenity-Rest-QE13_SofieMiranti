package starter.reqres;

import io.restassured.http.ContentType;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import starter.utils.Constants;

import java.io.File;

public class ReqresAPI {
    public static String GET_LIST_USERS_WITHOUT_PARAM = Constants.BASE_URL + "/api/users";
    public static String GET_LIST_USERS_WITH_PAGE_PARAM = Constants.BASE_URL + "/api/users?page={page}";
    public static String GET_LIST_USERS_WITH_PAGE_AND_PER_PAGE_PARAM = Constants.BASE_URL + "/api/users?page={page}&per_page={per_page}";
    public static String GET_LIST_USERS_INVALID_PARAM = Constants.BASE_URL + "/api/users?pagezzzzz=xx";
    public static String POST_CREATE_USER = Constants.BASE_URL + "/api/users";
    public static String UPDATE_USER = Constants.BASE_URL + "/api/users/{id}";
    public static String DELETE_USER = Constants.BASE_URL + "/api/users/{id}";
    public static String GET_SINGLE_USER = Constants.BASE_URL + "/api/users/{id}";
    public static String GET_LIST_RESOURCE = Constants.BASE_URL + "/api/unknown";
    public static String GET_SINGLE_RESOURCE = Constants.BASE_URL + "/api/unknown/{id}";
    public static String POST_REGISTER_USER = Constants.BASE_URL + "/api/register";
    public static String POST_LOGIN_USER = Constants.BASE_URL + "/api/login";

    @Step ("Get list users with page parameter")
    public void getListUsersWithPageParam (int page) {
        SerenityRest.given()
                .pathParam("page", page);
    }

    @Step("Get list users with page and per page parameter")
    public void getListUsersWithPageAndPerPageParam (int page, int per_page) {
        SerenityRest.given()
                .pathParam("page", page)
                .pathParam("per_page", per_page);
    }

    @Step("Post create new user")
    public void postCreateUser (File json) {
        SerenityRest.given()
                .contentType(ContentType.JSON).body(json);
    }

    @Step("Update user")
    public void updateUser (int id, File json){
        SerenityRest.given()
                .pathParam("id", id)
                .contentType(ContentType.JSON).body(json);
    }

    @Step("Delete user")
    public void deleteUser (int id) {
        SerenityRest.given()
                .pathParam("id", id);
    }

    @Step("Get single user")
    public void singleUser (int id) {
        SerenityRest.given()
                .pathParam("id", id);
    }

    @Step("Get single resource")
    public void singleResource (int id) {
        SerenityRest.given()
                .pathParam("id", id);
    }

    @Step("Modify user")
    public void modifyUser (int id, File json) {
        SerenityRest.given()
                .pathParam("id", id)
                .contentType(ContentType.JSON).body(json);
    }

    @Step("Register user")
    public void registerUser (File json) {
        SerenityRest.given()
                .contentType(ContentType.JSON).body(json);
    }

    @Step("Login user")
    public void loginUser (File json) {
        SerenityRest.given()
                .contentType(ContentType.JSON).body(json);
    }
}
