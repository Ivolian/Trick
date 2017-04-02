package com.ivotai.trick.app;

/**
 * The type App settings.
 */
public final class AppSettings {

    private AppSettings() {
    }

    private static final String BASE_URL = "http://android.reader.qq.com/v6_3_9/";

    /**
     * Base url string.
     *
     * @return the string
     */
    public static String baseUrl() {
        return BASE_URL;
    }

}
