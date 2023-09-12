import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class GithubLoginTest {
    private WebDriver driver;

    @Test
    public void loginSuccessChrome() {
        testLogin("nairamnatsakanyan997@gmail.com", "Aca2023#", "chrome", "success");
    }

    @Test
    public void invalidPasswordChrome() {
        testLogin("nairamnatsakanyan997@gmail.com", "Aca2024#", "chrome", "");
    }

    @Test
    public void invalidEmailChrome() {
        testLogin("nairamnatsakanyan998@gmail.com", "Aca2023#", "chrome", "");
    }

    @Test
    public void loginSuccessFirefox() {
        testLogin("nairamnatsakanyan997@gmail.com", "Aca2023#", "firefox", "success");
    }

    @Test
    public void invalidPasswordFirefox() {
        testLogin("nairamnatsakanyan997@gmail.com", "Aca2024#", "firefox", "");
    }

    @Test
    public void invalidEmailFirefox() {
        testLogin("nairamnatsakanyan998@gmail.com", "Aca2023#", "firefox", "");
    }

    public void setUpChromeDriver() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        driver = new ChromeDriver();
    }

    public void setUpFirefoxDriver() {
        System.setProperty("webdriver.gecko.driver", "src/test/resources/geckodriver.exe");
        driver = new FirefoxDriver();
    }

    private void testLogin(String username, String password, String browser, String caseType) {
        if (browser == "chrome") {
            setUpChromeDriver();
        } else if (browser == "firefox") {
            setUpFirefoxDriver();
        }

        driver.get("https://github.com/login");

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        WebElement usernameField = driver.findElement(By.name("login"));
        WebElement passwordField = driver.findElement(By.name("password"));
        WebElement loginButton = driver.findElement(By.name("commit"));

        usernameField.sendKeys(username);
        passwordField.sendKeys(password);
        loginButton.click(); // or passwordField.submit();

        if (caseType != "success") {
            WebElement errorElement = driver.findElement(By.className("js-flash-alert"));
            Assert.assertEquals(errorElement.getText(), "Incorrect username or password.");
        }

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        driver.quit();
    }
}