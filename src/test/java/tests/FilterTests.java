package test.java.tests;

import io.qameta.allure.junit5.AllureJunit5;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junitpioneer.jupiter.RetryingTest;
import pages.FilterPage;
import pages.MainPage;

import static com.codeborne.selenide.Selenide.open;

@ExtendWith(AllureJunit5.class)
public class FilterTests {

    MainPage mainPage = new MainPage();
    FilterPage filterPage = new FilterPage();

    @RetryingTest(maxAttempts = 3)
    public void filterTest() {
        open("https://kinash.ru/");
        mainPage.clickGeneralMenuElements("Одежда");
        String brand = filterPage.getFirstBrandName();
        filterPage.selectFirstBrand()
                .applyFilter()
                .checkProductsContainBrand(brand);
    }
}