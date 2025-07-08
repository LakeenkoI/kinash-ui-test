package com.lakeenko.pages;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class CartPage  {

    private final SelenideElement addToCartButton = $("a.btn.btn-middle.btn-confirm");
    private final SelenideElement clearCartButton = $(".icon-cancel-circled-before.link-text-decoration-none.cs-l-3");
    private final ElementsCollection productList = $$("div.products-view-block");
    private final SelenideElement goToCartButton = $("div.modal-content a.btn-middle.btn-buy");
    private final SelenideElement cartCounter = $(".cart-amount-custom");


    @Step("Кликаем по первому товару в списке")
    public CartPage clickFirstProduct() {
        productList
                .first()
                .scrollIntoView(true).click();
        return this;
    }

    @Step("Добавляем товар в корзину")
    public CartPage addToCart() {
        addToCartButton
                .shouldBe(visible)
                .click();
        return this;
    }

    @Step("Переходим в корзину")
    public CartPage goToCart() {
        goToCartButton.shouldBe(clickable).click();
        return this;
    }

    @Step("Проверяем, что счетчик корзины показывает {expectedCount}")
    public CartPage checkCartCounterEquals(int expectedCount) {
        cartCounter.shouldHave(text(String.valueOf(expectedCount)));
        return this;
    }

    @Step("Очищаем корзину")
    public CartPage clearCart() {
        clearCartButton.shouldBe(visible).click();
        return this;
    }
}