package com.lakeenko.tests.regress;

import com.lakeenko.data.GeneralMenuElements;
import com.lakeenko.tests.TestBase;
import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import io.qameta.allure.Story;
import io.qameta.allure.junit5.AllureJunit5;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import static com.codeborne.selenide.Selenide.open;
import static com.lakeenko.pages.components.CoreElementsPage.clickGeneralMenuElements;

@ExtendWith(AllureJunit5.class)
@Owner("LakeenkoI")
@Story("Карточка товара")
@Feature("Kinash")
@Tag("ProductCart")
public class ProductCardTests extends TestBase {

    @Test
    @DisplayName("На карточке товара отображаются отзывы и кнопка Написать отзыв")
    public void checkReviewsSection() {
        open(nikeTShirtUrl);
        productCard
                .clickReviewsTab()
                .checkReviewButtonVisible();
    }
    @Test
    @DisplayName("На карточке товара в характеристиках отображается поле Пол")
    public void checkProductCharacteristics() {
        clickGeneralMenuElements(GeneralMenuElements.FOOTWEAR);
        productCard.clickFirstProduct()
                .clickCharacteristicsTab()
                .checkGenderCharacteristicPresent();
    }
}
