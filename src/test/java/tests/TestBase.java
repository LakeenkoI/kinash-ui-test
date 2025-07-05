package tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import config.WebDriverConfig;
import io.qameta.allure.selenide.AllureSelenide;
import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.util.HashMap;
import java.util.Map;

import static com.codeborne.selenide.Configuration.baseUrl;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;

@ExtendWith(TestResultListener.class)
public class TestBase {

    private static WebDriverConfig webDriverConfig = ConfigFactory.create(WebDriverConfig.class, System.getProperties());
    public static String nikeTShirtUrl;

    @BeforeAll
    static void setup() {
        Configuration.timeout = 7000;
        Configuration.browser = webDriverConfig.browser();
        Configuration.browserVersion = webDriverConfig.browserVersion();
        Configuration.browserSize = webDriverConfig.browserSize();
        Configuration.baseUrl = webDriverConfig.baseUrl();
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());
        nikeTShirtUrl = baseUrl + "/products/nike-dri-fit-uv-miler-short-sleave-running-top-futbolka-begovaya-chernyi";

        boolean isRemote = webDriverConfig.isRemote();
        if (isRemote) {
            DesiredCapabilities capabilities = new DesiredCapabilities();
            capabilities.setBrowserName(webDriverConfig.browser());
            capabilities.setVersion(webDriverConfig.browserVersion());

            Map<String, Object> selenoidOptions = new HashMap<>();
            selenoidOptions.put("enableVNC", true);
            selenoidOptions.put("enableVideo", true);
            capabilities.setCapability("selenoid:options", selenoidOptions);

            Configuration.browserCapabilities = capabilities;
            Configuration.remote = webDriverConfig.remoteUrl();
        }
    }

    @BeforeEach
    public void openSite() {
        step("Открываем основную страницу сайта", () -> {
            open(baseUrl);
        });
    }
}
