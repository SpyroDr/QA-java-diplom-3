package ChromeYandexTest;

import com.PageObject.RegistrationPage;
import com.UserOperations;
import com.codeborne.selenide.Configuration;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static com.codeborne.selenide.Selenide.open;
import static org.junit.Assert.assertTrue;

public class RegistrationPageTest {

    private UserOperations userOperations;

    @Before
    public void setup() {
        userOperations = new UserOperations();
        Configuration.startMaximized = true;
        Configuration.browser = "chrome";
        //System.setProperty("webdriver.chrome.driver", "src/main/resources/yandexdriver.exe");

    }

    @After
    public void tearDown() {
        userOperations.delete();
    }

    @Test
    public void checkSuccessRegistration() {
        final boolean isLoginButtonVisible = open(RegistrationPage.URL, RegistrationPage.class)
                .successRegistrationNewUser()
                .isLoginButtonVisible();
        assertTrue("Login button isn't shown", isLoginButtonVisible);
    }

    @Test
    public void checkFailRegistration() {
        final boolean isIncorrectPasswordMessage = open(RegistrationPage.URL, RegistrationPage.class)
                .failRegistrationNewUser()
                .isIncorrectPasswordMessage();
        assertTrue("Error message isn't shown", isIncorrectPasswordMessage);
    }
}
