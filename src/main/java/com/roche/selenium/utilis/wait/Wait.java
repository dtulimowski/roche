package com.roche.selenium.utilis.wait;

import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class Wait {
    private List<Class<? extends Throwable>> exceptionsToIgnore = new ArrayList<>();
    private Duration duration = Duration.ofMillis(500);
    private String exceptionInfo;
    private Duration timeout = Duration.ofSeconds(5);
    private boolean throwException = true;
    private WebDriver driver;

    public Wait(WebDriver driver) {
        this.driver = driver;
    }

    public Wait ignoring(Class<? extends Throwable> exception) {
        exceptionsToIgnore.add(exception);
        return this;
    }

    public Wait pollingEvery(Duration duration) {
        this.duration = duration;
        return this;
    }

    public Wait withExceptionMessage(String message) {
        this.exceptionInfo = message;
        return this;
    }

    public Wait withTimeout(Duration timeout) {
        this.timeout = timeout;
        return this;
    }

    public Wait withoutException(boolean withoutException) {
        throwException = !withoutException;
        return this;
    }

    @Deprecated
    public <T> T until(boolean throwTimeout, int timeout, ExpectedCondition<T> condition) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, timeout);
            exceptionsToIgnore.forEach(wait::ignoring);
            wait.pollingEvery(duration);

            if (exceptionInfo != null)
                wait.withMessage(exceptionInfo);

            return wait.until(condition);
        } catch (TimeoutException e) {
            if (throwTimeout)
                throw e;
            else {
                return null;
            }
        } finally {
            exceptionsToIgnore = new ArrayList<>();
            exceptionsToIgnore.add(WebDriverException.class);
            duration = Duration.ofMillis(500);
            exceptionInfo = null;
        }
    }

    public <T> T until(ExpectedCondition<T> condition) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, timeout.getSeconds());
            exceptionsToIgnore.forEach(wait::ignoring);
            wait.pollingEvery(duration).withTimeout(timeout);

            if (exceptionInfo != null)
                wait.withMessage(exceptionInfo);

            return wait.until(condition);
        } catch (TimeoutException e) {
            if (throwException)
                throw e;
            else {
                return null;
            }
        } finally {
            exceptionsToIgnore = new ArrayList<>();
            exceptionsToIgnore.add(WebDriverException.class);
            duration = Duration.ofMillis(500);
            exceptionInfo = null;
        }
    }

    public void sleep(int seconds) {
        try {
            Thread.sleep(seconds * 1000);
        } catch (InterruptedException ignore) {
        }
    }
}
