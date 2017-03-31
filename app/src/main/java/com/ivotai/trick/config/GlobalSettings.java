package com.ivotai.trick.config;

/**
 * The type Global settings.
 */
public final class GlobalSettings {

    private GlobalSettings() {
    }

    private static final Boolean DEVELOPMENT_MODE = true;

    private static final String BASE_URL = "http://android.reader.qq.com/v6_3_9/";

    /**
     * Use stetho boolean.
     *
     * @return the boolean
     */
    public static Boolean useStetho() {
        return DEVELOPMENT_MODE;
    }

    /**
     * Base url string.
     *
     * @return the string
     */
    public static String baseUrl() {
        return BASE_URL;
    }

}
