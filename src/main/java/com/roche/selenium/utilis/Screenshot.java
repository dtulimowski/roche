package com.roche.selenium.utilis;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.util.Optional;

public class Screenshot {
    private byte[] allureScreenshot;

    public void isScreenshotRequired(WebDriver driver, ExtensionContext context) {
        Optional<Throwable> executionException = context.getExecutionException();
        if(executionException.isPresent()) {
            TakesScreenshot takesScreenshot = (TakesScreenshot)driver;
            allureScreenshot = takesScreenshot.getScreenshotAs(OutputType.BYTES);
        }
    }

    public void addScreenshotToAllure() {
    }
}
