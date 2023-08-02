package ru.comindware.tests;

import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import ru.comindware.config.CredentialsConfig;
import ru.comindware.pages.CreateAttribute.CreateAttributePage;
import ru.comindware.pages.LoginPage;

public class CreateAttributeTest extends BaseTest {


        LoginPage loginPage = new LoginPage();
        CredentialsConfig config = ConfigFactory.create(CredentialsConfig.class);
        String login = config.loginProject();
        String password = config.passwordProject();

    CreateAttributePage attribute = new CreateAttributePage();




    @Test
        @DisplayName("Залогиниться в платформу")
        @Tag("PPM")
        void setLoginPage() {
            loginPage.login(login,password);
        }

    @Test
    @DisplayName("Создать текстовый атрибут")
    @Tag("PPM")
    void createAttributeText() throws Exception {
        loginPage.login(login,password);
        attribute.attemptCreateAttributes("Текст");
        attribute.attemptSearchAttribute("Текст");
        attribute.dragAndDropOneElementFromList();
        attribute.attemptSaveConstructorForm();
        attribute.assertElementsInArea("Текст");

    }

    @Test
    @DisplayName("Создать логический атрибут")
    @Tag("PPM")
    void createAttributeLog() throws Exception {
        loginPage.login(login,password);
        attribute.attemptCreateAttributes("Логический");
        attribute.attemptSearchAttribute("Логический");
        attribute.dragAndDropOneElementFromList();
        attribute.attemptSaveConstructorForm();
        attribute.assertElementsInArea("Логический");

    }

    @Test
    @DisplayName("Создать Дата и время атрибут")
    @Tag("PPM")
    void createAttributeData() throws Exception {
        loginPage.login(login,password);
        attribute.attemptCreateAttributes("Дата и время");
        attribute.attemptSearchAttribute("Дата и время");
        attribute.dragAndDropOneElementFromList();
        attribute.attemptSaveConstructorForm();
        attribute.assertElementsInArea("Дата и время");

    }

    @Test
    @DisplayName("Создать Число атрибут")
    @Tag("PPM")
    void createAttributeNumber() throws Exception {
        loginPage.login(login,password);
        attribute.attemptCreateAttributes("Число");
        attribute.attemptSearchAttribute("Число");
        attribute.dragAndDropOneElementFromList();
        attribute.attemptSaveConstructorForm();
        attribute.assertElementsInArea("Число");

    }

    @Test
    @DisplayName("Создать Длительность атрибут")
    @Tag("PPM")
    void createAttributeDuration() throws Exception {
        loginPage.login(login,password);
        attribute.attemptCreateAttributes("Длительность");
        attribute.attemptSearchAttribute("Длительность");
        attribute.dragAndDropOneElementFromList();
        attribute.attemptSaveConstructorForm();
        attribute.assertElementsInArea("Длительность");

    }

    @Test
    @DisplayName("Создать Аккаунт атрибут")
    @Tag("PPM")
    void createAttributeAccount() throws Exception {
        loginPage.login(login,password);
        attribute.attemptCreateAttributes("Аккаунт");
        attribute.attemptSearchAttribute("Аккаунт");
        attribute.dragAndDropOneElementFromList();
        attribute.attemptSaveConstructorForm();
        attribute.assertElementsInArea("Аккаунт");

    }

    @Test
    @DisplayName("Создать Документ атрибут")
    @Tag("PPM")
    void createAttributeDocument() throws Exception {
        loginPage.login(login,password);
        attribute.attemptCreateAttributes("Документ");
        attribute.attemptSearchAttribute("Документ");
        attribute.dragAndDropOneElementFromList();
        attribute.attemptSaveConstructorForm();
        attribute.assertElementsInArea("Документ");

    }

    @Test
    @DisplayName("Создать Изображение атрибут")
    @Tag("PPM")
    void createAttributePicture() throws Exception {
        loginPage.login(login,password);
        attribute.attemptCreateAttributes("Изображение");
        attribute.attemptSearchAttribute("Изображение");
        attribute.dragAndDropOneElementFromList();
        attribute.attemptSaveConstructorForm();
        attribute.assertElementsInArea("Изображение");

    }

    @Test
    @DisplayName("Создать Роль атрибут")
    @Tag("PPM")
    void createAttributeRole() throws Exception {
        loginPage.login(login,password);
        attribute.attemptCreateAttributes("Роль");
        attribute.attemptSearchAttribute("Роль");
        attribute.dragAndDropOneElementFromList();
        attribute.attemptSaveConstructorForm();
        attribute.assertElementsInArea("Роль");

    }

    @Test
    @DisplayName("Создать Штрихкод атрибут")
    @Tag("PPM")
    void createAttributeQR() throws Exception {
        loginPage.login(login,password);
        attribute.attemptCreateAttributeQR("Штрихкод");
        attribute.attemptSearchAttribute("Штрихкод");
        attribute.dragAndDropOneElementFromList();
        attribute.attemptSaveConstructorForm();
        attribute.assertElementsInArea("Штрихкод");

    }

    @Test
    @DisplayName("Создать Гиперссылка атрибут")
    @Tag("PPM")
    void createAttributeGyper() throws Exception {
        loginPage.login(login,password);
        attribute.attemptCreateAttributeHiperlink("Гиперссылка");
        attribute.attemptSearchAttribute("Гиперссылка");
        attribute.dragAndDropOneElementFromList();
        attribute.attemptSaveConstructorForm();
        attribute.assertElementsInArea("Гиперссылка");
    }

    @Test
    @DisplayName("Создать Список значений атрибут")
    @Tag("PPM")
    void createAttributeEnum() throws Exception {
        loginPage.login(login,password);
        attribute.attemptCreateAttributeEnum("Список значений");
        attribute.attemptSearchAttribute("Список значений");
        attribute.dragAndDropOneElementFromList();
        attribute.attemptSaveConstructorForm();
        attribute.assertElementsInArea("Список значений");
    }

    @Test
    @DisplayName("Создать Организационная единица атрибут")
    @Tag("PPM")
    void createAttributeOrgEd() throws Exception {
        loginPage.login(login,password);
        attribute.attemptCreateAttributeOrgUnin("Организационная единица");
        attribute.attemptSearchAttribute("Организационная единица");
        attribute.dragAndDropOneElementFromList();
        attribute.attemptSaveConstructorForm();
        attribute.assertElementsInArea("Организационная единица");
    }


    }


