package tests;

import org.junit.jupiter.api.Test;
import pages.MainPage;

import static com.codeborne.selenide.Selenide.open;

public class MainPageTests {

    @Test
    public void mainPageElementsTest() {
        MainPage page = open("https://kinash.ru/", MainPage.class);
        page.checkMainPageElements();
    }
}