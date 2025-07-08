package com.lakeenko.tests.smoke;

import com.lakeenko.tests.TestBase;
import io.qameta.allure.Feature;
import io.qameta.allure.Link;
import io.qameta.allure.Owner;
import io.qameta.allure.Story;
import io.qameta.allure.junit5.AllureJunit5;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;


@ExtendWith(AllureJunit5.class)
@Link(name = "https://kinash.ru/", url = "https://kinash.ru/")
@Owner("LakeenkoI")
@Feature("Kinash")
@Story("Главная страница")
@Tag("Main")
@Tag("Smoke")
public class MainPageTests extends TestBase {

    @Test
    @DisplayName("На главной странице отображаются: корзина, футтер, лого, тайтл")
    public void mainPageElementsTest() {
        mainPage.openSite()
                .checkMainPageElements();
    }
}