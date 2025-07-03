package tests;

import data.GeneralMenuElements;
import io.qameta.allure.Owner;
import io.qameta.allure.junit5.AllureJunit5;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import pages.CartPage;

import static com.codeborne.selenide.Selenide.open;
import static pages.CoreElementsPage.clickGeneralMenuElements;

@ExtendWith(AllureJunit5.class)
public class CartTests extends TestBase {

    CartPage cartPage = new CartPage();

    @Test
    @DisplayName("Добавление товара в корзину")
    @Owner("lakeenkoi")
    @Tag("Cart")
    public void addToCartTest() {
        clickGeneralMenuElements(GeneralMenuElements.BASKETBALL);
        cartPage.clickFirstProduct()
                .addToCart()
                .checkCartCounterEquals(1);
    }

    @Test
    @DisplayName("Очистка корзины")
    @Owner("lakeenkoi")
    @Tag("Cart")
    public void clearCartTest() {
        clickGeneralMenuElements(GeneralMenuElements.BASKETBALL);
        cartPage.clickFirstProduct()
                .addToCart()
                .goToCart()
                .clearCart()
                .checkCartCounterEquals(0);
    }
}
