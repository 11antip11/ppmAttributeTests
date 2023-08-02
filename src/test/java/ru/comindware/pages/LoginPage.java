package ru.comindware.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import java.time.Duration;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class LoginPage {
    SelenideElement login = $("#username");
    SelenideElement password = $("#password");
    SelenideElement loginButton = $("#LoginButton");
    SelenideElement navPerson = $(".top-nav-person");

    @Step("Логинимся под {username} с паролем {pass}")
    public LoginPage login(String username, String pass) {
        open("https://test.qa.comindware.net/#solutions");
        login.shouldBe(visible, Duration.ofSeconds(30));
        login.setValue(username);
        password.setValue(pass);
        loginButton.click();
        return this;
    }
    @Step("Негативно Логинимся под {username} с паролем {pass}")
    public LoginPage loginNegative(String username, String pass) {
        open("");
        login.shouldBe(visible, Duration.ofSeconds(30));
        login.setValue(username);
        password.setValue(pass);
        loginButton.click();
        navPerson.shouldNotBe(Condition.visible);
        return this;
    }

}
