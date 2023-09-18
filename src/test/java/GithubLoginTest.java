import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.util.concurrent.TimeUnit;

public class GithubLoginTest {

    /**
     * This method is validating that user can log in with correct username and password.
     *
     * Steps:
     *  1. Open https://github.com/login page
     *  2. Input valid email
     *  3. Input valid password
     *  3. Click on 'Sign In' button
     *  4. Validate user is logged in and the Avatar is displayed
     */
    @Test
    public void loginSuccessChrome() {

        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        ChromeDriver driver = new ChromeDriver();

        LoginPage loginPage = new LoginPage(driver);

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driver.get("https://github.com/login");

        Assert.assertTrue(loginPage.isDisplayed());

       loginPage.login("nairamnatsakanyan997@gmail.com", "Aca2023#");

        HomePage homePage = new HomePage(driver);

        homePage.isDisplayed();

        driver.quit();


    }

    /**
     * This method is validating that user cannot log in with empty password.
     *
     * Steps:
     *  1. Open https://github.com/login page
     *  2. Input valid email
     *  3. Click on 'Sign In' button
     *  4. Validate user is not logged in and "Password field is empty" error is displayed
     */
    @Test
    public void testLoginWithEmptyPasswordChrome() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");

        ChromeDriver driver = new ChromeDriver();

        LoginPage loginPage = new LoginPage(driver);

        SeleniumActions actions = new SeleniumActions(driver);

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driver.get("https://github.com/login");

        Assert.assertTrue(loginPage.isDisplayed());

        loginPage.login("nairamnatsakanyan997@gmail.com", "");

        boolean variable = actions.isDisplayed(By.className("js-flash-alert"), 10);
        Assert.assertTrue(variable);
        WebElement errorMessageElement = driver.findElement(By.className("js-flash-alert"));
        Assert.assertEquals(errorMessageElement.getText(), "Incorrect username or password.");

        System.out.println("Password field is empty");

        driver.quit();


    }

    /**
     * This method is validating that user cannot log in with wrong password.
     *
     * Steps:
     *  1. Open https://github.com/login page
     *  2. Input valid email
     *  3. Input not valid password
     *  3. Click on 'Sign In' button
     *  4. Validate user is not logged in and "Incorrect username or password" error is displayed
     */
        @Test
        public void testLoginWithWrongPasswordChrome(){
            System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");

            ChromeDriver driver = new ChromeDriver();

            LoginPage loginPage = new LoginPage(driver);

            SeleniumActions actions = new SeleniumActions(driver);

            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

            driver.get("https://github.com/login");
            Assert.assertTrue(loginPage.isDisplayed());
            loginPage.login("nairamnatsakanyan997@gmail.com", "hsgsg");

            boolean variable = actions.isDisplayed(By.className("js-flash-alert"), 10);
            Assert.assertTrue(variable);
            WebElement errorMessageElement = driver.findElement(By.className("js-flash-alert"));
            Assert.assertEquals(errorMessageElement.getText(), "Incorrect username or password.");

            System.out.println("Password field is incorrect");

            driver.quit();
        }

    /**
     * This method is validating that user can log in with correct username and password.
     *
     * Steps:
     *  1. Open https://github.com/login page
     *  2. Input valid email
     *  3. Input valid password
     *  3. Click on 'Sign In' button
     *  4. Validate user is logged in and the Avatar is displayed
     */
    @Test
    public void loginSuccessFirefox() {
        System.setProperty("webdriver.gecko.driver", "src/test/resources/geckodriver.exe");

        FirefoxDriver geckoDriver = new FirefoxDriver();

        LoginPage loginPage = new LoginPage(geckoDriver);

        geckoDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        geckoDriver.get("https://github.com/login");

        Assert.assertTrue(loginPage.isDisplayed());

        loginPage.login("nairamnatsakanyan997@gmail.com", "Aca2023#");

        HomePage homePage = new HomePage(geckoDriver);

        homePage.isDisplayed();

        geckoDriver.quit();
    }

    /**
     * This method is validating that user cannot log in with empty password.
     *
     * Steps:
     *  1. Open https://github.com/login page
     *  2. Input valid email
     *  3. Click on 'Sign In' button
     *  4. Validate user is not logged in and "Password field is empty" error is displayed
     */
    @Test
    public void testLoginWithEmptyPasswordFirefox() {
        System.setProperty("webdriver.gecko.driver", "src/test/resources/geckodriver.exe");

        FirefoxDriver geckoDriver = new FirefoxDriver();

        LoginPage loginPage = new LoginPage(geckoDriver);

        SeleniumActions actions = new SeleniumActions(geckoDriver);

        geckoDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        geckoDriver.get("https://github.com/login");

        Assert.assertTrue(loginPage.isDisplayed());

        loginPage.login("nairamnatsakanyan997@gmail.com", "");

        boolean variable = actions.isDisplayed(By.className("js-flash-alert"), 10);
        Assert.assertTrue(variable);
        WebElement errorMessageElement = geckoDriver.findElement(By.className("js-flash-alert"));
        Assert.assertEquals(errorMessageElement.getText(), "Incorrect username or password.");

        System.out.println("Password field is empty");

        geckoDriver.quit();
    }

    /**
     * This method is validating that user cannot log in with wrong password.
     *
     * Steps:
     *  1. Open https://github.com/login page
     *  2. Input valid email
     *  3. Input not valid password
     *  3. Click on 'Sign In' button
     *  4. Validate user is not logged in and "Incorrect username or password" error is displayed
     */
    @Test
    public void testLoginWithWrongPasswordFirefox() {
        System.setProperty("webdriver.gecko.driver", "src/test/resources/geckodriver.exe");

        FirefoxDriver geckoDriver = new FirefoxDriver();

        LoginPage loginPage = new LoginPage(geckoDriver);

        SeleniumActions actions = new SeleniumActions(geckoDriver);

        geckoDriver.get("https://github.com/login");

        geckoDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        Assert.assertTrue(loginPage.isDisplayed());

        loginPage.login("nairamnatsakanyan997@gmail.com", "jxjxjc");

        boolean variable = actions.isDisplayed(By.className("js-flash-alert"), 10);
        Assert.assertTrue(variable);
        WebElement errorMessageElement = geckoDriver.findElement(By.className("js-flash-alert"));
        Assert.assertEquals(errorMessageElement.getText(), "Incorrect username or password.");

        System.out.println("Password field is incorrect");

        geckoDriver.quit();
    }
}