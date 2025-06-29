package listeners;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.TestWatcher;
import static helpers.Attach.*;

public class AllureListener implements TestWatcher {

    @Override
    public void testFailed(ExtensionContext context, Throwable cause) {
        screenshotAs("Last screenshot");
        pageSource();
        browserConsoleLogs();
        addVideo();
    }

    @Override
    public void testSuccessful(ExtensionContext context) {

    }
}