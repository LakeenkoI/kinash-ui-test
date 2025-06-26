package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.matchText;
import static com.codeborne.selenide.Selenide.$;

public class SearchPage extends BasePage {

    private SelenideElement firstResult = $("div.kea-products-container > div:first-child a.products-view-name-link");

    public SearchPage search() {
        searchField.setValue(request);
        searchBtn.click();
        return this;
    }

    public SearchPage selectFirstResult(){
        firstResult.click();
        return this;
    }
    @Override
    public SearchPage checkTitle() {
        title.shouldHave(matchText(".*" + request + ".*"));
        return this;
    }
    @Override
    public SearchPage setRequest(String request) {
        this.request = request;
        return this;
    }


}
