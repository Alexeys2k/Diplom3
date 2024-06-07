import io.qameta.allure.junit4.DisplayName;
import object.PageSignIn;
import org.junit.Test;
import static com.codeborne.selenide.Selenide.open;

public class ReloginAccTest extends StartStopTest {
    @Test
    @DisplayName(" выход по кнопке «Выйти» в личном кабинете.")
    public void logoutUserProfileButtonTest(){
        open(PageSignIn.URL_SIGN_IN_PAGE, PageSignIn.class)
                .setEmail(API_USER.getEmail())
                .setPassword(API_USER.getPassword())
                .clickSignInButton()
                .clickAccountButtonWithAuth()
                .clickLogOutButton()
                .isEnterButtonExist();
    }
}