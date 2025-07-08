package com.lakeenko.tests.regress;

import com.lakeenko.data.GeneralMenuElements;
import com.lakeenko.tests.TestBase;
import io.qameta.allure.Feature;
import io.qameta.allure.Link;
import io.qameta.allure.Owner;
import io.qameta.allure.Story;
import io.qameta.allure.junit5.AllureJunit5;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import static com.lakeenko.helpers.AllureAttach.addVideo;
import static com.lakeenko.pages.components.CoreElementsPage.clickGeneralMenuElements;

@ExtendWith(AllureJunit5.class)
@Link(name = "https://kinash.ru/", url = "https://kinash.ru/")
@Owner("LakeenkoI")
@Feature("Kinash")
@Story("Корзина")
@Tag("Cart")
@Tag("Regression")
public class CartTests extends TestBase {

    @Test
    @DisplayName("Добавление товара в корзину")
    public void addToCartTest() {
        mainPage.openSite();
        clickGeneralMenuElements(GeneralMenuElements.BASKETBALL);
        cartPage.clickFirstProduct()
                .addToCart()
                .checkCartCounterEquals(1);
    }

    @Test
    @DisplayName("Очистка корзины")
    public void clearCartTest() {
        mainPage.openSite();
        clickGeneralMenuElements(GeneralMenuElements.BASKETBALL);
        cartPage.clickFirstProduct()
                .addToCart()
                .goToCart()
                .clearCart()
                .checkCartCounterEquals(0);
    }
}