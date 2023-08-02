package ru.comindware.pages.CreateAttribute;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selectors.byValue;
import static com.codeborne.selenide.Selenide.$;

public class CreateAttrubutes {

    SelenideElement createAttributes = $(".toolbar-items-wrp").$(byText("Создать")),
            textField = $(".input.input_text"),
            saveButton = $(".toolbar-btn.js-btn.btn-strong").$(byText("Сохранить")),
            createObject = $(".toolbar-items-wrp").$("[title=Создать]"),
            searchTemplates = $(".title-settings").$(byText("Шаблоны")),
            comeBack = $(".top-nav-nomination-breadcrumbs").$("[title=Шаблоны]"),
            selectProcessTemplate = $(".bubbles__list").$(byText("Шаблон процесса")),
            createTemplates = $("#save"),
            tabAttributes = $(".js-name.layout__tab-layout__header-view-item-text");


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

    @Step("Создать атрибут")
    public CreateAttrubutes CreateAttr(){
        tabAttributes.click();
        createObject.click();
        int i;
        for (i=0;i<=12;i++){

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
