import api.ApiClient;
import api.ApiUser;
import api.ApiGeneratorUser;
import api.Credentials;
import api.User;
import com.codeborne.selenide.Selenide;
import io.qameta.allure.Step;
import io.restassured.response.Response;
import webmanager.BrowserSelect;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;


public class StartStopTest {
    public static final User API_USER = ApiGeneratorUser.getUser();
    public ApiUser apiUser;

    @Before
    @Step("Открыть страницу")
    public void setUp() {
        //Указать chrome or yandex
        BrowserSelect.setDriver("yandex");
        apiUser = new ApiUser();
        apiUser.createUser(API_USER);

    }

    @After
    @Step("Закрыть браузер")
    public void cleanUp() {
        Credentials credentials = new Credentials(API_USER.getEmail(), API_USER.getPassword());
        Response response = apiUser.login(credentials);
        if (response.body().jsonPath().getString("accessToken") != null) {
            apiUser.delete(response);
        }
        Selenide.closeWindow();
    }
}