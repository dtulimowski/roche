package com.roche.selenium.pagefactory.homepage;


import com.roche.selenium.constants.Constants;
import com.roche.selenium.utilis.wait.FluentWait;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;
import java.util.stream.Collectors;

public class HomePage {
    private WebDriver driver;

    private FluentWait fluentWait;

    @FindBy(className = "new-todo")
    private WebElement newTodo;

    @FindBy(className = "todo-list")
    private WebElement todoList;

    public HomePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
        fluentWait = new FluentWait();
    }

    public HomePage open() {
        driver.get(Constants.URL);
        return new HomePage(driver);
    }

    public HomePage newTodo(String text) {
        fluentWait.pollingUntilElementToBeClickable(500,3, newTodo);
        newTodo.sendKeys(text);
        return this;
    }
    public HomePage approvedItem() {
        newTodo.sendKeys(Keys.ENTER);
        return this;
    }
    public List<WebElement> getAllAddedItems() {
        List<WebElement> addedItems = todoList.findElements(By.className("toggle"));
        return addedItems
                .stream()
                .filter(item -> item.getAttribute("ng-model").contains("completed"))
                .collect(Collectors.toList());
    }

}
