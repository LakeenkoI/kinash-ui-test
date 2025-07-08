package com.lakeenko.pages;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;
import static com.lakeenko.data.Urls.NIKE_TSHIRT_URL;

public class ProductCardPage {

    private final SelenideElement reviewsTab = $("li#tabReviews");
    private final SelenideElement reviewButton = $("div a.review-form-btn-add");
    private final SelenideElement characteristicsTab = $("li#tabOptions");
    private final ElementsCollection characteristicsSection = $$("div.properties-item-name");
    private final SelenideElement firstProduct = $$("div.products-view-block").first();

    @Step("Открываем страницу товара Nike T-Shirt")
    public ProductCardPage openNikeTShirtPage() {
        open(NIKE_TSHIRT_URL);
        return this;
    }
    @Step("Кликаем на таб 'Отзывы'")
    public ProductCardPage clickReviewsTab() {
        reviewsTab.shouldBe(clickable).click();
        return this;
    }

    @Step("Проверяем наличие кнопки 'Написать отзыв'")
    public ProductCardPage checkReviewButtonVisible() {
        reviewButton.shouldBe(visible);
        return this;
    }

    @Step("Кликаем по первому товару из списка")
    public ProductCardPage clickFirstProduct() {
        firstProduct.scrollIntoView(true).click();
        return this;
    }

    @Step("Кликаем на таб 'Характеристики'")
    public ProductCardPage clickCharacteristicsTab() {
        characteristicsTab.shouldBe(visible).click();
        return this;
    }

    @Step("Проверяем наличие строки 'Пол' в характеристиках")
    public ProductCardPage checkGenderCharacteristicPresent() {
        characteristicsSection.shouldHave(CollectionCondition.anyMatch(
                "должен содержать параметр 'Пол'",
                element -> element.getText().contains("Пол")));
        return this;
    }
}
