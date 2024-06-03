import io.qameta.allure.junit4.DisplayName;
import object.PageMain;
import object.PagePasswordReset;
import object.PageSignUp;
import org.junit.Test;

import static com.codeborne.selenide.Selenide.open;

public class LoginWebTest extends StartStopTest {

    @Test
    @DisplayName("вход по кнопке «Войти в аккаунт» на главной")
    public void signInButtonStartPageTest() {
        open(PageMain.MAIN_PAGE_URL, PageMain.class)
                .clickAccountButton()
                .setEmail(API_USER.getEmail())
                .setPassword(API_USER.getPassword())
                .clickSignInButton()
                .orderButtonExist();
    }

    @Test
    @DisplayName("вход через кнопку «Личный кабинет»")
    public void signInButtonProfileTest() {

        open(PageMain.MAIN_PAGE_URL, PageMain.class)
                .clickAccountButtonNoAuth()
                .setEmail(API_USER.getEmail())
                .setPassword(API_USER.getPassword())
                .clickSignInButton()
                .orderButtonExist();
    }

    @Test
    @DisplayName("вход через кнопку в форме регистрации")
    public void signInButtonSignUpTest() {

        open(PageSignUp.SIGN_UP_PAGE_URL, PageSignUp.class)
                .clickSignUpPageEnterButton()
                .setEmail(API_USER.getEmail())
                .setPassword(API_USER.getPassword())
                .clickSignInButton()
                .orderButtonExist();
    }

    @Test
    @DisplayName("вход через кнопку в форме восстановления пароля")
    public void signInButtonPasswordResetTest() {
        open(PagePasswordReset.PASSWORD_RESET_PAGE_URL, PagePasswordReset.class)
                .clickResetPasswordButton()
                .setEmail(API_USER.getEmail())
                .setPassword(API_USER.getPassword())
                .clickSignInButton()
                .orderButtonExist();
    }
}