package pages;

import com.codeborne.selenide.ElementsCollection;
import data.GeneralMenuElements;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$$;

public class CoreElementsPage {
    private static final ElementsCollection MENU_GENERAL = $$("ul.menu-general li ");

    @Step("Клик по элементу главного меню: {menuElement.displayName}")
    public static void clickGeneralMenuElements(GeneralMenuElements menuElement) {
        MENU_GENERAL.findBy(text(menuElement.getDisplayName())).click();
    }
}
