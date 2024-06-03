import api.ApiUser;
import api.ApiGeneratorUser;
import api.Credentials;
import com.codeborne.selenide.WebDriverRunner;
import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import io.restassured.response.Response;
import object.PageMain;
import org.junit.After;
import org.junit.Test;
import webmanager.ValueForTest;
import static com.codeborne.selenide.Selenide.open;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class RegistrationTest {

    private ApiUser apiUser;

    protected String name = ApiGeneratorUser.getUser().getName();
    protected String email = ApiGeneratorUser.getUser().getEmail();
    protected String password = ApiGeneratorUser.getUser().getPassword();

    @Test
    @DisplayName("Регистрация - успешная")
    @Description("Успешная регистрация пользователя")
    public void checkSuccessRegistrationAccount() {
        open(PageMain.MAIN_PAGE_URL, PageMain.class)
                .clickAccountButton()
                .clickSignUpButton()
                .setName(name)
                .setEmail(email)
                .setPassword(password)
                .clickConfirmSignUpButton()
                .signUpUser(email, password);


        String currentUrl = WebDriverRunner.getWebDriver().getCurrentUrl();

        assertEquals("https://stellarburgers.nomoreparties.site/login", currentUrl);
    }

    @Test
    @DisplayName("Регистрация - некорректная")
    @Description("Ошибку для некорректного пароля. Минимальный пароль — шесть символов.")
    public void checkErrorRegistrationAccount() {
        boolean inValidDataRegister = open(PageMain.MAIN_PAGE_URL, PageMain.class)
                .clickAccountButton()
                .clickSignUpButton()
                .setName(name)
                .setEmail(email)
                .setPassword(ValueForTest.PASSWORD_ERROR)
                .clickConfirmSignUpButton()
                .errorMessageGetText()
                .clickEnterLinkButton()
                .signUpUser(email, ValueForTest.PASSWORD_ERROR)
                .isErrorMessageExist();
        assertTrue(inValidDataRegister);
    }

    @After
    public void tearDown() {
        apiUser = new ApiUser();
        Credentials credentials = new Credentials(email, password);
        Response response = apiUser.login(credentials);
        if (response.body().jsonPath().getString("accessToken") != null) {
            apiUser.delete(response);
        }

        Credentials userInValidCredentials = new Credentials(email, ValueForTest.PASSWORD_ERROR);
        Response inValidResponse = apiUser.login(userInValidCredentials);
        if (inValidResponse.body().jsonPath().getString("accessToken") != null) {
            apiUser.delete(inValidResponse);
        }
    }
}