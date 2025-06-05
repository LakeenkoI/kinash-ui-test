package tests;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pages.MainPage;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Configuration.baseUrl;
import static com.codeborne.selenide.Selenide.*;

public class Tests {

    MainPage mainPage = new MainPage();

    @BeforeEach
    public void initSettings() {
        Configuration.browserSize = "1920x1080";
        baseUrl = "https://kinash.ru/";
        open(baseUrl);
    }

    @Test
    public void searchTest() {
        Configuration.timeout = 10000;
        $("[placeholder='Поиск']").setValue("Мяч волейбольный");
        $("a.kea-button-viewall").click();
        $("div.kea-products-container > div:first-child a").shouldBe(enabled).click();
        $("h1").shouldHave(text("Mikasa V1.5W Мяч волейбольный сувенирный"));
    }

    @Test
    public void addCartTest() {
        Configuration.timeout = 10000;
        open("https://kinash.ru/catalog");
        $x("//div[@class='product-categories-thin'][1]").scrollIntoView(true).click();
        $("div.buy-buttons-block a.btn-confirm").click();
        $("a.btn.btn-middle.btn-buy").click();
        Integer cartCounter = Integer.parseInt($(".cart-amount-custom").getText());

        Assertions.assertEquals(1, cartCounter);
        sleep(5000);
    }

    @Test
    void checkFooterPresence() {
        $("footer").scrollIntoView(true).shouldBe(visible);
    }

    @Test
    void navigateToMenuPageTest() {
        mainPage.clickMenu("Волейбол");
        $("h1").shouldHave(text("Магазин волейбольных товаров"));
    }

    @Test
    void clearCartTest() {
        open("https://kinash.ru/catalog");
        $x("//div[@class='product-categories-thin'][1]").scrollIntoView(true).click();
        $("div.buy-buttons-block a.btn-confirm").click();
        $("a.btn.btn-middle.btn-buy").click();
        $("a[title='Очистить корзину']").click();

        Integer cartCounter = Integer.parseInt($(".cart-amount-custom").getText());

        Assertions.assertEquals(0, cartCounter);
    }

    @Test
    public void addToWishlistTest() {
        Configuration.timeout = 10000;
        mainPage.clickMenu("Обувь");
        $$("div.products-view-tile div").first().click();
        $("div.block-wish-mini span").click();

        Integer wishlistCounter = Integer.parseInt($("span.sapfir-wishlist-amount").getText());
        String wishlistAttribute = $("div.start-whishlist span").getText();
        Assertions.assertEquals("В избранном", wishlistAttribute);

    }

    @Test
    public void filterTest() {
        mainPage.clickMenu("Одежда");
        String brand = $$("form[name=catalogFilterForm] div.catalog-filter-block:nth-child(2) div.catalog-filter-row").first().getText();
        $$("form[name=catalogFilterForm] div.catalog-filter-block:nth-child(2) div.catalog-filter-row").first().click();

        $("input[value='Применить']").click();
        $$("div[data-name=productViewCatalog] div.products-view-block").should(CollectionCondition.allMatch(
                ("Все элементы должны содержать brand",
                el -> el.getText().contains(brand)));

        sleep(5000);
    }


}

