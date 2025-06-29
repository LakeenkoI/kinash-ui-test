package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.matchText;
import static com.codeborne.selenide.Selenide.$;

public class SearchPage extends BasePage {

    private final SelenideElement firstResult = $("div.kea-products-container > div:first-child a.products-view-name-link");
    private final SelenideElement noResultsText = $("div.search-empty h1");

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

    @Step("Проверка, что заголовок страницы содержит запрос: {request}")
    @Override
    public SearchPage checkTitle() {
        title.shouldHave(matchText(".*" + request + ".*"));
        return this;
    }

    @Step("Установка поискового запроса: {request}")
    @Override
    public SearchPage setRequest(String request) {
        this.request = request;
        return this;
    }

    @Step("Проверка, что отображается текст 'Ничего не найдено'")
    public SearchPage checkNoResultsMessage() {
        noResultsText.shouldHave(matchText("Ничего не найдено"));
        return this;
    }
}