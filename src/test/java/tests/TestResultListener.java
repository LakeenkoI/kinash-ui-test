package tests;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.TestWatcher;

import java.util.Optional;

import static com.codeborne.selenide.Selenide.closeWebDriver;
import static helpers.Attach.*;

public class TestResultListener implements TestWatcher {

    @Override
    public void testFailed(ExtensionContext context, Throwable cause) {
        screenshotAs("Last screenshot");
        pageSource();
        browserConsoleLogs();
        addVideo();
        closeWebDriver();
    }

    @Override
    public void testSuccessful(ExtensionContext context) {
        closeWebDriver();
    }

    @Override
    public void testAborted(ExtensionContext context, Throwable cause) {
        closeWebDriver();
    }

    @Override
    public void testDisabled(ExtensionContext context, Optional<String> reason) {
        closeWebDriver();
    }
}
