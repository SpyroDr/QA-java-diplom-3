package ChromeYandexTest;

import com.PageObject.ForgotPasswordPage;
import com.PageObject.MainPage;
import com.PageObject.RegistrationPage;
import com.UserOperations;
import com.codeborne.selenide.Configuration;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static com.codeborne.selenide.Selenide.open;
import static org.junit.Assert.assertTrue;

public class LoginPageTest {
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
    public void checkSuccessLoginInButtonEnterAccount() {
        final boolean isOrderButtonVisible = open(MainPage.URL, MainPage.class)
                .clickEnterAccountButton()
                .successLoginUser(userOperations)
                .isOrderButtonVisible();
        assertTrue("Order button is not displayed", isOrderButtonVisible);
    }

    @Test
    public void checkSuccessLoginInButtonUserAccount() {
        final boolean isOrderButtonVisible = open(MainPage.URL, MainPage.class)
                .clickUserAccountButtonIsAuth()
                .successLoginUser(userOperations)
                .isOrderButtonVisible();
        assertTrue("Order button is not displayed", isOrderButtonVisible);
    }

    @Test
    public void checkSuccessLoginInLogin() {
        final boolean isOrderButtonVisible = open(RegistrationPage.URL, RegistrationPage.class)
                .clickLoginButton()
                .successLoginUser(userOperations)
                .isOrderButtonVisible();
        assertTrue("Order button is not displayed", isOrderButtonVisible);
    }

    @Test
    public void checkSuccessLoginInLoginButton() {
        final boolean isOrderButtonVisible = open(ForgotPasswordPage.URL, ForgotPasswordPage.class)
                .clickLoginButton()
                .successLoginUser(userOperations)
                .isOrderButtonVisible();
        assertTrue("Order button is not displayed", isOrderButtonVisible);
    }

}
