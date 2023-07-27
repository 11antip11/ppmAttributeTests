package ru.comindware;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class PlatformComponents {

    public SelenideElement dropDown(int index) {
        return $x("(//*[@class='js-input bubbles__input'])[" + index + "]");
    }

    public SelenideElement textarea(int index) {
        return $x("(//*[@class='textarea js-input'])[" + index + "]");
    }

    public SelenideElement textarea() {
        return $x("(//*[@class='textarea js-input'])");
    }

    public SelenideElement notificationContainer() {
        return $(".notification-body_container");
    }

    public SelenideElement collectionField(int index) {
        return $x("//*[@class='js-visible-collection visible-collection ']/tr/td[" + index + "]");
    }

    public SelenideElement collectionField(int index1, int index2) {
        return $x("(//*[@class='js-visible-collection visible-collection ']/tr/td[" + index1 + "])[" + index2 + "]");
    }

    public SelenideElement addNewRecordToCollection(int index) {
        return $x("(//*[@class='toolbar-btn toolbar-btn_none    toolbar-btn_action  '])[" + index + "]");
    }

    public SelenideElement addNewRecordToCollection() {
        return $x("(//*[@class='toolbar-btn toolbar-btn_none    toolbar-btn_action  '])");
    }

    public SelenideElement firstListCheckBox() {
        return $x("//*[@class='dd-list__i dd-list__i_checkbox selected']");
    }

    public SelenideElement radioButtonYes() {
        return $(".editor_radiobutton");
    }

    public SelenideElement radioButton(int index) {
        return $x("(//*[@class='editor editor_radiobutton '])[" + index + "]");
    }

    public SelenideElement firstElementFromDropdown() {
        return $(".dd-list__i.selected");
    }

    public SelenideElement textField(int index) {
        return $x("(//*[@class='input input_text js-input'])[" + index + "]");
    }

    public SelenideElement textField() {
        return $x("(//*[@class='input input_text js-input'])");
    }
}
