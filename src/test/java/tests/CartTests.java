package test.java.tests;

import io.qameta.allure.junit5.AllureJunit5;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import pages.CartPage;
import pages.MainPage;

import static com.codeborne.selenide.Selenide.open;

@ExtendWith(AllureJunit5.class)
public class CartTests {

    MainPage mainPage = new MainPage();
    CartPage cartPage = new CartPage();

    @Test
    public void addToCartTest() {
        open("https://kinash.ru/");
        mainPage.clickGeneralMenuElements("Баскетбол");
        cartPage.clickFirstProduct()
                .addToCart()
                .checkCartCounterEquals(1);
    }

    @Test
    public void clearCartTest() {
        open("https://kinash.ru/cart");
        cartPage.clearCart()
                .checkCartCounterEquals(0);
    }
}