package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;


public class MainPage extends BasePage {

    SelenideElement mainPageTitle = $("div.col-xs-slim div[style]");
    SelenideElement logo = $("#logo");
    SelenideElement footer = $("footer");

    public void checkMainPageElements() {
        mainPageTitle.shouldBe(visible);
        logo.shouldBe(visible);
        footer.scrollIntoView(true).shouldBe(visible);
    }
}
