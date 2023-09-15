import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class NewTest {
    @Test
    public void loginTest(){
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");

        ChromeDriver chromeDriver = new ChromeDriver();
        chromeDriver.get("https://github.com/login");

        WebElement firstResult = new WebDriverWait(chromeDriver,10).until(ExpectedConditions.elementToBeClickable(By.xpath("//a/h3")));

        WebElement usernameField = chromeDriver.findElement(By.name("login"));
        WebElement passwordField = chromeDriver.findElement(By.name("password"));
        WebElement loginButton = chromeDriver.findElement(By.name("commit"));


        usernameField.sendKeys("naramnacakanyan@gmail.com");
        passwordField.sendKeys("Ineco21#");

        loginButton.click(); // or passwordField.submit();

        //WebElement avatarField = chromeDriver.findElement(By.xpath("//span[@class='avatar circle'"/));
      //  avatarField.click();

        //span[@class='avatar circle'"/img[@class="avatar circle"]
       // WebElement errorElement = firefoxDriver.findElement(By.className("_9ay7"));
        //System.out.println(errorElement.getText());

       // Assert.assertEquals(errorElement.getText(), "The email or mobile number you entered isn’t connected to an account. Find your account and log in.");


    }

}
