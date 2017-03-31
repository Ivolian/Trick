package com.ivotai.trick.global;

/**
 * The type Global settings.
 */
public final class GlobalSettings {

    private GlobalSettings() {
    }

    private static final String BASE_URL = "http://android.reader.qq.com/v6_3_9/";

    private static final Boolean USE_STETHO = true;

    /**
     * Use stetho boolean.
     *
     * @return the boolean
     */
    public static Boolean useStetho() {
        return USE_STETHO;
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
