package com.telran.simple.actions;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class TestBaseActions {
    WebDriver wd;

    @BeforeMethod
    public void setUp() {

        wd = new ChromeDriver();
    }

    @AfterMethod
    public void tearDown() throws InterruptedException {

        Thread.sleep(5000);
        wd.quit();

    }

    public void click(By locator) {
        wd.findElement(locator).click();
    }

    public void type(By locator, String text) {
        if (text != null) {
            wd.findElement(locator).click();
            wd.findElement(locator).clear();
            wd.findElement(locator).sendKeys(text);
        }

    }

    public void openSite(String URL) {
        wd.get(URL);
    }

    public void back() {

        Actions action = new Actions(wd);
        action.sendKeys(Keys.BACK_SPACE).build().perform();
    }

    public boolean isTitlePresent() {

        return isElementPresent(By.xpath("//h1[@class='entry-title']"));

    }

    public boolean isElementPresent(By locator) {

        try {

            wd.findElement(locator);

            return true;

        } catch (NoSuchElementException e) {

            return false;

        }

    }

}
