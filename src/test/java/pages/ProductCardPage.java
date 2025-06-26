package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class ProductCardPage extends BasePage {

    private final SelenideElement reviewsTab = $("a[href='#tab-reviews']");
    private final SelenideElement reviewButton = $(".write-review-btn");
    private final SelenideElement characteristicsTab = $("a[href='#tab-characteristics']");
    private final SelenideElement characteristicsSection = $("#tab-characteristics");
    private final SelenideElement firstProduct = $$("div.products-view-block").first();

    @Step("Скроллим до блока 'Отзывы'")
    public ProductCardPage scrollToReviews() {
        reviewsTab.scrollIntoView(true);
        return this;
    }

    @Step("Кликаем на таб 'Отзывы'")
    public ProductCardPage clickReviewsTab() {
        reviewsTab.shouldBe(visible).click();
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

    @Step("Скроллим до блока 'Характеристики'")
    public ProductCardPage scrollToCharacteristics() {
        characteristicsTab.scrollIntoView(true);
        return this;
    }

    @Step("Кликаем на таб 'Характеристики'")
    public ProductCardPage clickCharacteristicsTab() {
        characteristicsTab.shouldBe(visible).click();
        return this;
    }

    @Step("Проверяем наличие строки 'Пол' в характеристиках")
    public ProductCardPage checkGenderCharacteristicPresent() {
        characteristicsSection.shouldHave(text("Пол"));
        return this;
    }
}
