package com.telran.homework.test;

import com.telran.homework.model.LoginData;
import com.telran.homework.model.MishpaHug;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import java.io.File;
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
            insertEventPicture(new MishpaHug().setPhotoEvent(new File("src/test/resource/events.png")));
            confirmPicture();
            saveProfile();
            wait3000();
        }
    }

    @Test
    public void testAddPictureProfileMishpaHug() throws InterruptedException {

        openSite("https://mish.sheygam.com/#/wellcome");
        clickOnLogin();
        wait3000();
        fillLoginForm(new LoginData().setEmail("").setPassword(""));
        submitLogin();
        wait3000();
        goToProfile();
        wait3000();
        if (isInProfilePage()) {
            wait3000();
            modifyProfile();
            wait3000();
            insertProfilePicture(new MishpaHug().setPhotoProfile(new File("src/test/resources/avatar.jpg")));
            wait3000();
            confirmPicture();
            saveProfile();
            wait3000();

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
        fillNewBoardFormWithTeam("DragAndDropNote");
        addList("List1");
        wait3000();
        addNewList("List2");
        wait3000();
        addCardInFirstList("Card1");
        wait3000();
        addNewCardInFirstList("Card2");

        List<WebElement> cardsList1 = wd.findElements(By.xpath("//div[1]//div[1]//div[1]//div[1]//div[1]//div[1]//div[@class='list-cards u-fancy-scrollbar u-clearfix js-list-cards js-sortable ui-sortable']//a"));
        for (int i = 1; i <= cardsList1.size(); i++) {

            WebElement cards = wd.findElement(By.xpath("//div[1]//div[1]//div[1]//div[1]//div[1]//div[1]//div[@class='list-cards u-fancy-scrollbar u-clearfix js-list-cards js-sortable ui-sortable']//a[" + i + "]"));
            System.out.println(cards.getText());
        }
        WebElement firstCard = wd.findElement(By.xpath("//a[@style='position: relative; z-index: 0; left: 0px; top: 0px;']"));
        WebElement list2 = wd.findElement(By.xpath("//div[@id='board']/div[2]/div[1]/a[1]"));
        new Actions(wd).dragAndDrop(firstCard,list2).release().perform();


    }

    public void addNewCardInFirstList(String cardTitle) {
        click(By.xpath("//div[@id='board']//div[1]//div[1]//a[1]//span[@class='js-add-another-card']"));
        type(By.xpath("//textarea[@placeholder='Enter a title for this card…']"), cardTitle);
        click(By.xpath("//input[@value='Add Card']"));
        click(By.xpath("//a[@class='icon-lg icon-close dark-hover js-cancel']"));
    }

    public void addCardInFirstList(String cardTitle) {
        click(By.xpath("//div[@id='board']//div[1]//div[1]//a[1]//span[2]"));
        type(By.xpath("//textarea[@placeholder='Enter a title for this card…']"), cardTitle);
        click(By.xpath("//input[@value='Add Card']"));
        click(By.xpath("//a[@class='icon-lg icon-close dark-hover js-cancel']"));
    }


}
