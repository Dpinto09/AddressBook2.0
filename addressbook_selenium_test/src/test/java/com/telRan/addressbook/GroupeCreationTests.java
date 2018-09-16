package com.telRan.addressbook;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class GroupeCreationTests {

    WebDriver wd;

    @BeforeClass
    public void setUp(){

        wd = new ChromeDriver();
        wd.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        wd.get("http://localhost/addressbook/");

        Login("admin", "secret");

    }

    @Test

    public void testGroupCreation(){

        GoToGroup();
        CreateNewGroupe();
        FillNameGroup("Suicide Squad");
        SubmitGroup();

        GoToGroup();

        DeleteGroup();

    }

    public void DeleteGroup() {
        click(By.xpath("//input[@title='Select (Suicide Squad)']"));
        click(By.name("delete"));
    }

    public void SubmitGroup() {
        click(By.name("submit"));
    }

    public void FillNameGroup(String text) {
        type(By.name("group_name"), text);
    }

    public void CreateNewGroupe() {
        click(By.name("new"));
    }

    public void GoToGroup() {
        click(By.xpath("//a[@href='group.php']"));
    }

    @AfterClass
    public void tearDown(){

        wd.quit();
    }
    public void Login(String userName, String password) {
        type(By.name("user"), userName);

        type(By.name("pass"), password);

        click(By.xpath("//*[@type='submit']"));
    }

    public void click(By locator) {
        wd.findElement(locator).click();
    }

    public void type(By locator, String text) {
        click(locator);
        wd.findElement(locator).clear();
        wd.findElement(locator).sendKeys(text);
    }
}
