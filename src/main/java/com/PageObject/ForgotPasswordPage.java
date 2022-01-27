package com.PageObject;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.page;

public class ForgotPasswordPage {
    public static final String URL = "https://stellarburgers.nomoreparties.site/forgot-password";

    //локатор кнопки Войти
    @FindBy(how = How.XPATH, using = ".//a[text()='Войти']")
    private SelenideElement loginButton;

    //метод клика на кнопку Войти
    public LoginPage clickLoginButton() {
        $(loginButton).click();
        return page(LoginPage.class);
    }
}
