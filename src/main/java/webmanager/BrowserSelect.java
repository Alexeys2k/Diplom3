package webmanager;
import com.codeborne.selenide.WebDriverRunner;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BrowserSelect {

    public static void setDriver(String browserName){
        ChromeOptions options;
        switch (browserName){
            case "chrome":
                WebDriverManager.chromedriver().setup();
                options = new ChromeOptions();
                System.setProperty("webdriver.chrome.driver","src/main/resources/chromedriver.exe" );
                options.addArguments("--remote-allow-origins=*", "start-maximized");
                var driver = new ChromeDriver(options);
                WebDriverRunner.setWebDriver(driver);
                break;
            case "yandex":
                options = new ChromeOptions();
                System.setProperty("webdriver.chrome.driver", "src/main/resources/yandexdriver.exe");
                options.addArguments("--remote-allow-origins=*", "start-maximized");
                var yandexDriver = new ChromeDriver(options);
                WebDriverRunner.setWebDriver(yandexDriver);
                break;
            default:
                throw new RuntimeException("Incorrect BrowserName");
        }
    }

}
