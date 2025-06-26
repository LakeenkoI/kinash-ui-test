package test.java.tests;

import io.qameta.allure.junit5.AllureJunit5;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import pages.MainPage;
import pages.ProductCardPage;

import static com.codeborne.selenide.Selenide.open;

@ExtendWith(AllureJunit5.class)
public class ProductCardTests {

    MainPage mainPage = new MainPage();
    ProductCardPage productCard = new ProductCardPage();

    @Test
    public void checkReviewsSection() {
        open("https://kinash.ru/product/volejbolnyj-myach-mikasa-v200w/");
        productCard.scrollToReviews()
                .clickReviewsTab()
                .checkReviewButtonVisible();
    }

    @Test
    public void checkProductCharacteristics() {
        open("https://kinash.ru/");
        mainPage.clickGeneralMenuElements("Обувь");
        productCard.clickFirstProduct()
                .scrollToCharacteristics()
                .clickCharacteristicsTab()
                .checkGenderCharacteristicPresent();
    }
}