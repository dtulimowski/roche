package com.roche.selenium.pagefactory;

import com.roche.selenium.annotations.TestManager;
import com.roche.selenium.browser.Driver;
import com.roche.selenium.pagefactory.homepage.HomePage;

@TestManager
public class Base {
    public HomePage homePage() {
        return new HomePage(Driver.get());
    }
}
