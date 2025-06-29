package tests;

import extensions.Retry;
import io.qameta.allure.junit5.AllureJunit5;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import pages.SearchPage;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;

@ExtendWith(AllureJunit5.class)
public class SearchTests extends TestBase {

    @ParameterizedTest
    @CsvSource({
            "Мяч волейбольный,Мяч волейбольный",
            "?????,Ничего не найдено"
    })
    @Retry(3)
    public void parameterizedSearchTest(String request, String expectedText) {
        SearchPage page = new SearchPage();
        page.setRequest(request)
                .search();
        $("body").shouldHave(text(expectedText));
    }
}
