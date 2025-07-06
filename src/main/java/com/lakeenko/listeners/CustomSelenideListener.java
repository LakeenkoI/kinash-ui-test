package com.lakeenko.listeners;

import com.codeborne.selenide.ex.ElementNotFound;
import com.codeborne.selenide.logevents.LogEvent;
import com.codeborne.selenide.logevents.LogEventListener;
import com.codeborne.selenide.logevents.SelenideLogger;
import com.lakeenko.exceptions.CustomElementNotFoundException;

public class CustomSelenideListener implements LogEventListener {
    @Override
    public void beforeEvent(LogEvent event) {
        // можно логировать начало действия, если нужно
    }

    @Override
    public void afterEvent(LogEvent event) {
        Throwable error = event.getError();
        if (error instanceof ElementNotFound) {
            String action = event.getSubject();              // действие, например "should be (visible)"
            String locator = event.getElement();             // локатор строки типа "#login-button"
            String message = error.getMessage().split("\\r?\\n")[0]; // первая строка ошибки

            throw new CustomElementNotFoundException(
                    action,
                    locator,
                    message
            );
        }
    }

    public static void register() {
        SelenideLogger.addListener("custom", new CustomSelenideListener());
    }
}
