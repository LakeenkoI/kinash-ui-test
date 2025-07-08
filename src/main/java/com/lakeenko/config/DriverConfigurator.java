package com.lakeenko.config;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import com.lakeenko.listeners.CustomSelenideListener;
import io.qameta.allure.selenide.AllureSelenide;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.util.HashMap;
import java.util.Map;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class DriverConfigurator {

    private static final WebDriverConfig CONFIG = ConfigProvider.CONFIG;

    public static void configure() {
        Configuration.timeout = 7000;
        Configuration.browser = CONFIG.browser();
        Configuration.browserVersion = CONFIG.browserVersion();
        Configuration.browserSize = CONFIG.browserSize();
        Configuration.baseUrl = CONFIG.baseUrl();

        if (CONFIG.isRemote()) {
            DesiredCapabilities capabilities = new DesiredCapabilities();

            Map<String, Object> selenoidOptions = new HashMap<>();
            selenoidOptions.put("enableVNC", true);
            selenoidOptions.put("enableVideo", true);
            capabilities.setCapability("selenoid:options", selenoidOptions);
            capabilities.setBrowserName(CONFIG.browser());
            capabilities.setVersion(CONFIG.browserVersion());

            Configuration.browserCapabilities = capabilities;
            Configuration.remote = CONFIG.remoteUrl();
        }

        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());
        SelenideLogger.addListener("Custom", new CustomSelenideListener());
    }
}