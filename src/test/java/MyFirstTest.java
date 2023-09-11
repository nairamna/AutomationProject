import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;


public class MyFirstTest {

    @Test
    public void myFirstTestCase() throws InterruptedException{
        System.setProperty("webdriver.gecko.driver", "src/test/resources/geckodriver.exe");

        FirefoxDriver firefoxDriver = new FirefoxDriver();
        firefoxDriver.get("https://www.facebook.com/");

        Thread.sleep(5000);

        firefoxDriver.quit();
    }



    @Test
    public void mySecondTestCase() throws InterruptedException{
        System.setProperty("webdriver.gecko.driver", "src/test/resources/geckodriver.exe");

        FirefoxDriver firefoxDriver= new FirefoxDriver();
        firefoxDriver.get("https://www.google.com/");

        Thread.sleep(5000);
        firefoxDriver.quit();
    }



    @Test
    public void loginTest(){
        System.setProperty("webdriver.gecko.driver", "src/test/resources/geckodriver.exe");

        FirefoxDriver firefoxDriver = new FirefoxDriver();
        firefoxDriver.get("https://www.facebook.com/");

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        WebElement emailField = firefoxDriver.findElementById("email");
        WebElement passwordField = firefoxDriver.findElementById("pass");
        WebElement loginButton = firefoxDriver.findElementByName("login");


        emailField.sendKeys("hatrghss");
        passwordField.sendKeys("gfhjjhyt879LL(");

        loginButton.click(); // or passwordField.submit();

        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        WebElement errorElement = firefoxDriver.findElement(By.className("_9ay7"));
        System.out.println(errorElement.getText());

        Assert.assertEquals(errorElement.getText(), "The email or mobile number you entered isn’t connected to an account. Find your account and log in.");


    }
}
