package com.roche;

import com.roche.selenium.pagefactory.Base;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebElement;

import java.util.List;

public class ToDoMVCTest extends Base {

    @Tag("roche")
    @Test
    @DisplayName("live codding")
    public void test_01() {
        List<WebElement> items =
                homePage()
                        .open()
                        .newTodo("test_1")
                        .approvedItem()
                        .newTodo("test_2")
                        .approvedItem()
                        .newTodo("test_3")
                        .approvedItem()
                        .getAllAddedItems();

        Assertions.assertEquals(3, items.size());
    }
}
