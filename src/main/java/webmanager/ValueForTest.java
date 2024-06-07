package webmanager;
import org.apache.commons.lang3.RandomStringUtils;

public class ValueForTest extends RandomStringUtils {

    public static final String
            TEST_EMAIL = randomAlphabetic(10).toLowerCase() + "@yandex.ru",
            TEST_PASSWORD = "123qwe",
            PASSWORD_ERROR = "123",
            TEST_NAME = randomAlphabetic(10);
}