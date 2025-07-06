package com.lakeenko.tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import com.lakeenko.config.WebDriverConfig;
import com.lakeenko.extensions.FailedResultListenerExtension;
import com.lakeenko.listeners.CustomSelenideListener;
import com.lakeenko.pages.*;
import io.qameta.allure.selenide.AllureSelenide;
import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.util.HashMap;
import java.util.Map;

import static com.codeborne.selenide.Configuration.baseUrl;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;

@ExtendWith(FailedResultListenerExtension.class)
public class TestBase {

    protected CartPage cartPage = new CartPage();
    protected FilterPage filterPage = new FilterPage();
    protected MainPage mainPage = new MainPage();
    protected ProductCardPage productCard = new ProductCardPage();
    protected SearchPage searchPage = new SearchPage();

    private static WebDriverConfig webDriverConfig = ConfigFactory.create(WebDriverConfig.class, System.getProperties());
    public static String nikeTShirtUrl;

    @BeforeAll
    static void setup() {
        Configuration.timeout = 7000;
        Configuration.browser = System.getProperty("browser", webDriverConfig.browser());
        Configuration.browserVersion = System.getProperty("browserVersion", webDriverConfig.browserVersion());
        Configuration.browserSize = System.getProperty("browserSize", webDriverConfig.browserSize());
        Configuration.baseUrl = webDriverConfig.baseUrl();
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());
        nikeTShirtUrl = baseUrl + "/products/nike-dri-fit-uv-miler-short-sleave-running-top-futbolka-begovaya-chernyi";

        boolean isRemote = Boolean.parseBoolean(System.getProperty("isRemote", String.valueOf(webDriverConfig.isRemote())));
        if (isRemote) {
            DesiredCapabilities capabilities = new DesiredCapabilities();

            Map<String, Object> selenoidOptions = new HashMap<>();
            selenoidOptions.put("enableVNC", true);
            selenoidOptions.put("enableVideo", true);
            capabilities.setCapability("selenoid:options", selenoidOptions);

            Configuration.browserCapabilities = capabilities;
            Configuration.remote = webDriverConfig.remoteUrl();
        }
        CustomSelenideListener.register();
    }

    @BeforeEach
    public void openSite() {
        step("Открываем основную страницу сайта", () -> {
            open(baseUrl);
        });
    }
}
