package tests;

import data.GeneralMenuElements;
import extensions.Retry;
import io.qameta.allure.junit5.AllureJunit5;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import pages.CartPage;
import pages.MainPage;

@ExtendWith(AllureJunit5.class)
public class CartTests extends TestBase {

    MainPage mainPage = new MainPage();
    CartPage cartPage = new CartPage();

    @Retry(3)
    @Test
    public void addToCartTest() {
        mainPage.clickGeneralMenuElements(GeneralMenuElements.BASKETBALL);
        cartPage.clickFirstProduct()
                .addToCart()
                .checkCartCounterEquals(1);
    }

    @Retry(3)
    @Test
    public void clearCartTest() {
        mainPage.clickGeneralMenuElements(GeneralMenuElements.BASKETBALL);
        cartPage.clickFirstProduct()
                .addToCart()
                .goToCart()
                .clearCart()
                .checkCartCounterEquals(0);
    }
}
