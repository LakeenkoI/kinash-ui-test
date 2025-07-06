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

import static com.lakeenko.pages.components.CoreElementsPage.clickGeneralMenuElements;

@ExtendWith(AllureJunit5.class)
@Owner("LakeenkoI")
@Story("Фильтр")
@Feature("Kinash")
@Tag("Filter")
public class FilterTests extends TestBase {

    @Test
    @DisplayName("В названии отфильтрованных товаров содержится название бренда из фильтра")
    public void filterTest() {
        clickGeneralMenuElements(GeneralMenuElements.CLOTHING);
        String brand = filterPage.getFirstBrandName();
        filterPage.selectFirstBrand()
                .applyFilter()
                .checkProductsContainBrand(brand);
    }
}
