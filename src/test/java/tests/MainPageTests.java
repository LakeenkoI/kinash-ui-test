package tests;

import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import io.qameta.allure.Story;
import io.qameta.allure.junit5.AllureJunit5;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import pages.MainPage;


@ExtendWith(AllureJunit5.class)
@Owner("LakeenkoI")
@Story("Главная страница")
@Feature("Kinash")
@Tag("Main")
public class MainPageTests extends TestBase {

    MainPage page = new MainPage();

    @Test
    @DisplayName("На главное странице отображаются: корзина, футтер, лого, тайтл")
    public void mainPageElementsTest() {
        page.checkMainPageElements();
    }
}
