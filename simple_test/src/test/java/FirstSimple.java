import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import javax.swing.*;
import java.util.List;

public class FirstSimple extends TestBase {

    @Test
    public void searchTestWithGlass() {

        openSite("https://jqueryui.com");
        typeOnSearchBox("Button");

        proceedToSearch();

        String actualText = getTextToSearch(By.cssSelector("h1 span"));

        System.out.println(actualText);

        Assert.assertEquals(actualText, "button");
    }

    @Test
    public void searchTestWithEnterVar1() {

        openSite("https://jqueryui.com");
        typeOnSearchBox("Button" + Keys.ENTER);

        String actualText = getTextToSearch(By.cssSelector("h1 span"));

        System.out.println(actualText);

        Assert.assertEquals(actualText, "button");
    }

    @Test
    public void searchTestWithEnterVar2() {

        openSite("https://jqueryui.com");
        typeOnSearchBox("Button");

        proceedToSearchWithEnter();

        String actualText = getTextToSearch(By.cssSelector("h1 span"));

        System.out.println(actualText);

        Assert.assertEquals(actualText, "button");
    }

    @Test
    public void listAllLeftMenu() {

        openSite("https://jqueryui.com");
        List<WebElement> menu = wd.findElements(By.xpath("//div[@class='widget-area']//li"));

        int sizeMenu = menu.size();
        System.out.println(sizeMenu);

        for (WebElement allLeftMenu : menu) {

            String title = allLeftMenu.getText();
            System.out.println(title);

        }
        Assert.assertEquals(sizeMenu, 31);

    }

    @Test
    public void listLeftMenuSections() {

        openSite("https://jqueryui.com");
        List<WebElement> subMenu = wd.findElements(By.xpath("//aside[@class='widget']//h3[@class='widget-title']"));

        int sizeSubMenu = subMenu.size();
        System.out.println(sizeSubMenu);

        for (WebElement sectionsLeftMenu : subMenu) {

            String title = sectionsLeftMenu.getText();
            System.out.println(title);

        }
        Assert.assertEquals(sizeSubMenu, 4);
    }

    @Test
    public void listInteractionsSection() {

        openSite("https://jqueryui.com");
        List<WebElement> interactionsSections = wd.findElements(By.xpath("//aside[1]//ul[1]//li"));

        for (int i = 1; i < interactionsSections.size(); i++) {

            WebElement pageTitle = wd.findElement(By.xpath("//aside[1]//ul[1]//li["+i+"]"));
            pageTitle.click();
            back();

        }

    }

}


