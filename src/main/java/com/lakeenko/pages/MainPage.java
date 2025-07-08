package com.lakeenko.pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Configuration.baseUrl;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class MainPage  {

    private final SelenideElement mainPageTitle = $("div.col-xs-slim div[style]");
    private final SelenideElement logo = $("#logo");
    private final SelenideElement footer = $("footer");

    @Step("Открываем основную страницу сайта")
    public MainPage openSite() {
        open(baseUrl);
        return this;
    }
    @Step("Проверяем, что заголовок, логотип и футер главной страницы отображаются")
    public void checkMainPageElements() {
        mainPageTitle.shouldBe(visible);
        logo.shouldBe(visible);
        footer.scrollIntoView(true).shouldBe(visible);
    }
}
