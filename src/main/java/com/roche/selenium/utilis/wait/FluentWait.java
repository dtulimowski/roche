package com.roche.selenium.utilis.wait;

import com.roche.selenium.browser.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.time.Duration;

public class FluentWait extends Wait {
    public FluentWait() {
        super(Driver.get());
    }

    public void pollingUntilVisibilityOfElement(int seconds, int timeout, By locator ) {
        pollingEvery(Duration.ofSeconds(seconds))
                .withTimeout(Duration.ofSeconds(timeout))
                .until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public void pollingUntilVisibilityOfElement(int seconds, int timeout, WebElement locator) {
        pollingEvery(Duration.ofSeconds(seconds))
                .withTimeout(Duration.ofSeconds(timeout))
                .until(ExpectedConditions.visibilityOf(locator));
    }

    public void pollingUntilInvisibilityOfAllElement(int seconds, int timeout, By locator ) {
        pollingEvery(Duration.ofSeconds(seconds))
                .withTimeout(Duration.ofSeconds(timeout))
                .until(ExpectedConditions.invisibilityOfElementLocated(locator));
    }

    public void pollingUntilInvisibilityOfElement(int seconds, int timeout, WebElement locator) {
        pollingEvery(Duration.ofSeconds(seconds))
                .withTimeout(Duration.ofSeconds(timeout))
                .until(ExpectedConditions.invisibilityOf(locator));
    }


    public void pollingUntilInvisibilityOfAllElement(int seconds, int timeout, WebElement locator) {
        pollingEvery(Duration.ofSeconds(seconds))
                .withTimeout(Duration.ofSeconds(timeout))
                .until(ExpectedConditions.invisibilityOfAllElements(locator));
    }

    public void pollingUntilElementToBeClickable(int milliseconds, int timeout, WebElement locator ) {
        pollingEvery(Duration.ofMillis(milliseconds))
                .withTimeout(Duration.ofSeconds(timeout))
                .until(ExpectedConditions.elementToBeClickable(locator));
    }

    public void pollingUntilElementToBeClickable(int milliseconds, int timeout, By locator ) {
        pollingEvery(Duration.ofMillis(milliseconds))
                .withTimeout(Duration.ofSeconds(timeout))
                .until(ExpectedConditions.elementToBeClickable(locator));
    }

    public FluentWait pollingUntil(int seconds, int timeout) {
        pollingEvery(Duration.ofSeconds(seconds))
                .withTimeout(Duration.ofSeconds(timeout));
        return this;
    }
}
