package com.roche.selenium.browser;

import com.roche.selenium.constants.Constants;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.SessionNotCreatedException;
import org.openqa.selenium.WebDriver;

import java.util.ConcurrentModificationException;
import java.util.HashMap;

public class Driver {
    private static final HashMap<Thread, WebDriver> sessions = new HashMap<>();

    static {
        Runtime.getRuntime().addShutdownHook(new Thread(Driver::clean));
        setSystemPathToDrivers();
    }

    private static void clean() {
        try {
            sessions.keySet().forEach(Driver::closeSession);
        } catch (ConcurrentModificationException ignore) {
            //the exception is thrown when one instance is closed concurrently by Shutdown Hook and this method
        }
    }

    public static void closeSession(Thread thread) {
        WebDriver driver = sessions.get(thread);
        if (driver != null) {
            try {
                driver.quit();
            } catch (Exception ignore) {}
        }
        sessions.remove(thread);
    }

    private static void setSystemPathToDrivers() {
        switch(Constants.BROWSER_NAME) {
            case "CHROME":
                WebDriverManager.chromedriver().setup();
            break;
            case "FIREFOX":
                WebDriverManager.firefoxdriver().setup();
            break;
            default: throw new SessionNotCreatedException("No such driver found");
        }
    }

    public static WebDriver get() {
        Thread thread = Thread.currentThread();
        WebDriver driver = sessions.get(Thread.currentThread());
        if(driver != null) {
            return driver;
        } else {
            driver = new WebDriverFactory().getDriver();
        }
        sessions.put(thread, driver);
        return driver;
    }
}
