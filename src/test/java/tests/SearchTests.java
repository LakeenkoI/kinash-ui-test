package tests;

import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import io.qameta.allure.Story;
import io.qameta.allure.junit5.AllureJunit5;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

@ExtendWith(AllureJunit5.class)
@Owner("LakeenkoI")
@Story("Поиск")
@Feature("Kinash")
@Tag("Search")
public class SearchTests extends TestBase {

    @ParameterizedTest
    @DisplayName("В результатах поиска содержится текст запроса, или текст Ничего не найдено")
    @CsvSource({
            "Мяч волейбольный,Мяч волейбольный",
            "?????,Ничего не найдено"
    })
    public void searchTest(String request, String expectedText) {
        searchPage.setRequest(request)
                .search()
                .checkResults(expectedText);
    }
}
