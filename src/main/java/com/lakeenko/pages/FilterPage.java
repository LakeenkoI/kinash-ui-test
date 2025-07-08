package com.lakeenko.pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import lombok.Getter;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

@Getter
public class FilterPage {

    private final ElementsCollection brandFilters = $$("form[name=catalogFilterForm] div.catalog-filter-block:nth-child(2) div.catalog-filter-row");
    private final ElementsCollection productList = $$("div[data-name=productViewCatalog] div.products-view-block");
    private final SelenideElement applyFilterBtn = $("input.btn.btn-middle.btn-submit");
    private String brand;

    @Step("Установка бренда для фильтра: {0}")
    public FilterPage setBrand(String brand) {
        this.brand = brand;
        return this;
    }

    @Step("Получение первого бренда из фильтров")
    public String getFirstBrandName() {
        return brandFilters.first().getText();
    }

    @Step("Клик по первому бренду в фильтре")
    public FilterPage selectFirstBrand() {
        brandFilters.first().click();
        return this;
    }

    @Step("Применение фильтра")
    public FilterPage applyFilter() {
        applyFilterBtn.shouldBe(visible).click();
        return this;
    }

    @Step("Проверка, что каждый товар содержит бренд: {brand}")
    public FilterPage checkProductsContainBrand(String brand) {
        productList.shouldHave(com.codeborne.selenide.CollectionCondition.allMatch(
                "Все элементы должны содержать бренд",
                el -> el.getText().contains(brand)));
        return this;
    }
}