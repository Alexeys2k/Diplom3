package api;
import webmanager.ValueForTest;

public class ApiGeneratorUser {

    public static User getUser() {
        String name = ValueForTest.TEST_NAME;
        String email = ValueForTest.TEST_EMAIL;
        String password = ValueForTest.TEST_PASSWORD;

        return new User(email, password, name );
    }
}