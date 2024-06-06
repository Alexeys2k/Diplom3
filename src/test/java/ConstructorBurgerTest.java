import io.qameta.allure.junit4.DisplayName;
import object.PageMain;
import org.junit.Test;
import static com.codeborne.selenide.Selenide.open;

public class ConstructorBurgerTest extends StartStopTest {


    @Test
    @DisplayName("Переход к разделу Булки")
    public void clickBunsSectionButtonTest() {
        open(PageMain.MAIN_PAGE_URL, PageMain.class)
                .clickSaucesButton()
                .clickBunsButton()
                .isBunsHeaderIsDisplayed();
    }

    @Test
    @DisplayName("Переход к разделу Соусы")
    public void clickSaucesSectionButtonTest() {
        open(PageMain.MAIN_PAGE_URL, PageMain.class)
                .clickSaucesButton()
                .isSaucesHeaderIsDisplayed();
    }

    @Test
    @DisplayName("Переход к разделу Начинки")
    public void clickFillingsSectionButtonTest() {
        open(PageMain.MAIN_PAGE_URL, PageMain.class)
                .clickFillingsButton()
                .isFillingsHeaderIsDisplayed();
    }

}