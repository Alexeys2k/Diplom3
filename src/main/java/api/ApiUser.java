package api;
import io.qameta.allure.Step;
import io.restassured.response.Response;
import static io.restassured.RestAssured.given;

public class ApiUser extends ApiClient {

    private static final String REGISTER = "auth/register/";
    private static final String LOGIN = "auth/login/";
    private static final String DELETE = "auth/user/";

    @Step("Регистрация нового пользователя")
    public Response createUser(User user) {
        return (Response) given()
                .spec(getSpecSettings())
                .body(user)
                .when()
                .post(REGISTER)
                .then()
                .extract();
    }

    @Step("Логин пользователя")
    public static Response login(Credentials credentials) {
        return (Response) given()
                .spec(getSpecSettings())
                .body(credentials)
                .when()
                .post(LOGIN)
                .then()
                .extract();
    }

    @Step("Удаление пользователя")
    public void delete(Response response) {
        String accessToken = response.body().jsonPath().getString("accessToken");
        if (accessToken == null) {
            return;
        }
        given()
                .spec(getSpecSettings())
                .header("authorization", accessToken)
                .when()
                .delete(DELETE);
    }
}