package tests;

import extensions.Retry;
import io.qameta.allure.junit5.AllureJunit5;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import pages.MainPage;


@ExtendWith(AllureJunit5.class)
public class MainPageTests extends TestBase {

    @Retry(3)
    @Test
    public void mainPageElementsTest() {
        MainPage page = new MainPage();
        page.checkMainPageElements();
    }
}
