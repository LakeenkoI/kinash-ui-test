package com.lakeenko.exceptions;

import com.codeborne.selenide.Selenide;
import org.openqa.selenium.WebDriver;

public class CustomElementNotFoundException extends AssertionError{

    public CustomElementNotFoundException(String action, String locator, String additionalInfo) {
        super(buildMessage(action, locator, additionalInfo));
    }

    private static String buildMessage(String action, String locator, String additionalInfo) {
        String currentUrl = getCurrentUrl();
        StringBuilder sb = new StringBuilder("\n");
        sb.append("❌ ELEMENT NOT FOUND\n");
        sb.append("────────────────────────────\n");
        sb.append("🔍 Action      : ").append(action).append("\n");
        sb.append("📌 Locator     : ").append(locator).append("\n");
        sb.append("🌍 Current URL : ").append(currentUrl).append("\n");
        if (additionalInfo != null && !additionalInfo.isBlank()) {
            sb.append("💡 Info        : ").append(additionalInfo).append("\n");
        }
        sb.append("────────────────────────────\n");
        return sb.toString();
    }

    private static String getCurrentUrl() {
        try {
            WebDriver driver = Selenide.webdriver().object();
            return driver.getCurrentUrl();
        } catch (Exception e) {
            return "N/A (WebDriver not available)";
        }
    }
}