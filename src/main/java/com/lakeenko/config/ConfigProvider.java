package com.lakeenko.config;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.aeonbits.owner.ConfigFactory;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ConfigProvider {

    public static final WebDriverConfig CONFIG;

    static {
        if (System.getProperty("env") == null) {
            System.setProperty("env", "local");
        }
        CONFIG = ConfigFactory.create(WebDriverConfig.class, System.getProperties());
    }
}