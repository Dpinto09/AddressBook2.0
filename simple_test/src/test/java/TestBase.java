import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class TestBase {
    WebDriver wd;

    @BeforeMethod
    public void setUp() {

        wd = new ChromeDriver();
    }

    @AfterMethod
    public void tearDown() {

        wd.quit();

    }

    public void proceedToSearchWithEnter() {

        wd.findElement(By.cssSelector(".icon-search")).sendKeys(Keys.ENTER);
    }

    public String getTextToSearch(By locator) {
        return wd.findElement(locator).getText().toLowerCase();
    }

    public void proceedToSearch() {
        click(By.cssSelector(".icon-search"));
    }

    public void click(By locator) {
        wd.findElement(locator).click();
    }

    public void typeOnSearchBox(String text) {
        type(By.name("s"), text);

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
}
