package com.telRan.addressbook.manager;

import com.telRan.addressbook.model.GroupData;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class ApplicationManager {


    WebDriver wd;

    private GroupHelper groupHelper;
    private ContactHelper contactHelper;
    private SessionHelper sessionHelper;
    private NavigationHelper navigationHelper;


    public void createGroup() {

        groupHelper.initNewGroupCreation();
        groupHelper.fillGroupForm(new GroupData().withGroupFooter("FOOTER1").withGroupHeader("HEADER1").withGroupName("NAME1"));
        groupHelper.confirmNewGroupCreation();

    }

    public boolean isGroupPresent() {

        return isElementPresent(By.name("selected[]"));
    }

    public boolean isElementPresent(By locator) {
        try {
            wd.findElement(locator);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    public void selectByIndex(int i) {
        wd.findElements(By.name("selected[]")).get(i).click();

    }

    public void openHome() {
        groupHelper.click(By.xpath("//a[@href='./']"));
    }

    public void start() {
        wd = new ChromeDriver();
        wd.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        navigationHelper = new NavigationHelper(wd);
        navigationHelper.openSite("http://localhost/addressbook/index.php");
        
        sessionHelper = new SessionHelper(wd);

        sessionHelper.login("admin", "secret");
        groupHelper = new GroupHelper(wd);
        contactHelper = new ContactHelper(wd);


    }


    public void stop() {
        wd.quit();
    }

    public GroupHelper getGroupHelper() {
        return groupHelper;
    }

    public ContactHelper getContactHelper() {
        return contactHelper;
    }

    public NavigationHelper getNavigationHelper() {

        return navigationHelper;
    }
}
