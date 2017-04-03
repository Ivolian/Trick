package com.ivotai.trick.app;


/**
 * The type App config.
 * APP全局配置
 */
public final class AppConfig {

    private AppConfig() {
    }

    private static final String BASE_REQUEST_URL = "http://android.reader.qq.com/v6_3_9/";

    private static final String BASE_COVER_URL = "http://wfqqreader.3g.qq.com/cover/";

    /**
     * Base request url string.
     *
     * @return the string
     */
    static String baseRequestUrl() {
        return BASE_REQUEST_URL;
    }


    /**
     * Base cover url string.
     *
     * @return the string
     */
    public static String baseCoverUrl() {
        return BASE_COVER_URL;
    }

}
