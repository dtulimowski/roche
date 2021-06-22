package com.roche.selenium.annotations;

import com.roche.selenium.managament.TestsManagement;
import org.junit.jupiter.api.extension.ExtendWith;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@ExtendWith(TestsManagement.class)
@TestManager
public @interface TestManager {
}
