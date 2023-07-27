package ru.comindware.pages.CreateAttribute;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.WebDriverRunner;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.time.Duration;

import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.*;
import static ru.comindware.helpers.Locators.getLocator;
import static org.openqa.selenium.Keys.TAB;

public    class CreateAttributePage {
    @Step("Переход на другую вкладку браузера")
    public static void switchToBrowser(String url) throws Exception {
        Robot r = null;
        try {
            r = new Robot();
        } catch (AWTException e) {
            e.printStackTrace();
        }
        r.keyPress(KeyEvent.VK_CONTROL);
        r.keyPress(KeyEvent.VK_T);
        r.keyRelease(KeyEvent.VK_CONTROL);
        r.keyRelease(KeyEvent.VK_T);
        switchTo().window(1);
        open(url);
    }
    @Step("Создание атрибутов типа Текст, Логический,Дата и время, Длительность, Число, Аккаунт, Документ, Изображение, Роль.")
        public  void attemptCreateAttributes(String variableNameTypeAttribute) throws Exception {
        $(getLocator("AreaFormConstructorPage.attributesNameLocator")).shouldBe(Condition.visible).hover();
        $(getLocator("AreaFormConstructorPage.iconAddAttributesLocator")).shouldBe(Condition.visible).click();
        $(getLocator("AreaFormConstructorPage.fieldNameAttributedInPopUpLocator")).shouldBe(Condition.visible).click();
        $(getLocator("AreaFormConstructorPage.fieldNewNameAttributedInPopUpLocator")).shouldBe(Condition.visible).sendKeys(variableNameTypeAttribute);
        $(getLocator("AreaFormConstructorPage.fieldTypeAttributedInPopUpLocator")).shouldBe(Condition.visible).click();

        String searchLocator = "//*[@class='grid-table-wrapper-war']//*[@title='" + variableNameTypeAttribute + "']";

        WebElement webElementSearchLocator = $(byXpath(searchLocator));
        $(byXpath(searchLocator)).shouldBe(Condition.visible);
        actions().click(webElementSearchLocator).perform();

        $(getLocator("AreaFormConstructorPage.buttonSaveAttributeInPopUpLocator")).shouldBe(Condition.visible).click();
        $(getLocator("AreaFormConstructorPage.buttonSaveAttributeInPopUpLocator")).shouldNot(Condition.visible, Duration.ofSeconds(15));
    }
    @Step("Проверка наличия созданного атрибута по имени.")
    public static void attemptSearchAttribute(String variableNameAttribute) throws Exception {
        $(getLocator("AreaFormConstructorPage.clickSearchLocator")).shouldBe(Condition.visible).click();
        $(getLocator("AreaFormConstructorPage.enteredVariableSearchLocator")).shouldBe(Condition.visible).sendKeys(variableNameAttribute);
        $(getLocator("AreaFormConstructorPage.selectOneVariableInSearchLocator")).shouldBe(Condition.visible).click();
    }
    @Step("Перемещение первого атрибута из списка в Процессах.")
    public static void dragAndDropOneElementFromList()
    {
        String getCssLocator =".js-custom-attributes-region .js-context-ld-list-item ";

        try
        {
            JavascriptExecutor ex = ((JavascriptExecutor) WebDriverRunner.getWebDriver());
            ex.executeScript("var oEvent = new DragEvent('dragover');" +
                    "document.querySelector('.ld-view__canvas .region').dispatchEvent(oEvent); ");
            ex.executeScript("var sEvent = new DragEvent('dragstart', { dataTransfer: new DataTransfer() });" +
                    "document.querySelector('"+ getCssLocator+"[draggable=\"true\"]').dispatchEvent(sEvent); ");
            ex.executeScript("var dEvent = new DragEvent('drag', { dataTransfer: new DataTransfer(), clientX: 900, clientY: 800  });" +
                    "document.querySelector('" + getCssLocator + "[draggable=\"true\"]').dispatchEvent(dEvent); ");
            ex.executeScript("var eEvent = new DragEvent('dragend', { dataTransfer: new DataTransfer() });" +
                    "document.querySelector('" + getCssLocator + "[draggable=\"true\"]').dispatchEvent(eEvent); ");
        }
        catch(Exception ex)
        {
        }
    }
    @Step("Сохранение конструктора форм")
    public static void attemptSaveConstructorForm() throws Exception {
        $(getLocator("AreaFormConstructorPage.buttonSaveLocator")).shouldBe(Condition.visible).click();
    }
    @Step("Проверка атрибута в рабочей области")
    public static void assertElementsInArea(String nameAttribute)  {
        refresh();
        String searchElementInWorkingAreaLocator="//*[@class='js-container form-root-container']//*[contains(text(),'"+nameAttribute+"')]";
        $(By.xpath(searchElementInWorkingAreaLocator)).shouldBe(Condition.visible);
    }

