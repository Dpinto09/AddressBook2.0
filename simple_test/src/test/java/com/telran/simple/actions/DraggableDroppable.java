package com.telran.simple.actions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class DraggableDroppable extends TestBaseActions {


    @Test
    public void testDraggableDroppable() {

        openSite("https://jqueryui.com");
        click(By.xpath("//aside[1]//li[2]"));

        WebElement box = wd.findElement(By.cssSelector("#draggable"));
        WebElement target = wd.findElement(By.cssSelector("#droppable"));
        new Actions(wd).dragAndDrop(box, target).release().perform();


    }
}
