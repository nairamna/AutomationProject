import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;


public class MyFirstTest {

    @Test
    public void loginSuccessChrome() {

        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        ChromeDriver driver = new ChromeDriver();

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        driver.get("https://github.com/login");

        WebElement usernameField = driver.findElement(By.name("login"));
        usernameField.sendKeys("nairamnatsakanyan997@gmail.com");

        WebElement passwordField = driver.findElement(By.name("password"));
        passwordField.sendKeys("Aca2023");

        WebElement loginButton = driver.findElement(By.name("commit"));
        loginButton.click();

        By locatorOfAvatarElement = By.cssSelector(".Button-label .avatar.circle");
        SeleniumActions actions = new SeleniumActions(driver);
        boolean isLocatorOfAvatarElementDisplayed = actions.isDisplayed(locatorOfAvatarElement, 10);
        Assert.assertTrue(isLocatorOfAvatarElementDisplayed);

        driver.quit();

    }


    //will add other 5 cases in the weekend!
}
