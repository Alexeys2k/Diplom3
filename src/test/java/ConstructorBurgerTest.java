import io.qameta.allure.junit4.DisplayName;
import object.PageMain;
import org.junit.Test;
import static com.codeborne.selenide.Selenide.open;

public class ConstructorBurgerTest extends StartStopTest {


    @Test
    @DisplayName("Скрол к разделу Булки")
    public void scrollBunsSectionTest() {
        open(PageMain.MAIN_PAGE_URL, PageMain.class)
                .scrollToBunsHeader()
                .isBunsHeaderIsDisplayed();
    }

    @Test
    @DisplayName("Скрол к разделу Соусы")
    public void scrollSaucesSectionTest() {
        open(PageMain.MAIN_PAGE_URL, PageMain.class)
                .scrollToSaucesHeader()
                .isSaucesHeaderIsDisplayed();
    }

    @Test
    @DisplayName("Скрол к разделу Начинки")
    public void scrollFillingsSectionTest() {
        open(PageMain.MAIN_PAGE_URL, PageMain.class)
                .scrollToFillingsHeader()
                .isFillingsHeaderIsDisplayed();
    }
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