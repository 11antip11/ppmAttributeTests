package ru.comindware.tests.PPM;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ArrayNode;
import io.qameta.allure.*;
import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import ru.comindware.API.ObjectService;
import ru.comindware.API.Solution;
import ru.comindware.config.CredentialsConfig;
import ru.comindware.pages.CreateAttribute.CreateAttrubutes;
import ru.comindware.pages.LoginPage;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.switchTo;
import static ru.comindware.utils.RandomUtils.getRandomInt;
import static ru.comindware.utils.RandomUtils.getRandomString;

@Owner("Iantipov")
@Severity(SeverityLevel.BLOCKER)
@Feature("Регресс")
@Story("Регресс")
@Tag("Regress")
public class TextAttrTest {
    LoginPage loginPage = new LoginPage();
    CreateAttrubutes createAttrubutes = new CreateAttrubutes();
    CredentialsConfig config = ConfigFactory.create(CredentialsConfig.class, System.getProperties());
    Solution solution = new Solution();
    String loginProject = config.loginProject(),
            passwordProject = config.passwordProject(),
            nameBP = getRandomString(5),
            nameShz1 = getRandomString(5),
            nameShz2 = getRandomString(5),
            nameText = getRandomString(5),
            nameBool = getRandomString(5),
            nameDate = getRandomString(5),
            nameDuration = getRandomString(5),
            nameNumber = getRandomString(5),
            nameAccount = getRandomString(5),
            nameDoc = getRandomString(5),
            namePicture = getRandomString(5),
            nameLink = getRandomString(5),
            nameRole = getRandomString(5),
            nameEnum = getRandomString(5),
            nameOrg = getRandomString(5),
            nameGiperlink = getRandomString(5),
            nameQR = getRandomString(5),
            nameShp = getRandomString(5),
            codeProject = String.valueOf(getRandomInt(0, 999999)),
            processAppId = "pa.1",
            projectDocumentAlias = "ProjectDocument",
            projectAlias = "Project";
            List<String> nameAttr = Arrays.asList(nameText,nameBool,nameDate,nameDuration,nameNumber,nameAccount,nameDoc,namePicture,nameLink,nameRole,nameEnum,nameOrg,nameGiperlink,nameQR);



    @Test
    @Tag("Regress")
    @DisplayName("Создать приложение, шаблоны, атрибуты всех типов и вынести их на форму")
    void createAttribute() {
        open("https://test.qa.comindware.net/#solutions");
        loginPage.login(loginProject, passwordProject);
        createAttrubutes.CreateBP()
                .WriteDescriptionAndCreateBP(nameBP)
                .CreateRecordTemplate2(nameShz2)
                .CreateRecordTemplate1(nameShz1)
                .CreateAttr(nameAttr,nameShz2);
        solution.DeleteByAlias(loginProject, passwordProject, nameBP);
    }

}
