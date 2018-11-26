package com.telran.homework.test;

import com.telran.homework.model.LoginData;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.io.File;
import java.util.List;

public class TestBase {

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

    public boolean isElementPresent(By locator) {
        try {
            wd.findElement(locator);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    public boolean isInAddEventPage() {

        return isElementPresent(By.xpath("//h1[@class='titleAddEvent']"));
    }

    public void addEvent() {
        click(By.xpath("//img[@height='24']"));
    }

    public void goToEventsHomePage() {
        click(By.xpath("//span[contains(text(),'Go to Event list')]"));
    }

    public void fillLoginForm(LoginData loginData) {
        type(By.xpath("//input[@formcontrolname='email']"), loginData.getEmail() );
        type(By.xpath("//input[@formcontrolname='password']"), loginData.getPassword());
        submitLogin();

    }

    public void submitLogin() {
        click(By.xpath("//span[contains(text(),'Log in')]"));
    }

    public void type(By locator, String text) {
        if (text != null) {
            wd.findElement(locator).click();
            wd.findElement(locator).clear();
            wd.findElement(locator).sendKeys(text);
        }
    }
    public void attach(By locator, File file) {

            wd.findElement(locator).sendKeys(file.getAbsolutePath());
    }

    public void click(By locator) {
        wd.findElement(locator).click();
    }

    public void openSite(String url) {
        wd.get(url);
        wd.manage().window().maximize();
    }

    public void confirmPicture() {

        click(By.xpath("//span[contains(text(),'Ok')]"));
    }

    public void saveProfile() {

        click(By.xpath("//span[contains(text(),'Save')]"));
    }

    public void insertEventPicture() throws InterruptedException {
        click(By.xpath("//button[@class='banner']"));
         attach(By.xpath("//input[@type='file']"), new File("src/test/resources/events.png"));
         wait3000();
        confirmPicture();

    }

    public void insertProfilePicture() throws InterruptedException {

        click(By.xpath("//button[@class='avatar']"));
        attach(By.xpath("//input[@type='file']"),new File("src/test/resources/avatar.jpg"));
        wait3000();
        confirmPicture();

    }

    public void modifyProfile() {

        click(By.xpath("//span[contains(text(),'Change')]"));
    }

    public boolean isInProfilePage() {

        return isElementPresent(By.xpath("//span[contains(text(),'Change')]"));
    }

    public void goToProfile() throws InterruptedException {
        clickOnHamburger();
        wait3000();
        click(By.xpath("//mat-icon[contains(text(),'person')]"));
    }

    public void clickOnHamburger() {
        click(By.xpath("//mat-icon[@class='but mat-icon material-icons']"));
    }

    public void clickOnLogin() {

        click(By.xpath("//span[contains(text(),'Login')]"));
    }

    public void wait3000() throws InterruptedException {
        Thread.sleep(3000);
    }

    public void addNewList(String listTitle) {
        click(By.xpath("//a[@class='open-add-list js-open-add-list']"));
        type(By.xpath("//input[@name='name']"),listTitle);
        click(By.xpath("//input[@value='Add List']"));
        click(By.xpath("//a[@class='icon-lg icon-close dark-hover js-cancel-edit']"));

    }

    public void addList(String listTitle) {

        type(By.xpath("//input[@class='list-name-input']"),listTitle);
        click(By.xpath("//input[@value='Add List']"));
        click(By.xpath("//a[@class='icon-lg icon-close dark-hover js-cancel-edit']"));


    }

    public void buttonHomeLeftSideMenu() {
        click(By.xpath("//span[@class='icon-home icon-sm tab__tabIconSpan__jlnEo']"));
    }

    public void fillNewBoardFormWithTeam(String boardTitle) throws InterruptedException {
        createNewBoard();
        type(By.xpath("//input[@placeholder='Add board title']"), boardTitle);
        wait3000();
        selectTeam();
        wait3000();
        selectPrivacyWithTeam();
        wait3000();
        selectBackground();
        wait3000();
        confirmBoard();
    }

    public void fillNewBoardFormWithoutTeam(String boardTitle) throws InterruptedException {
        createNewBoard();
        type(By.xpath("//input[@placeholder='Add board title']"), boardTitle);
        wait3000();
        boardWithoutTeam();
        wait3000();
        selectPrivacyWithoutTeam();
        wait3000();
        selectBackground();
        wait3000();
        confirmBoard();
        wait3000();
    }

    public void confirmBoard() {
        click(By.xpath("//button[@type='submit']"));
    }

    public void selectPrivacyWithTeam() {
        click(By.xpath("//button[@class='subtle-chooser-trigger unstyled-button vis-chooser-trigger']"));
        List<WebElement> privacy = wd.findElements(By.xpath("//ul[@class='pop-over-list vis-chooser']//li"));
        for(int i = 1 ; i <= privacy.size(); i++){

            WebElement privateSection = wd.findElement(By.xpath("//ul[@class='pop-over-list vis-chooser']//li[" + i + "]"));
            System.out.println(privateSection.getText());
        }
        privacy.get(3).click();
    }

    public void selectPrivacyWithoutTeam() {
        click(By.xpath("//button[@class='subtle-chooser-trigger unstyled-button vis-chooser-trigger']"));
        List<WebElement> privacyWithoutTeam = wd.findElements(By.xpath("//ul[@class='pop-over-list vis-chooser']//li"));
        for(int i = 1 ; i <= privacyWithoutTeam.size(); i++){

            WebElement privateSection = wd.findElement(By.xpath("//ul[@class='pop-over-list vis-chooser']//li[" + i + "]"));
            System.out.println(privateSection.getText());
        }
        click(By.xpath("//span[contains(text(),'Private')]"));

    }

    public void boardWithoutTeam(){
        click(By.xpath("//button[@class='subtle-chooser-trigger unstyled-button org-chooser-trigger']"));
        List<WebElement> chooseTeam = wd.findElements(By.xpath("//ul[@class='pop-over-list org-chooser']//li"));
        for (int i = 1; i <= chooseTeam.size(); i++) {

            WebElement teamName = wd.findElement(By.xpath("//ul[@class='pop-over-list org-chooser']//li[" + i + "]"));
            System.out.println(teamName.getText());
        }
        click(By.xpath("//a[@href='#']//span[contains(text(),'No team')]"));
    }

    public void selectTeam() {
        click(By.xpath("//button[@class='subtle-chooser-trigger unstyled-button org-chooser-trigger']"));
        List<WebElement> chooseTeam = wd.findElements(By.xpath("//ul[@class='pop-over-list org-chooser']//li"));
        for (int i = 1; i <= chooseTeam.size(); i++) {

            WebElement teamName = wd.findElement(By.xpath("//ul[@class='pop-over-list org-chooser']//li[" + i + "]"));
            System.out.println(teamName.getText());
       }
        chooseTeam.get(1).click();
    }

    public void selectBackground() {

        List<WebElement> background = wd.findElements(By.xpath("//ul[@class='background-grid']//li"));
        for(int i = 1 ; i <= background.size(); i++){

            WebElement back = wd.findElement(By.xpath("//ul[@class='background-grid']//li[" + i + "]"));
            System.out.println(back.getText());

           // Assert.assertEquals(9,back.getSize());
           /* if(background.size() == 9){

                we can play with a lot of pictures or colors for the backgrounds. It's a funny job but is not our homeWorks

                */
            }
            background.get(4).click();
        }

    public void createNewBoard() {
        click(By.xpath("//span[@class='tile__linkText__BCNab']"));
    }

    public void loginUserWithFields(LoginData loginData) throws InterruptedException {
        click(By.xpath("//a[@class='global-header-section-button']"));
        type(By.xpath("//input[@id='user']"), loginData.getEmail());
        type(By.xpath("//input[@id='password']"), loginData.getPassword());
        confirm();
        wait3000();
    }

    public void confirm() {
        click(By.xpath("//input[@type='submit']"));
    }
}
