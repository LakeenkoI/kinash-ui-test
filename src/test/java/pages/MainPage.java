package pages;

import com.codeborne.selenide.ElementsCollection;
import lombok.*;
import org.junit.jupiter.api.Assertions;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class MainPage {


    ElementsCollection menuGeneral = $$("ul.menu-general li ");
    private String request;

    public void clickMenu(String displayName) {
        menuGeneral.findBy(text(displayName)).click();
    }

    public void search() {
        $("[placeholder='Поиск']").setValue(request);
        $("a.kea-button-viewall").click();
    }

    public void selectFirstResult() {
        $("div.kea-products-container > div:first-child a.products-view-name-link").click();
    }

    public void checkCardHeadline() {
        $("h1").shouldHave(text(request));
    }

    public void checkCardHeadline(GeneralMenu menuItem) {
        $("h1").shouldHave(text(menuItem.getHeadText()));
    }

    public void openFirstArticle() {
        $$(".post-title").first().click();
    }

    public void addToCart() {
        $("div.buy-buttons-block a.btn-confirm").click();
        $("a.btn.btn-middle.btn-buy").click();
    }

    public void clearCart() {
        $("a[title='Очистить корзину']").click();
    }

    public void checkCartCounter(String expectedCount) {
        $(".cart-amount-custom").shouldHave(text(expectedCount));
    }

    public void openFirstCatalogProduct() {
        $$("div.products-view-tile div").first().click();
    }

    public void checkBelongingToWishlist() {
        String wishlistAttribute = $("div.start-whishlist span").getText();
        Assertions.assertEquals("В избранном", wishlistAttribute);
    }

    public void applyFilter() {
        $("input[value='Применить']").click();
    }
}
