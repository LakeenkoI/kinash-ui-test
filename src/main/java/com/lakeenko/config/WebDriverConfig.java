package com.lakeenko.config;

import org.aeonbits.owner.Config;

@Config.Sources({
        "classpath:properties/${env}.properties",
})
public interface WebDriverConfig extends Config {
        @Key("browser")
        String browser();

        @Key("browser_size")
        String browserSize();

        @Key("browser_version")
        String browserVersion();

        @Key("baseUrl")
        String baseUrl();

        @Key("isRemote")
        Boolean isRemote();

        @Key("remoteUrl")
        String remoteUrl();
}