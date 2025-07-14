package com.lakeenko.tests;

import com.lakeenko.config.ConfigProvider;
import com.lakeenko.config.DriverConfigurator;
import com.lakeenko.extensions.FailedResultListenerExtension;
import com.lakeenko.pages.*;
import lombok.SneakyThrows;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.extension.ExtendWith;

import static com.lakeenko.helpers.AllureAttach.attachAsText;

@ExtendWith(FailedResultListenerExtension.class)
public class TestBase {

    protected CartPage cartPage = new CartPage();
    protected FilterPage filterPage = new FilterPage();
    protected MainPage mainPage = new MainPage();
    protected ProductCardPage productCard = new ProductCardPage();
    protected SearchPage searchPage = new SearchPage();

    @BeforeAll
    static void setup() {
        DriverConfigurator.configure();
        attachAsText("BrowserRun", ConfigProvider.CONFIG.browser());
    }
}
