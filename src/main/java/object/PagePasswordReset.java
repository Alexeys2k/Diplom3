package object;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.support.FindBy;

import static com.codeborne.selenide.Selenide.page;

public class PagePasswordReset {

    public final static String PASSWORD_RESET_PAGE_URL = "https://stellarburgers.nomoreparties.site/forgot-password";

    @FindBy(xpath = "//a[text()='Войти']")
    private SelenideElement linkResetPasswordToLoginForm;

    @Step("Клик - Войти на странице восстановления пароля")
    public PageSignIn clickResetPasswordButton() {
        linkResetPasswordToLoginForm.click();
        return page(PageSignIn.class);
    }
}