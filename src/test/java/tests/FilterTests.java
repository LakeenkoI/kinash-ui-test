package tests;

import data.GeneralMenuElements;
import extensions.Retry;
import io.qameta.allure.junit5.AllureJunit5;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junitpioneer.jupiter.RetryingTest;
import pages.FilterPage;
import pages.MainPage;

@ExtendWith(AllureJunit5.class)
public class FilterTests extends BaseTests {

    MainPage mainPage = new MainPage();
    FilterPage filterPage = new FilterPage();
    @Retry(3)
    @Test
    public void filterTest() {
        mainPage.clickGeneralMenuElements(GeneralMenuElements.CLOTHING);
        String brand = filterPage.getFirstBrandName();
        filterPage.selectFirstBrand()
                .applyFilter()
                .checkProductsContainBrand(brand);
    }
}
