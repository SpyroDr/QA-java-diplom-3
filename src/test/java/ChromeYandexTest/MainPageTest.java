package ChromeYandexTest;

import com.PageObject.MainPage;
import com.UserOperations;
import com.codeborne.selenide.Configuration;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static com.codeborne.selenide.Selenide.open;
import static org.junit.Assert.assertTrue;

public class MainPageTest {
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
    public void checkSuccessLogout() {
        final boolean isLoginButtonVisible = open(MainPage.URL, MainPage.class)
                .clickEnterAccountButton()
                .successLoginUser(userOperations)
                .clickUserAccountButton()
                .clickLogoutButton()
                .isLoginButtonVisible();
        assertTrue("Login button isn't shown", isLoginButtonVisible);
    }

    @Test
    public void checkGoConstructLogoButton() {
        final boolean isBurgerHeaderVisible = open(MainPage.URL, MainPage.class)
                .clickEnterAccountButton()
                .successLoginUser(userOperations)
                .clickUserAccountButton()
                .clickLogoButton()
                .isBurgerHeaderVisible();
        assertTrue("Constructheader isn't shown", isBurgerHeaderVisible);
    }

    @Test
    public void checkGoConstructConstructButton() {
        final boolean isBurgerHeaderVisible = open(MainPage.URL, MainPage.class)
                .clickEnterAccountButton()
                .successLoginUser(userOperations)
                .clickUserAccountButton()
                .clickConstructButton()
                .isBurgerHeaderVisible();
        assertTrue("Constructheader isn't shown", isBurgerHeaderVisible);
    }

    @Test
    public void checkGoBun() {
        final boolean isIngredientsListBunVisible = open(MainPage.URL, MainPage.class)
                .clickEnterAccountButton()
                .successLoginUser(userOperations)
                .clickFillingButton()
                .clickBunButton()
                .isIngredientsListBunVisible();
        assertTrue("Bunlist isn't shown", isIngredientsListBunVisible);
    }

    @Test
    public void checkGoSauce() {
        final boolean isIngredientsListSauceVisible = open(MainPage.URL, MainPage.class)
                .clickEnterAccountButton()
                .successLoginUser(userOperations)
                .clickSauceButton()
                .isIngredientsListSauceVisible();
        assertTrue("Saucelist isn't shown", isIngredientsListSauceVisible);
    }

    @Test
    public void checkGoFilling() {
        final boolean isIngredientsFillingBunVisible = open(MainPage.URL, MainPage.class)
                .clickEnterAccountButton()
                .successLoginUser(userOperations)
                .clickFillingButton()
                .isIngredientsFillingBunVisible();
        assertTrue("Fillinglist  isn't shown", isIngredientsFillingBunVisible);
    }
}
