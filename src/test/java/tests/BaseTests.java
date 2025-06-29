package tests;

import com.codeborne.selenide.Configuration;
import config.Config;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.remote.DesiredCapabilities;

public class BaseTests {

    @BeforeAll
    static void setup() {
        Configuration.browser = Config.get("browser");
        Configuration.browserVersion = Config.get("browserVersion");
        Configuration.browserSize = "1920x1080";

        String remoteUrl = Config.get("remoteUrl");
        if (remoteUrl != null && !remoteUrl.isEmpty()) {
            Configuration.remote = remoteUrl;

            DesiredCapabilities capabilities = new DesiredCapabilities();
            capabilities.setCapability("enableVNC", true);
            capabilities.setCapability("enableVideo", true);
            Configuration.browserCapabilities = capabilities;
        }
    }
}