    private  CharSequence getPropertiesConfig(String nameValueEnumConfig) {
        return null;
    }

    @Step("Создание атрибутов типа Список значений.")
    //TODO: Не хватает скролла в окне выбора типа атрибута для создания единого метода для всех без разбивки
    public void attemptCreateAttributeEnum(String variableNameTypeAttribute) throws Exception {
        $(getLocator("AreaFormConstructorPage.attributesNameLocator")).shouldBe(Condition.visible).hover();
        $(getLocator("AreaFormConstructorPage.iconAddAttributesLocator")).shouldBe(Condition.visible).click();
        $(getLocator("AreaFormConstructorPage.fieldNameAttributedInPopUpLocator")).shouldBe(Condition.visible).click();
        $(getLocator("AreaFormConstructorPage.fieldNewNameAttributedInPopUpLocator")).shouldBe(Condition.visible).sendKeys(variableNameTypeAttribute);
        $(getLocator("AreaFormConstructorPage.fieldTypeAttributedInPopUpLocator")).shouldBe(Condition.visible).click();

        String searchLocator = "//*[@class='grid-table-wrapper-war']//*[@title='" + variableNameTypeAttribute + "']";
        String searchRoleScrollLocator = "//*[@class='grid-table-wrapper-war']//*[@title='Роль']";

        WebElement webElementSearchRoleLocator = $(byXpath(searchRoleScrollLocator));
        WebElement webElementSearchLocator = $(byXpath(searchLocator));

        actions().click(webElementSearchRoleLocator).perform();

        $(getLocator("AreaFormConstructorPage.fieldNewNameAttributedInPopUpLocator")).shouldBe(Condition.visible).click();
        $(getLocator("AreaFormConstructorPage.fieldTypeAttributedInPopUpLocator")).shouldBe(Condition.visible).click();

        actions().click(webElementSearchLocator).perform();

        $(getLocator("AreaFormConstructorPage.tabListVariableEnumLocator")).shouldBe(Condition.visible).click();
        $(getLocator("AreaFormConstructorPage.buttonCreateVariableEnumLocator")).shouldBe(Condition.visible).click();

        WebElement webElementFieldSystemNameLocator = $(getLocator("AreaFormConstructorPage.fieldSystemNameEnumLocator"));
        actions().click(webElementFieldSystemNameLocator).perform();
        CharSequence Enum1 = "test";
        $(getLocator("AreaFormConstructorPage.fieldSystemNameEnumLocator")).shouldBe(Condition.visible).sendKeys(Enum1);
        $(getLocator("AreaFormConstructorPage.fieldSystemNameEnumLocator")).shouldBe(Condition.visible).sendKeys(TAB.toString() + Enum1);
        Thread.sleep(1000);
        $(getLocator("AreaFormConstructorPage.fieldSystemNameEnumLocator")).shouldBe(Condition.visible).sendKeys(TAB.toString() + Enum1);
        Thread.sleep(1000);
        $(getLocator("AreaFormConstructorPage.fieldSystemNameEnumLocator")).shouldBe(Condition.visible).sendKeys(TAB.toString() + Enum1);
        Thread.sleep(1000);

        $(getLocator("AreaFormConstructorPage.buttonSaveAttributeInPopUpLocator")).shouldBe(Condition.visible).click();
        $(getLocator("AreaFormConstructorPage.buttonSaveAttributeInPopUpLocator")).shouldNot(Condition.visible, Duration.ofSeconds(15));
    }


    @Step("Создание атрибутов типа Орг. еденицы и Список значений.")
    public void attemptCreateAttributeOrgUnin(String variableNameTypeAttribute) throws Exception {
        $(getLocator("AreaFormConstructorPage.attributesNameLocator")).shouldBe(Condition.visible).hover();
        $(getLocator("AreaFormConstructorPage.iconAddAttributesLocator")).shouldBe(Condition.visible).click();
        $(getLocator("AreaFormConstructorPage.fieldNameAttributedInPopUpLocator")).shouldBe(Condition.visible).click();
        CharSequence Enum = "Организационная единица";
        $(getLocator("AreaFormConstructorPage.fieldNewNameAttributedInPopUpLocator")).shouldBe(Condition.visible).sendKeys(Enum);
        $(getLocator("AreaFormConstructorPage.fieldTypeAttributedInPopUpLocator")).shouldBe(Condition.visible).click();

        String searchLocator = "//*[@class='grid-table-wrapper-war']//*[@title='" + variableNameTypeAttribute + "']";
        String searchRoleScrollLocator = "//*[@class='grid-table-wrapper-war']//*[@title='Роль']";
        WebElement webElementSearchRoleLocator = $(byXpath(searchRoleScrollLocator));
        WebElement webElementSearchLocator = $(byXpath(searchLocator));

        actions().click(webElementSearchRoleLocator).perform();

        $(getLocator("AreaFormConstructorPage.fieldNewNameAttributedInPopUpLocator")).shouldBe(Condition.visible).click();
        $(getLocator("AreaFormConstructorPage.fieldTypeAttributedInPopUpLocator")).shouldBe(Condition.visible).click();

        actions().click(webElementSearchLocator).perform();

        $(getLocator("AreaFormConstructorPage.buttonSaveAttributeInPopUpLocator")).shouldBe(Condition.visible).click();
        $(getLocator("AreaFormConstructorPage.buttonSaveAttributeInPopUpLocator")).shouldNot(Condition.visible, Duration.ofSeconds(15));
    }


