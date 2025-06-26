package pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class CartPage extends BasePage {

    private final SelenideElement addToCartButton = $(".product-page-cart-btn");
    private final SelenideElement clearCartButton = $(".clear-cart-btn, .btn-clear-cart, .delete-all");
    private final ElementsCollection productList = $$("div.products-view-block");

    @Step("Кликаем по первому товару в списке")
    public CartPage clickFirstProduct() {
        productList.first().scrollIntoView(true).click();
        return this;
    }

    @Step("Добавляем товар в корзину")
    public CartPage addToCart() {
        addToCartButton.shouldBe(visible).click();
        return this;
    }

    @Step("Проверяем, что счетчик корзины показывает {expectedCount}")
    public CartPage checkCartCounterEquals(int expectedCount) {
        cartCounter.shouldHave(text(String.valueOf(expectedCount)));
        return this;
    }

    @Step("Очищаем корзину")
    public CartPage clearCart() {
        if (clearCartButton.exists() && clearCartButton.isDisplayed()) {
            clearCartButton.click();
        }
        return this;
    }
}