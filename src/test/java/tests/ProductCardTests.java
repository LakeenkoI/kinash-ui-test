package tests;

import data.GeneralMenuElements;
import io.qameta.allure.Owner;
import io.qameta.allure.junit5.AllureJunit5;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import pages.ProductCardPage;

import static com.codeborne.selenide.Selenide.open;
import static pages.CoreElementsPage.clickGeneralMenuElements;

@ExtendWith(AllureJunit5.class)
public class ProductCardTests extends TestBase {

    ProductCardPage productCard = new ProductCardPage();

    @Test
    @DisplayName("На карточке товара отображаются отзывы и кнопка Написать отзыв")
    @Owner("lakeenkoi")
    @Tag("ProductCart")
    public void checkReviewsSection() {
        open(nikeTShirtUrl);
        productCard.scrollToReviews()
                .clickReviewsTab()
                .checkReviewButtonVisible();
    }
    @Test
    @DisplayName("На карточке товара в характеристиках отображается поле Пол")
    @Owner("lakeenkoi")
    @Tag("ProductCart")
    public void checkProductCharacteristics() {
        clickGeneralMenuElements(GeneralMenuElements.FOOTWEAR);
        productCard.clickFirstProduct()
                .clickCharacteristicsTab()
                .checkGenderCharacteristicPresent();
    }
}