    @Step("Создание атрибутов типа Гиперссылка.")
    public void attemptCreateAttributeHiperlink(String variableNameTypeAttribute) throws Exception {
        $(getLocator("AreaFormConstructorPage.attributesNameLocator")).shouldBe(Condition.visible).hover();
        $(getLocator("AreaFormConstructorPage.iconAddAttributesLocator")).shouldBe(Condition.visible).click();
        $(getLocator("AreaFormConstructorPage.fieldNameAttributedInPopUpLocator")).shouldBe(Condition.visible).click();
        $(getLocator("AreaFormConstructorPage.fieldNewNameAttributedInPopUpLocator")).shouldBe(Condition.visible).sendKeys(variableNameTypeAttribute);
        $(getLocator("AreaFormConstructorPage.fieldTypeAttributedInPopUpLocator")).shouldBe(Condition.visible).click();

        String searchLocator = "//*[@class='grid-table-wrapper-war']//*[@title='" + variableNameTypeAttribute + "']";
        String searchRoleScrollLocator = "//*[@class='grid-table-wrapper-war']//*[@title='Роль']";

        WebElement webElementSearchRoleLocator = $(byXpath(searchRoleScrollLocator));
        WebElement webElementSearchLocator = $(byXpath(searchLocator));

        actions().click(webElementSearchRoleLocator).perform();

        $(getLocator("AreaFormConstructorPage.fieldNewNameAttributedInPopUpLocator")).shouldBe(Condition.visible).click();
        $(getLocator("AreaFormConstructorPage.fieldTypeAttributedInPopUpLocator")).shouldBe(Condition.visible).click();

        actions().click(webElementSearchLocator).perform();

        $(getLocator("AreaFormConstructorPage.fieldURIAttributeHiperlinkLocator")).shouldBe(Condition.visible).click();
        $(getLocator("AreaFormConstructorPage.checkboxURIAttributeHiperlinkLocator")).shouldBe(Condition.visible).click();
        $(getLocator("AreaFormConstructorPage.buttonSaveAttributeInPopUpLocator")).shouldBe(Condition.visible).click();
        $(getLocator("AreaFormConstructorPage.buttonSaveAttributeInPopUpLocator")).shouldNot(Condition.visible, Duration.ofSeconds(15));
    }

    @Step("Создание атрибутов типа Штрихкод.")
    public void attemptCreateAttributeQR(String variableNameTypeAttribute) throws Exception {
        $(getLocator("AreaFormConstructorPage.attributesNameLocator")).shouldBe(Condition.visible).hover();
        $(getLocator("AreaFormConstructorPage.iconAddAttributesLocator")).shouldBe(Condition.visible).click();
        $(getLocator("AreaFormConstructorPage.fieldNameAttributedInPopUpLocator")).shouldBe(Condition.visible).click();
        $(getLocator("AreaFormConstructorPage.fieldNewNameAttributedInPopUpLocator")).shouldBe(Condition.visible).sendKeys(variableNameTypeAttribute);
        $(getLocator("AreaFormConstructorPage.fieldTypeAttributedInPopUpLocator")).shouldBe(Condition.visible).click();

        String searchLocator = "//*[@class='grid-table-wrapper-war']//*[@title='" + variableNameTypeAttribute + "']";
        String searchRoleScrollLocator = "//*[@class='grid-table-wrapper-war']//*[@title='Роль']";

        WebElement webElementSearchRoleLocator = $(byXpath(searchRoleScrollLocator));
        WebElement webElementSearchLocator = $(byXpath(searchLocator));

        actions().click(webElementSearchRoleLocator).perform();

        $(getLocator("AreaFormConstructorPage.fieldNewNameAttributedInPopUpLocator")).shouldBe(Condition.visible).click();
        $(getLocator("AreaFormConstructorPage.fieldTypeAttributedInPopUpLocator")).shouldBe(Condition.visible).click();

        actions().click(webElementSearchLocator).perform();

        $(getLocator("AreaFormConstructorPage.buttonSaveAttributeInPopUpLocator")).shouldBe(Condition.visible).click();
        $(getLocator("AreaFormConstructorPage.buttonSaveAttributeInPopUpLocator")).shouldNot(Condition.visible, Duration.ofSeconds(15));
    }
}
