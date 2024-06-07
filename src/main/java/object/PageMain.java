package object;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import static com.codeborne.selenide.Selenide.page;

public class PageMain {
    public static String MAIN_PAGE_URL = "https://stellarburgers.nomoreparties.site/";

    //Локаторы
    //Войти в аккаунт
    @FindBy(how = How.XPATH, using = "//button[text()='Войти в аккаунт']") //
    private SelenideElement tapAccountButton;
    //Оформить Заказ
    @FindBy(how = How.XPATH, using = "//button[contains(text(),'Оформить заказ')]") //
    private SelenideElement createOrderButton;

    //Личный кабинет
    @FindBy(how = How.XPATH, using = "//p[text()='Личный Кабинет']") //
    private SelenideElement accountButton;;

    //"Соберите бургер"
    @FindBy(how = How.XPATH, using = "//h1[text()='Соберите бургер']")
    private SelenideElement constructorBurger;

    //"Булки"
    @FindBy(how = How.XPATH, using = "//div[span[text()='Булки']]")
    private SelenideElement bunsButton;

    //"Соусы"
    @FindBy(how = How.XPATH, using = "//div[span[text()='Соусы']]")
    private SelenideElement sauceButton;

    //"Начинки"
    @FindBy(how = How.XPATH, using = "//*[text()='Начинки']")
    private SelenideElement fillingsButton;

    //"Заголовки"
    @FindBy(how = How.XPATH, using = "//h2[text()='Булки']")
    private SelenideElement bunsHeader;
    //"Соусы"
    @FindBy(how = How.XPATH, using = "//h2[text()='Соусы']")
    private SelenideElement sauceHeader;
    //"Начинки"
    @FindBy(how = How.XPATH, using = "//h2[text()='Начинки']")
    private SelenideElement fillingsHeader;

    //выбора раздела
    @FindBy(how = How.CLASS_NAME, using = "tab_tab_type_current__2BEPc")
    private SelenideElement sectionIngredients;

    @FindBy(how = How.XPATH, using = "//div[@class='BurgerIngredients_ingredients__menuContainer__Xu3Mo']")
    private SelenideElement constructorContainer;

    @FindBy(how = How.XPATH, using = "//p[text()='Некорректный пароль']")
    private SelenideElement errorMessage;

    @Step("Клик - Войти в аккаунт")
    public PageSignIn clickAccountButton() {
        tapAccountButton.click();
        return Selenide.page(PageSignIn.class);
    }

    @Step("Оформить заказ")
    public boolean orderButtonExist() {
        createOrderButton.shouldBe(Condition.visible);
        return createOrderButton.exists();
    }

    @Step("Клик - Личный кабинет без авторизации")
    public PageSignIn clickAccountButtonNoAuth() {
        accountButton.click();
        return Selenide.page(PageSignIn.class);
    }

    @Step("Клик - Личный кабинет с авторизацией")
    public PageProfile clickAccountButtonWithAuth() {
        accountButton.click();
        return page(PageProfile.class);
    }

    @Step("Проверка - Конструктор")
    public boolean isConstructorHeader() {
        return constructorBurger.exists();
    }

    @Step("Клик - Булки в конструкторе")
    public PageMain clickBunsButton() {
        bunsButton.click();
        return this;
    }

    @Step("Клик - Соусы в конструкторе")
    public PageMain clickSaucesButton() {
        sauceButton.click();
        return this;
    }

    @Step("Клик - Начинки в конструкторе")
    public PageMain clickFillingsButton() {
        fillingsButton.click();
        return this;
    }

    @Step("Проверка - Булки")
    public boolean isBunsHeaderIsDisplayed() {
        return sectionIngredients.getText().contentEquals("Булки");
    }

    @Step("Проверка - Соусы")
    public boolean isSaucesHeaderIsDisplayed() {
        return sectionIngredients.getText().contentEquals("Соусы");
    }

    @Step("Проверка - Начинки")
    public boolean isFillingsHeaderIsDisplayed() {
        return sectionIngredients.getText().contentEquals("Начинки");
    }

    @Step("Проверка - Сообщения об ошибке")
    public boolean isErrorMessageExist() {
        return errorMessage.exists();
    }
}