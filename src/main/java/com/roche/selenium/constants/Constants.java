package com.roche.selenium.constants;

public class Constants {
    public static final String URL = System.getProperty("url");
    public static final String BROWSER_NAME = System.getProperty("browser.name").toUpperCase();
    public static final String BROWSER_TYPE = System.getProperty("browser.type").toUpperCase();
    public static final String REMOTE_GRID = System.getProperty("remote.address");
    public static final String TMP_DIRECTORY = System.getProperty("java.io.tmpdir");
    public static final boolean HEADLESS_MODE = System.getProperty("headless").contains("true");
}
