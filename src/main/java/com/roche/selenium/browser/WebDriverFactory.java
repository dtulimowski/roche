package com.roche.selenium.browser;

import com.roche.selenium.constants.Constants;
import lombok.SneakyThrows;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.URL;

public class WebDriverFactory {
    private WebDriver createFirefoxDriver() {
        return new FirefoxDriver(new ParametrizedFirefoxOptions().get());
    }

    private WebDriver createChromeDriver() {
        return new ChromeDriver(new ParametrizedChromeOptions().get());
    }

    @SneakyThrows
    private RemoteWebDriver createRemoteFirefoxDriver() {
        return new RemoteWebDriver(new URL(Constants.REMOTE_GRID), new ParametrizedFirefoxOptions().get());
    }

    @SneakyThrows
    private RemoteWebDriver createRemoteChromeDriver() {
        return new RemoteWebDriver(new URL(Constants.REMOTE_GRID), new ParametrizedChromeOptions().get());
    }

    public WebDriver getDriver() {
        WebDriver driver;
         switch (Constants.BROWSER_TYPE) {
            case "LOCAL":
                driver = Constants.BROWSER_NAME.equals("CHROME") ? createChromeDriver() : createFirefoxDriver();
                break;
            case "REMOTE":
                driver = Constants.BROWSER_NAME.equals("CHROME") ? createRemoteChromeDriver() : createRemoteFirefoxDriver();
                break;
            default: throw new WebDriverException("Browser not implemented");
       }
         return driver;
    }
}
