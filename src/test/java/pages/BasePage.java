package pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import lombok.Data;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

@Data
public class BasePage {
    protected SelenideElement searchField = $("[placeholder='Поиск']");
    protected SelenideElement searchBtn = $(".site-head-search-btn");
    protected ElementsCollection menuGeneral = $$("ul.menu-general li ");
    protected ElementsCollection menuTop = $$("div.maintopmenu div");
    protected SelenideElement cartCounter =$(".cart-amount-custom");
    protected  SelenideElement title = $("h1");
    protected String request;
    public BasePage clickGeneralMenuElements(String menuElement) {
        menuGeneral.findBy(text(menuElement)).click();
        return this;
    }

    public BasePage clickTopMenuElements(String menuElement) {
        menuTop.findBy(text(menuElement)).click();
        return this;
    }

    public BasePage checkTitle(){
        title.shouldHave(matchText(".*" + request + ".*"));
        return this;
    }

    public BasePage setRequest(String request) {
        this.request = request;
        return this;
    }



}
