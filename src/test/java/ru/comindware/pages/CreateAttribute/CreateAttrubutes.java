package ru.comindware.pages.CreateAttribute;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import ru.comindware.tests.PPM.TextAttrTest;

import java.util.List;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selectors.byValue;
import static com.codeborne.selenide.Selenide.*;

public class CreateAttrubutes {

    SelenideElement createAttributes = $(".toolbar-items-wrp").$(byText("Создать")),
            textField = $(".input_text"),
            textFieldPopUp = $(".layout__tab-layout").$(".input_text"),
            dropDown = $x("//*[@class='js-input bubbles__input']"),
            saveButton = $(".toolbar-btn.js-btn.btn-strong").$(byText("Сохранить")),
            createObject = $(".toolbar-items-wrp").$("[title=Создать]"),
            searchAddElement = $("[class='ld-list-title__name ld-list-item-title__name_group js-name']"),
            createAttrInForm = $(".js-drag-handle > .js-add-action"),
            searchTemplates = $(".title-settings").$(byText("Шаблоны")),
            comeBack = $(".top-nav-nomination-breadcrumbs").$("[title=Шаблоны]"),
            selectProcessTemplate = $(".bubbles__list").$(byText("Шаблон процесса")),
            createTemplates = $("#save"),
            tabAttributes = $(".layout__tab-layout__header-view "),
            typesAttributes = $(".layout__tab-layout").$(".bubbles__list"),
            selectType = $(".dropdown__wrp_list.datalist_collection-panel").$(".grid-table-wrapper-war"),
            scrollQR = $(".dropdown__wrp_list.datalist_collection-panel").$(".grid-table-wrapper-war").$(byText("Штрихкод")),
            selectColor = $("[data-fields='imageColorType']"),
            selectSearchTemplate = $("[data-fields='instanceOf']"),
            searchUrl = $("[data-fields='uriSchemeFormats']"),
            selectUrlHttp = $(byText("HTTP")),
            scrollToTheEnd = $(".js-grid-table-wrapper.grid-table-wrapper"),
            savePopUp = $("#accept").$(byText("Сохранить")),
            selectColorType = $(".dd-list__text");

    int i;
    String typeAt = "Штрихкод";


    @Step("Создать бизнес-приложение")
    public CreateAttrubutes CreateBP() {
        createObject.click();
        return this;
    }

    @Step("Заполнить обязательные поля и нажать \"Сохранить\"")
    public CreateAttrubutes WriteDescriptionAndCreateBP(String nameBP) {
        textField.setValue(nameBP);
        saveButton.click();
        $(".grid-table-wrapper-war").$(byText(nameBP)).doubleClick();
        return this;
    }

    @Step("Создать первый шаблон записи")
    public CreateAttrubutes CreateRecordTemplate1(String nameShz1) {
        createObject.click();
        textField.setValue(nameShz1);
        createTemplates.click();
        return this;
    }

    @Step("Создать второй шаблон записи")
    public CreateAttrubutes CreateRecordTemplate2(String nameShz2) {
        searchTemplates.click();
        createObject.click();
        textField.setValue(nameShz2);
        createTemplates.click();
        comeBack.click();
        return this;
    }

    @Step("Создать атрибуты всех типов")
    public CreateAttrubutes CreateAttr(List<String> nameAttr, String nameShz2){
        tabAttributes.$(byText("Формы")).click();
        $(".grid-table-wrapper-war").$(byText("defaultForm")).doubleClick();
        for (i=0;i<nameAttr.size();i++){
            String a = nameAttr.get(i);
            searchAddElement.shouldBe(Condition.visible).hover();
            createAttrInForm.shouldBe(Condition.visible).click();
            textFieldPopUp.setValue(a);
            typesAttributes.click();
            if (i <= 8){
                switch (i) {
                    case (0) -> selectType.$(byText("Текст")).click();
                    case (1) -> selectType.$(byText("Логический")).click();
                    case (2) -> selectType.$(byText("Дата и время")).click();
                    case (3) -> selectType.$(byText("Длительность")).click();
                    case (4) -> selectType.$(byText("Число")).click();
                    case (5) -> selectType.$(byText("Аккаунт")).click();
                    case (6) -> selectType.$(byText("Документ")).click();
                    case (7) -> {
                        selectType.$(byText("Изображение")).click();
                        selectColor.click();
                        selectColorType.click();
                    }
                    case (8) -> {
                        selectType.$(byText("Запись")).click();
                        selectSearchTemplate.click();
                        $(byText(nameShz2)).click();
                    }
                }
            }else {
                selectType.$(byText("Запись")).click();
                typesAttributes.click();
                switch (i) {
                    case (9) -> selectType.$(byText("Роль")).click();
                    case (10) -> selectType.$(byText("Список значений")).click();
                    case (11) -> selectType.$(byText("Организационная единица")).click();
                    case (12) -> {
                        selectType.$(byText("Гиперссылка")).click();
                        searchUrl.click();
                        selectUrlHttp.click();
                    }
                    case (13) -> selectType.$(byText("Штрихкод")).click();
                }
            }
            savePopUp.click();
        }
        return this;
    }

//    @Step("Создать шаблон процесса")
//    public CreateAttrubutes CreateProcessTemplate(String nameShp) {
//        createObject.click();
//        textField.setValue(nameShp);
//        selectProcessTemplate.click();
//        $("js-input.bubbles__input").click();
//        $("grid-table-wrapper-war").click();
//        createTemplates.click();
//        comeBack.click();
//        return this;
//    }


}
