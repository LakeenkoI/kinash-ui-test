package config;

import org.aeonbits.owner.Config;

@Config.Sources({
        "classpath:properties/${env}.properties",
})

public interface WebDriverConfig extends Config {
        @Key("browser")
        @DefaultValue("CHROME")
        String browser();

        @Key("browser_size")
        @DefaultValue("1920x1080")
        String browserSize();

        @Key("browser_version")
        @DefaultValue("120.0")
        String browserVersion();

        @Key("baseUrl")
        @DefaultValue("https://kinash.ru/")
        String baseUrl();

        @Key("isRemote")
        @DefaultValue("false")
        Boolean isRemote();

        @Key("remoteUrl")
        @DefaultValue("http://localhost:4444")
        String remoteUrl();
}
