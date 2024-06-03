package object;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import static com.codeborne.selenide.Selenide.page;


public class PageSignUp {

    public final static String SIGN_UP_PAGE_URL = "https://stellarburgers.nomoreparties.site/register";

    @FindBy(how = How.XPATH, using = "//label[text()='Имя']/following-sibling::input")
    private SelenideElement nameField;

    @FindBy(how = How.XPATH, using = "//*[text()='Email']/following-sibling::input")
    private SelenideElement emailField;

    @FindBy(how = How.XPATH, using = "//*[text()='Пароль']/following-sibling::input")
    private SelenideElement passwordField;

    @FindBy(how = How.XPATH, using = "//button[text()='Зарегистрироваться']")
    private SelenideElement confirmSignUpButton;

    @FindBy(how = How.XPATH, using = "//a[text()='Войти']")
    private SelenideElement signUpPageEnterButton;

    @Step("Ввод имени")
    public PageSignUp setName(String name) {
        nameField.setValue(name);
        return this;
    }

    @Step("Ввод Email")
    public PageSignUp setEmail(String email) {
        emailField.setValue(email);
        return this;
    }

    @Step("Ввод пароля")
    public PageSignUp setPassword(String password) {
        passwordField.setValue(password);
        return this;
    }

    @Step("Клик по кнопке Зарегистрироваться и переход на страницу Регистрации")
    public PageSignIn clickConfirmSignUpButton() {
        confirmSignUpButton.click();
        return Selenide.page(PageSignIn.class);
    }

    @Step("Клик по кнопке Войти")
    public PageSignIn clickSignUpPageEnterButton() {
        signUpPageEnterButton.click();
        return Selenide.page(PageSignIn.class);
    }
}