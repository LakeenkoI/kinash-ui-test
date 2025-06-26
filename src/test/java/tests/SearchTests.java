package tests;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import pages.SearchPage;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Condition.text;

public class SearchTests {

    @ParameterizedTest
    @CsvSource({
            "Мяч волейбольный,Мяч волейбольный",
            "?????,Ничего не найдено"
    })
    public void parameterizedSearchTest(String request, String expectedText) {
        SearchPage page = open("https://kinash.ru/", SearchPage.class);
        page.setRequest(request)
                .search();
        $("body").shouldHave(text(expectedText));
    }
}