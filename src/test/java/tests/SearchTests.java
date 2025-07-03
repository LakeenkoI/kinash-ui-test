package tests;

import io.qameta.allure.Owner;
import io.qameta.allure.junit5.AllureJunit5;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import pages.SearchPage;

import static com.codeborne.selenide.Selenide.$;

@ExtendWith(AllureJunit5.class)
public class SearchTests extends TestBase {

    @ParameterizedTest
    @DisplayName("В результатах поиска содержится текст запроса, или текст Ничего не найдено")
    @Owner("lakeenkoi")
    @Tag("Source")
    @CsvSource({
            "Мяч волейбольный,Мяч волейбольный",
            "?????,Ничего не найдено"
    })
    public void searchTest(String request, String expectedText) {
        SearchPage page = new SearchPage();
        page.setRequest(request)
                .search()
                .checkResults(expectedText);
    }
}
