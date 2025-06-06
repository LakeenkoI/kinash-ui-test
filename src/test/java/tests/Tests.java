package tests;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Configuration;
import elements.Topmenu;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junitpioneer.jupiter.RetryingTest;
import pages.GeneralMenu;
import pages.MainPage;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Configuration.baseUrl;
import static com.codeborne.selenide.Selenide.*;

public class Tests {

    MainPage mainPage = new MainPage();
    Topmenu topMenu = new Topmenu();

    @BeforeEach
    public void initSettings() {
        Configuration.browserSize = "1920x1080";
        Configuration.timeout = 10000;
        baseUrl = "https://kinash.ru";
        open(baseUrl);
    }

    @Test
    public void searchTest() {
        mainPage.setRequest("Мяч волейбольный");
        mainPage.search();
        mainPage.selectFirstResult();
        mainPage.checkCardHeadline();
    }

    @RetryingTest(maxAttempts = 3)
    public void addToCartTest() {
        open("/catalog");
        mainPage.openFirstCatalogProduct();
        mainPage.addToCart();
        mainPage.checkCartCounter("1");
        sleep(5000);
    }

    @RetryingTest(maxAttempts = 3)
    void checkFooterPresence() {
        $("footer").scrollIntoView(true).shouldBe(visible);
    }

    @RetryingTest(maxAttempts = 3)
    void navigateToMenuPageTest() {
        mainPage.clickMenu("Волейбол");
        mainPage.checkCardHeadline(GeneralMenu.VOLLEYBALL);
    }

    @RetryingTest(maxAttempts = 3)
    void clearCartTest() {
        open("/catalog");
        mainPage.openFirstCatalogProduct();
        mainPage.addToCart();
        mainPage.clearCart();
        mainPage.checkCartCounter("0");
    }

    @RetryingTest(maxAttempts = 3)
    public void addToWishlistTest() {
        mainPage.clickMenu("Обувь");
        mainPage.openFirstCatalogProduct();
        $("div.block-wish-mini span").click();
        mainPage.checkBelongingToWishlist();
    }

    @RetryingTest(maxAttempts = 3)
    public void filterTest() {
        mainPage.clickMenu("Одежда");
        String brand = $$("form[name=catalogFilterForm] div.catalog-filter-block:nth-child(2) div.catalog-filter-row").first().getText();
        $$("form[name=catalogFilterForm] div.catalog-filter-block:nth-child(2) div.catalog-filter-row").first().click();
        mainPage.applyFilter();
        $$("div[data-name=productViewCatalog] div.products-view-block").should(CollectionCondition.allMatch(
                "Все элементы должны содержать brand",
                el -> el.getText().contains(brand)));
    }

    @RetryingTest(maxAttempts = 3)
    public void topMenuNegativTest() {
        topMenu.clickTopMenu("Контакты");
        $("h1").shouldHave(text("Контакты - спортивный магазин Кинаш Кроссовки"));
    }
}

