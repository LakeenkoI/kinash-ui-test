package com.lakeenko.tests.regress;

import com.lakeenko.tests.TestBase;
import io.qameta.allure.*;
import io.qameta.allure.junit5.AllureJunit5;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

@ExtendWith(AllureJunit5.class)
@Link(name = "https://kinash.ru/", url = "https://kinash.ru/")
@Owner("LakeenkoI")
@Feature("Kinash")
@Story("Поиск")
@Tag("Search")
@Tag("Regression")
public class SearchTests extends TestBase {

    @ParameterizedTest(name = "В результатах поиска: {0} содержится ожидаемый текст: {1}")
    @CsvSource({
            "Мяч волейбольный,Мяч волейбольный",
            "?????,Ничего не найдено"
    })
    public void searchTest(@Param("Actual") String request, @Param("Expected") String expectedText) {
        mainPage.openSite();
        searchPage.setRequest(request)
                .search()
                .checkResults(expectedText);
    }
}