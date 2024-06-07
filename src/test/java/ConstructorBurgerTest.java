import io.qameta.allure.junit4.DisplayName;
import object.PageMain;
import org.junit.Test;
import static com.codeborne.selenide.Selenide.open;
import static org.junit.Assert.assertTrue;

public class ConstructorBurgerTest extends StartStopTest {

    @Test
    @DisplayName("Переход к разделу Булки")
    public void clickBunsSectionButtonTest() {
        PageMain page = open(PageMain.MAIN_PAGE_URL, PageMain.class)
                .clickSaucesButton()
                .clickBunsButton();
        assertTrue("Заголовок раздела 'Булки' не отображается", page.isBunsHeaderIsDisplayed());
    }

    @Test
    @DisplayName("Переход к разделу Соусы")
    public void clickSaucesSectionButtonTest() {
        PageMain page = open(PageMain.MAIN_PAGE_URL, PageMain.class)
                .clickSaucesButton();
        assertTrue("Заголовок раздела 'Соусы' не отображается", page.isSaucesHeaderIsDisplayed());
    }

    @Test
    @DisplayName("Переход к разделу Начинки")
    public void clickFillingsSectionButtonTest() {
        PageMain page = open(PageMain.MAIN_PAGE_URL, PageMain.class)
                .clickFillingsButton();
        assertTrue("Заголовок раздела 'Начинки' не отображается", page.isFillingsHeaderIsDisplayed());
    }
}
