package com.roche.selenium.managament;

import com.roche.selenium.utilis.Screenshot;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.TestWatcher;

import java.util.Optional;

public class TestResults implements TestWatcher {
    protected Screenshot screenshot = new Screenshot();

    @Override
    public void testSuccessful(ExtensionContext context) {
    }

    @Override
    public void testFailed(ExtensionContext context, Throwable cause) {
    }

    @Override
    public void testDisabled(ExtensionContext context, Optional<String> reason) {
    }

    @Override
    public void testAborted(ExtensionContext context, Throwable cause) {
    }
}
