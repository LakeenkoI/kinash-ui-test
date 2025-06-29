package extensions;

import org.junit.jupiter.api.extension.*;
import org.opentest4j.TestAbortedException;

import java.lang.reflect.Method;

public class RetryTestExtension implements TestExecutionExceptionHandler, BeforeTestExecutionCallback {

    private static final ExtensionContext.Namespace NAMESPACE = ExtensionContext.Namespace.create("retry");

    @Override
    public void beforeTestExecution(ExtensionContext context) {
        context.getStore(NAMESPACE).put("retries", 0);
    }

    @Override
    public void handleTestExecutionException(ExtensionContext context, Throwable throwable) throws Throwable {
        Method testMethod = context.getRequiredTestMethod();
        Retry retryAnnotation = testMethod.getAnnotation(Retry.class);

        if (retryAnnotation == null) {
            throw throwable;
        }

        int maxRetries = retryAnnotation.value();
        ExtensionContext.Store store = context.getStore(NAMESPACE);
        int retries = store.get("retries", Integer.class);

        if (retries < maxRetries) {
            store.put("retries", retries + 1);
            context.getRequiredTestInstance();
            throw new TestAbortedException("Retrying test: " + (retries + 1) + "/" + maxRetries);
        } else {
            throw throwable;
        }
    }
}
