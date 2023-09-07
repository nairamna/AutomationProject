import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;


public class MyFirstTest {

    @Test
    public void myFirstTestCase() throws InterruptedException{
        System.setProperty("webdriver.gecko.driver", "src/test/resources/geckodriver.exe");

        FirefoxDriver firefoxDriver = new FirefoxDriver();
        firefoxDriver.get("https://www.facebook.com/");

        Thread.sleep(5000);

        WebElement emailField = firefoxDriver.findElement(By.cssSelector("[data-testid='royal_email']"));
        WebElement passwordField = firefoxDriver.findElement(By.cssSelector("[data-testid='royal_pass']"));
        WebElement buttonElement = firefoxDriver.findElement(By.cssSelector("[data-testid='royal_login_button']"));

        emailField.sendKeys("my email");
        passwordField.sendKeys("my password");

        buttonElement.click(); // or passwordField.submit();
        Thread.sleep(10000);

    }

    @Test
    public void mySecondTestCase() throws InterruptedException{
        System.setProperty("webdriver.gecko.driver", "src/test/resources/geckodriver.exe");

        FirefoxDriver firefoxDriver= new FirefoxDriver();
        firefoxDriver.get("https://www.google.com/");

        Thread.sleep(5000);



    }
}
