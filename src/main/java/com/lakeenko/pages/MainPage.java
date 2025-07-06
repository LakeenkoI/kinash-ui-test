package com.lakeenko.pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class MainPage  {

    SelenideElement mainPageTitle = $("div.col-xs-slim div[style]");
    SelenideElement logo = $("#logo");
    SelenideElement footer = $("footer");

    @Step("Проверяем, что заголовок, логотип и футер главной страницы отображаются")
    public void checkMainPageElements() {
        mainPageTitle.shouldBe(visible);
        logo.shouldBe(visible);
        footer.scrollIntoView(true).shouldBe(visible);
    }
}
