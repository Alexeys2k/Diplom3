package object;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import static com.codeborne.selenide.Selenide.page;

public class PageProfile {

    @FindBy(how = How.XPATH, using = "//a[text()='Профиль']")
    private SelenideElement userProfileButton;

    @FindBy(how = How.XPATH, using = "//p[text()='Конструктор']")
    private SelenideElement constructorButton;

    @FindBy(how = How.XPATH, using = "//div[@class='AppHeader_header__logo__2D0X2']")
    private SelenideElement logoPicture;

    @FindBy(how = How.XPATH, using = "//button[text()='Выход']")
    private SelenideElement logoutButton;


    @Step("Кликнуть на кнопку Выход")
    public PageSignIn clickLogOutButton() {
        logoutButton.click();
        return Selenide.page(PageSignIn.class);
    }

    @Step("Проверка что заголовок Профиль существует")
    public boolean isUserProfileHeaderExist() {
        userProfileButton.shouldBe(Condition.visible);
        return userProfileButton.exists();
    }

    @Step("Клик по кнопке конструктора")
    public PageMain clickConstructorButton() {
        constructorButton.click();
        return Selenide.page(PageMain.class);
    }

    @Step("Клик по Лого")
    public PageMain clickLogoPicture() {
        logoPicture.click();
        return Selenide.page(PageMain.class);
    }
}
