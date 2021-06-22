package com.roche.selenium.managament;

import com.roche.selenium.browser.Driver;
import org.junit.jupiter.api.extension.AfterAllCallback;
import org.junit.jupiter.api.extension.AfterTestExecutionCallback;
import org.junit.jupiter.api.extension.BeforeAllCallback;
import org.junit.jupiter.api.extension.ExtensionContext;

public class TestsManagement extends TestResults implements BeforeAllCallback, AfterTestExecutionCallback, AfterAllCallback {
    @Override
    public void beforeAll(ExtensionContext context) {
        Driver.get().manage().window().maximize();
    }

    @Override
    public void afterTestExecution(ExtensionContext context) {
        screenshot.isScreenshotRequired(Driver.get(), context);
    }

    @Override
    public void afterAll(ExtensionContext context) {
        Driver.closeSession(Thread.currentThread());
    }
}
