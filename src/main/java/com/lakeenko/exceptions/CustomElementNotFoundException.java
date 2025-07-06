package com.lakeenko.exceptions;

import com.codeborne.selenide.Selenide;
import org.openqa.selenium.WebDriver;

public class CustomElementNotFoundException extends AssertionError{

    public CustomElementNotFoundException(String action, String locator, String additionalInfo) {
        super(buildMessage(action, locator, additionalInfo));
    }

    private static String buildMessage(String action, String locator, String additionalInfo) {
        String currentUrl = getCurrentUrl();
        return "\n" +
                "┌───────────────────────────────────────────────────────────────┐\n" +
                "│                       ❌ ELEMENT NOT FOUND                    │\n" +
                "├───────────────────────────────────────────────────────────────┤\n" +
                "│ 🔍 Action        : " + action + "\n" +
                "│ 📌 Locator       : " + locator + "\n" +
                "│ 🌍 Current URL   : " + currentUrl + "\n" +
                (additionalInfo != null && !additionalInfo.isBlank() ?
                        "│ 💡 Info          : " + additionalInfo + "\n" : "") +
                "└───────────────────────────────────────────────────────────────┘\n";
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
