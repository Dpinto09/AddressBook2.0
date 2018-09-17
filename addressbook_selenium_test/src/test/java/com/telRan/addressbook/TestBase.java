package com.telRan.addressbook;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.util.concurrent.TimeUnit;

public class TestBase {
    WebDriver wd;

    @BeforeClass
    public void setUp() {
        wd = new ChromeDriver();
        wd.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);

        wd.get("http://localhost/addressbook/index.php");

        login("admin", "secret");
    }

    @AfterClass
    public void tearDown() {
        wd.quit();
    }

    public void returnToGroupsPage() {
        click(By.cssSelector("i a"));

    }

    public void confirmNewGroupCreation() {
        click(By.name("submit"));
    }

    public void fillGroupForm(String groupName, String groupHeader, String groupFooter) {
        type(By.name("group_name"), groupName);
        type(By.name("group_header"), groupHeader);
        type(By.name("group_footer"), groupFooter);


    }

    public void initNewGroupCreation() {
        click(By.name("new"));
    }

    public void openGroupPage() {
        click(By.xpath("//a[@href='group.php']"));
    }

    public void login(String userName, String password) {
        type(By.name("user"), userName);
        type(By.name("pass"), password);

        click(By.xpath("//*[@type='submit']"));

    }

    public void click(By locator) {
        wd.findElement(locator).click();
    }

    public void type(By locator, String text) {
        wd.findElement(locator).click();
        wd.findElement(locator).clear();
        wd.findElement(locator).sendKeys(text);
    }

    public void confirmGroupModification() {

        click(By.name("update"));
    }

    public void initGroupModification() {

        click(By.name("edit"));
    }

    public void selectGroup() {

        click(By.name("selected[]"));
    }

    public void deleteGroup() {

        click(By.name("delete"));
    }
}
