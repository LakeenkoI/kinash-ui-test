package com.lakeenko.data;

import com.lakeenko.config.ConfigProvider;
import lombok.experimental.UtilityClass;

@UtilityClass
public class Urls {
    public static final String NIKE_TSHIRT_URL = ConfigProvider.CONFIG.baseUrl() +
            "/products/nike-dri-fit-uv-miler-short-sleave-running-top-futbolka-begovaya-chernyi";
}