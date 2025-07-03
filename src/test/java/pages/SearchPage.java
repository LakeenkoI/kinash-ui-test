package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;

public class SearchPage {

    private final SelenideElement firstResult = $("div.kea-products-container > div:first-child a.products-view-name-link");
    private final SelenideElement searchField = $("[placeholder='Поиск']");
    private final SelenideElement searchBtn = $(".site-head-search-btn");
    private final SelenideElement searchResult = $("body");
    private String request;


    @Step("Установка поискового запроса: {request}")
    public SearchPage setRequest(String request) {
        this.request = request;
        return this;
    }

    @Step("Выполнение поиска по запросу: {request}")
    public SearchPage search() {
        searchField.setValue(request);
        searchBtn.click();
        return this;
    }

    @Step("Выбор первого результата из результатов поиска")
    public SearchPage selectFirstResult() {
        firstResult.click();
        return this;
    }

    @Step("Проверка отображения результатов поиска")
    public void checkResults(String expectedText) {
        searchResult.shouldHave(text(expectedText));
    }
}