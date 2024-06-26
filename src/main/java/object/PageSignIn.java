package object;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import api.User;
import org.junit.Assert;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import static com.codeborne.selenide.Selenide.page;


public class PageSignIn {

    public final static String URL_SIGN_IN_PAGE = "https://stellarburgers.nomoreparties.site/login";

    //Текст Вход на странице авторизации
    @FindBy(how = How.XPATH, using = "//h2[text()='Вход']")
    private SelenideElement enterButton;

    @FindBy(how = How.XPATH, using = "//button[text()='Войти']")
    private SelenideElement signInButton;

    @FindBy(how = How.XPATH, using = "//a[contains(text(),'Зарегистрироваться')]")
    private SelenideElement signUpButton;

    //Поле Email
    @FindBy(how = How.XPATH, using = "//label[text()='Email']//following-sibling::input")
    private SelenideElement emailField;

    //Поле Пароль
    @FindBy(how = How.XPATH, using = "//label[text()='Пароль']//following-sibling::input")
    private SelenideElement passwordField;

    @FindBy(how = How.XPATH, using = "//p[text()='Некорректный пароль']")
    private SelenideElement errorMessage;

    @FindBy(how = How.XPATH, using = "//div/p/a[text()='Войти']")
    private SelenideElement enterLinkButton;

    @Step("Клик по кнопке Зарегистрироваться")
    public PageSignUp clickSignUpButton() {
        signUpButton.click();
        return page(PageSignUp.class);
    }

    @Step("Ввод email")
    public PageSignIn setEmail(String email) {
        emailField.click();
        emailField.val(email);
        return this;
    }

    @Step("Ввод пароля")
    public PageSignIn setPassword(String password) {
        passwordField.click();
        passwordField.val(password);
        return this;
    }

    @Step("Клик по кнопке Войти на странице логина")
    public PageMain clickSignInButton() {
        signInButton.shouldBe(Condition.enabled).click();
        return page(PageMain.class);
    }

    @Step("Ввести данные пользователя")
    public PageMain signInUser(User user) {
        setEmail(user.getEmail());
        setPassword(user.getPassword());
        return clickSignInButton();
    }

    @Step("Ввести данные пользователя")
    public PageMain signUpUser(String email, String password) {
        emailField.shouldBe(Condition.visible);
        passwordField.shouldBe(Condition.visible);
        setEmail(email);
        setPassword(password);
        return clickSignInButton();
    }

    @Step("Проверить что кнопка Войти есть на странице")
    public boolean isEnterButtonExist() {
        enterButton.shouldBe(Condition.visible);
        return enterButton.exists();
    }

    @Step("Проверка отображения текста с ошибкой")
    public PageSignIn errorMessageGetText() {
        Assert.assertEquals("Некорректный пароль",
                errorMessage.shouldBe(Condition.visible)
                        .getText());
        return this;
    }

    public PageSignIn clickEnterLinkButton() {
        enterLinkButton.click();
        return page(PageSignIn.class);
    }
}