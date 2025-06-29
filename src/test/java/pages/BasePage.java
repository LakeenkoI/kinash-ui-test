package pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import data.GeneralMenuElements;
import data.TopMenuElements;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.matchText;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class BasePage {
    protected SelenideElement searchField = $("[placeholder='Поиск']");
    protected SelenideElement searchBtn = $(".site-head-search-btn");
    protected ElementsCollection menuGeneral = $$("ul.menu-general li ");
    protected ElementsCollection menuTop = $$("div.maintopmenu div");
    protected SelenideElement cartCounter = $(".cart-amount-custom");
    protected SelenideElement title = $("h1");
    protected String request;

    @Step("Клик по элементу главного меню: {menuElement.displayName}")
    public BasePage clickGeneralMenuElements(GeneralMenuElements menuElement) {
        menuGeneral.findBy(text(menuElement.getDisplayName())).click();
        return this;
    }

    @Step("Клик по элементу верхнего меню: {menuElement.displayName}")
    public BasePage clickTopMenuElements(TopMenuElements menuElement) {
        menuTop.findBy(text(menuElement.getDisplayName())).click();
        return this;
    }

    @Step("Проверка заголовка страницы содержит текст: {request}")
    public BasePage checkTitle() {
        title.shouldHave(matchText(".*" + request + ".*"));
        return this;
    }

    @Step("Установка поискового запроса: {request}")
    public BasePage setRequest(String request) {
        this.request = request;
        return this;
    }

    @Step("Получение значения счётчика корзины")
    public String getCartCounterText() {
        return cartCounter.getText();
    }

    @Step("Проверка, что счётчик корзины показывает значение: {expected}")
    public BasePage checkCartCounterEquals(String expected) {
        cartCounter.shouldHave(text(expected));
        return this;
    }
}
