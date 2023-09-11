import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;
public class GithubLoginTest {

    public void loginFirefox(String email, String password){
        System.setProperty("webdriver.gecko.driver", "src/test/resources/geckodriver.exe");

        FirefoxDriver firefoxDriver = new FirefoxDriver();
        firefoxDriver.get("https://github.com/login");

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        WebElement emailField = firefoxDriver.findElement(By.id("login_field"));
        emailField.sendKeys(email);
        WebElement pass = firefoxDriver.findElement(By.id("password"));
        pass.sendKeys(password);

        pass.submit();

        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        firefoxDriver.quit();
    }

    public void loginChrome(String password, String email) {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");

        ChromeDriver driver = new ChromeDriver();
        driver.get("https://github.com/login");

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        WebElement pass = driver.findElement(By.id("password"));
        pass.sendKeys(password);
        WebElement emailField = driver.findElement(By.id("login_field"));
        emailField.sendKeys(email);

        pass.submit();

        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }


        driver.quit();
    }
    @Test
    public void loginSuccessFirefox() throws InterruptedException{
        loginFirefox("nairamnatsakanyan997@gmail.com","Aca2023#");
    }

   @Test
    public void invalidPasswordFirefox() throws InterruptedException{
       loginFirefox("nairamnatsakanyan997@gmail.com","Aca2024#");

    }

    @Test
    public void invalidEmailFirefox() throws InterruptedException{
        loginFirefox("nairamnatsakanyan998@gmail.com","Aca2023#");
    }

    @Test
    public void loginSuccessChrome() throws InterruptedException{
        loginChrome("Aca2023#", "nairamnatsakanyan997@gmail.com");
    }

    @Test
    public void invalidPasswordChrome() throws InterruptedException{
        loginChrome("Aca2024#", "nairamnatsakanyan997@gmail.com");
    }

    @Test
    public void invalidEmailChrome() throws InterruptedException{
        loginChrome("Aca2023#", "nairamnatsakanyan998@gmail.com");
    }

}
