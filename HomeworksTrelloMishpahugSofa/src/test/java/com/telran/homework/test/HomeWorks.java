package com.telran.homework.test;

import com.telran.homework.model.LoginData;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import java.util.List;

public class HomeWorks extends TestBase {

    @Test
    public void testAddPictureEventMishpaHug() throws InterruptedException {

        openSite("https://mish.sheygam.com/#/wellcome");
        clickOnLogin();
        wait3000();
        fillLoginForm(new LoginData().setEmail("dvd.090909@gmail.com").setPassword("123456789"));
        submitLogin();
        wait3000();
        goToProfile();
        wait3000();
        if (isInProfilePage()) {
            wait3000();
            modifyProfile();
            wait3000();
            insertEventPicture();
            wait3000();
            saveProfile();

        }
    }

    @Test
    public void testAddPictureProfileMishpaHug() throws InterruptedException {

        openSite("https://mish.sheygam.com/#/wellcome");
        clickOnLogin();
        wait3000();
        fillLoginForm(new LoginData().setEmail("dvd.090909@gmail.com").setPassword("123456789"));
        wait3000();
        goToProfile();
        wait3000();
        if (isInProfilePage()) {
            wait3000();
            modifyProfile();
            wait3000();
            insertProfilePicture();
            wait3000();
            saveProfile();

        }
    }

    @Test
    public void testMoveToElementTrello() throws InterruptedException {

        openSite("https://trello.com");
        wait3000();
        loginUserWithFields(new LoginData().setEmail("bouchard.pintodavid@gmail.com").setPassword("Basketball09"));

        buttonHomeLeftSideMenu();
        wait3000();
        fillNewBoardFormWithoutTeam("DragAndDropNote");
        //fillNewBoardFormWithTeam("DragAndDropNote");
        addList("List1");
        wait3000();
        addNewList("List2");
        wait3000();
        addCardInFirstList("Card1");
        wait3000();
        addAnotherCardInFirstList("Card2");
        wait3000();
        addNewCardInSecondList("Card3");
        wait3000();
        addAnotherCardButtonInSecondList("Card4");

        WebElement List1 = wd.findElement(By.xpath("//div[@class='js-list list-wrapper'][1]"));

        List<WebElement> cardsList1 = List1.findElements(By.cssSelector(".list-card"));

        for(WebElement cardTitle: cardsList1){

            System.out.println(cardTitle.getText());
        }

        WebElement firstCard = wd.findElement(By.xpath("//div[@id='board']/div[1]/div[1]/div[2]/a[1]"));
        WebElement list2 = wd.findElement(By.xpath("//div[@id='board']//div[2]//div[1]//div[@class='list-cards u-fancy-scrollbar u-clearfix js-list-cards js-sortable ui-sortable']"));
        new Actions(wd).dragAndDrop(firstCard, list2).release().perform();

        WebElement List2 = wd.findElement(By.xpath("//div[@class='js-list list-wrapper'][2]"));
        List<WebElement> cardsList2 = List2.findElements(By.cssSelector(".list-card"));
        for(WebElement cardTitle: cardsList2){

            System.out.println(cardTitle.getText());
        }
    }

    public void addNewCardInSecondList(String cardTitle) {

        addCardButton();
        type(By.xpath("//textarea[@placeholder='Enter a title for this card…']"), cardTitle);
        click(By.xpath("//input[@value='Add Card']"));
        click(By.xpath("//a[@class='icon-lg icon-close dark-hover js-cancel']"));
    }

    public void addAnotherCardInFirstList(String cardTitle) {
        addAnotherCardButtonInFirstList();
        type(By.xpath("//textarea[@placeholder='Enter a title for this card…']"), cardTitle);
        click(By.xpath("//input[@value='Add Card']"));
        click(By.xpath("//a[@class='icon-lg icon-close dark-hover js-cancel']"));
    }

    public void addAnotherCardButtonInSecondList(String cardTitle) {

        click(By.xpath("//div[@id='board']//div[2]//div[1]//a[1]//span[@class='js-add-another-card']"));
        type(By.xpath("//textarea[@placeholder='Enter a title for this card…']"), cardTitle);
        click(By.xpath("//input[@value='Add Card']"));
        click(By.xpath("//a[@class='icon-lg icon-close dark-hover js-cancel']"));
    }

    public void addAnotherCardButtonInFirstList() {
        click(By.xpath("//div[@id='board']//div[1]//div[1]//a[1]//span[@class='js-add-another-card']"));
    }

    public void addCardInFirstList(String cardTitle) {
        addCardButton();
        type(By.xpath("//textarea[@placeholder='Enter a title for this card…']"), cardTitle);
        click(By.xpath("//input[@value='Add Card']"));
        click(By.xpath("//a[@class='icon-lg icon-close dark-hover js-cancel']"));
    }

    public void addCardButton() {
        click(By.xpath("//span[@class='js-add-a-card']"));
    }


}
