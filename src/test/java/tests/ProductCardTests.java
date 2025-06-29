package tests;

import data.GeneralMenuElements;
import extensions.Retry;
import io.qameta.allure.junit5.AllureJunit5;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import pages.MainPage;
import pages.ProductCardPage;

import static com.codeborne.selenide.Selenide.open;

@ExtendWith(AllureJunit5.class)
public class ProductCardTests extends TestBase {

    MainPage mainPage = new MainPage();
    ProductCardPage productCard = new ProductCardPage();

    @Retry(3)
    @Test
    public void checkReviewsSection() {
        open(config.baseUrl() + "/products/nike-miler-short-sleave-running-top-futbolka-begovaya-temno-sinii");
        productCard.scrollToReviews()
                .clickReviewsTab()
                .checkReviewButtonVisible();
    }
    @Retry(3)
    @Test
    public void checkProductCharacteristics() {
        mainPage.clickGeneralMenuElements(GeneralMenuElements.FOOTWEAR);
        productCard.clickFirstProduct()
                .clickCharacteristicsTab()
                .checkGenderCharacteristicPresent();
    }
}
