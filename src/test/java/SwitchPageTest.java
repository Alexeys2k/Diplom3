import io.qameta.allure.junit4.DisplayName;
import object.PageSignIn;
import org.junit.Test;
import static com.codeborne.selenide.Selenide.open;

public class SwitchPageTest extends StartStopTest {
    @Test
    @DisplayName("переход по клику на «Конструктор»")
    public void openForConstructorTest() {
        open(PageSignIn.URL_SIGN_IN_PAGE, PageSignIn.class)
                .signInUser(API_USER)
                .clickAccountButtonWithAuth()
                .clickConstructorButton()
                .isConstructorHeader();
    }

    @Test
    @DisplayName("переход по клику на логотип Stellar Burgers")
    public void openForLogoTest() {
        open(PageSignIn.URL_SIGN_IN_PAGE, PageSignIn.class)
                .signInUser(API_USER)
                .clickAccountButtonWithAuth()
                .clickLogoPicture()
                .isConstructorHeader();
    }

    @Test
    @DisplayName("переход по клику на «Личный кабинет».")
    public void clickProfileButtonTest() {
        open(PageSignIn.URL_SIGN_IN_PAGE, PageSignIn.class)
                .signInUser(API_USER)
                .clickAccountButtonWithAuth()
                .isUserProfileHeaderExist();
    }
}