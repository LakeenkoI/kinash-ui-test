package com.lakeenko.listeners;

import com.codeborne.selenide.ex.ElementNotFound;
import com.codeborne.selenide.logevents.LogEvent;
import com.codeborne.selenide.logevents.LogEventListener;
import com.lakeenko.exceptions.CustomElementNotFoundException;
import io.qameta.allure.Allure;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
public class CustomSelenideListener implements LogEventListener {

    private final Map<LogEvent, Long> timers = new ConcurrentHashMap<>();

    @Override
    public void beforeEvent(LogEvent event) {
        Allure.step("🔹 " + event.getSubject() + " → " + event.getElement());
        System.out.println("➡️ Selenide step: " + event.getSubject() + " → " + event.getElement());
    }

    @Override
    public void afterEvent(LogEvent event) {
        Throwable error = event.getError();
        if (error instanceof ElementNotFound) {
            String action = event.getSubject();
            String locator = event.getElement();
            String message = error.getMessage().split("\\r?\\n")[0];

            throw new CustomElementNotFoundException(action, locator, message);
        }
    }
}