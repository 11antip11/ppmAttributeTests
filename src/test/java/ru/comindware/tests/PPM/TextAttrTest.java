package ru.comindware.tests.PPM;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ArrayNode;
import io.qameta.allure.*;
import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import ru.comindware.config.CredentialsConfig;
import ru.comindware.pages.CreateAttribute.CreateAttrubutes;
import ru.comindware.pages.LoginPage;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
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
    String loginProject = config.loginProject(),
            passwordProject = config.passwordProject(),
            nameBP = getRandomString(10),
            nameShz1 = getRandomString(10),
            nameShz2 = getRandomString(10),
            nameText = getRandomString(10),
            nameBool = getRandomString(10),
            nameDate = getRandomString(10),
            nameDuration = getRandomString(10),
            nameNumber = getRandomString(10),
            nameAccount = getRandomString(10),
            nameDoc = getRandomString(10),
            namePicture = getRandomString(10),
            nameLink = getRandomString(10),
            nameRole = getRandomString(10),
            nameEnum = getRandomString(10),
            nameOrg = getRandomString(10),
            nameGiperlink = getRandomString(10),
            nameQR = getRandomString(10),
            nameShp = getRandomString(10),
            codeProject = String.valueOf(getRandomInt(0, 999999)),
            processAppId = "pa.1",
            projectDocumentAlias = "ProjectDocument",
            projectAlias = "Project";
    private List<String> typesAttrs;

    public class TypeOfAttribute {
        public static void main(String[] args){
            ArrayList<String> typesAttrs = new ArrayList<String>();
            typesAttrs.add(0,"Текст");
            typesAttrs.add(1,"Логический");
            typesAttrs.add(2,"Дата и время");
            typesAttrs.add(3,"Длительность");
            typesAttrs.add(4,"Число");
            typesAttrs.add(5,"Аккаунт");
            typesAttrs.add(6,"Документ");
            typesAttrs.add(7,"Изображение");
            typesAttrs.add(8,"Запись");
            typesAttrs.add(9,"Роль");
            typesAttrs.add(10,"Список значений");
            typesAttrs.add(11,"Организационная единица");
            typesAttrs.add(12,"Гиперссылка");
            typesAttrs.add(13,"Штрихкод");
        }
    }
    int i;

    @Test
    @Tag("Regress")
    @DisplayName("Создать приложение, шаблоны, атрибуты всех типов и вынести их на форму")
    void createAttribute() {
        open("https://test.qa.comindware.net/#solutions");
        loginPage.login(loginProject, passwordProject);
        createAttrubutes.CreateBP()
                .WriteDescriptionAndCreateBP(nameBP)
                .CreateRecordTemplate2(nameShz2)
                .CreateRecordTemplate1(nameShz1);
        for (i=0; i<=typesAttrs.size(); i++){
            if ((i != 7) || (i!=8) || (i!=12)){
                createAttrubutes.CreateAttr();
            }
        }
    }

}
