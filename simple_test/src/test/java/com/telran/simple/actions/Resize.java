package com.telran.simple.actions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class Resize extends TestBaseActions {

    @Test
    public void testResize(){

        wd.get("http://localhost/tests/resize.html");
        WebElement resizeButton = wd.findElement(By.cssSelector(".ui-resizable-se"));
        new Actions(wd).clickAndHold(resizeButton).moveByOffset(400,250).release().perform();
    }
}
