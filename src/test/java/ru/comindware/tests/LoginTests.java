package ru.comindware.tests;

import io.qameta.allure.*;
import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import ru.comindware.config.CredentialsConfig;
import ru.comindware.pages.LoginPage;


@Owner("Aantipov")
@Severity(SeverityLevel.BLOCKER)
@Feature("Страница логина")
@Story("Страница логина и регистрации")
public class LoginTests extends BaseTest {
    LoginPage loginPage = new LoginPage();
    CredentialsConfig config = ConfigFactory.create(CredentialsConfig.class);
    String login = config.loginProject();
    String password = config.passwordProject();

    @Test
    @DisplayName("Залогиниться в платформу")
    @Tag("PPM")
    void setLoginPage() {
        loginPage.login(login,password);
    }
}
