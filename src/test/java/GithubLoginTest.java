import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;
import util.SeleniumActions;
import util.WebDriverUtil;

public class GithubLoginTest {

    private WebDriver driver;

    @AfterMethod
    public void after(){
        WebDriverUtil.closeDriver();
    }

    @BeforeMethod
    public void before(){
        driver = WebDriverUtil.getWebDriver();
        driver.get("https://github.com/login");
        LoginPage loginPage = new LoginPage(driver);
        Assert.assertTrue(loginPage.isDisplayed());
    }

    /**
     *
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

        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("nairamnatsakanyan997@gmail.com", "Aca2023#");
        HomePage homePage = new HomePage(driver);
        Assert.assertTrue(homePage.isDisplayed());

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


       LoginPage loginPage = new LoginPage(driver);
       loginPage.login("nairamnatsakanyan997@gmail.com", "");
       WebElement errorMessageElement = driver.findElement(By.className("js-flash-alert"));
       Assert.assertEquals(errorMessageElement.getText(), "Incorrect username or password.");
       System.out.println("Password field is empty");


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

            LoginPage loginPage = new LoginPage(driver);
            loginPage.login("nairamnatsakanyan997@gmail.com", "jhgff");
            WebElement errorMessageElement = driver.findElement(By.className("js-flash-alert"));
            Assert.assertEquals(errorMessageElement.getText(), "Incorrect username or password.");
            System.out.println("Password field is incorrect");

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

   /* @Test
    public void loginSuccessFirefox() {
        System.setProperty("webdriver.gecko.driver", "src/test/resources/geckodriver.exe");

        driver = new FirefoxDriver();

        LoginPage loginPage = new LoginPage(driver);

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driver.get("https://github.com/login");

        Assert.assertTrue(loginPage.isDisplayed());

        loginPage.login("nairamnatsakanyan997@gmail.com", "Aca2023#");

        HomePage homePage = new HomePage(driver);

        homePage.isDisplayed();

    }

    */

    /**
     * This method is validating that user cannot log in with empty password.
     *
     * Steps:
     *  1. Open https://github.com/login page
     *  2. Input valid email
     *  3. Click on 'Sign In' button
     *  4. Validate user is not logged in and "Password field is empty" error is displayed
     */
   /* @Test
    public void testLoginWithEmptyPasswordFirefox() {
        System.setProperty("webdriver.gecko.driver", "src/test/resources/geckodriver.exe");

        driver = new FirefoxDriver();

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

    }


    */
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
   /* @Test
    public void testLoginWithWrongPasswordFirefox() {
        System.setProperty("webdriver.gecko.driver", "src/test/resources/geckodriver.exe");

        driver = new FirefoxDriver();

        LoginPage loginPage = new LoginPage(driver);

        SeleniumActions actions = new SeleniumActions(driver);

        driver.get("https://github.com/login");

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        Assert.assertTrue(loginPage.isDisplayed());

        loginPage.login("nairamnatsakanyan997@gmail.com", "jxjxjc");

        boolean variable = actions.isDisplayed(By.className("js-flash-alert"), 10);
        Assert.assertTrue(variable);
        WebElement errorMessageElement = driver.findElement(By.className("js-flash-alert"));
        Assert.assertEquals(errorMessageElement.getText(), "Incorrect username or password.");

        System.out.println("Password field is incorrect");

    }

    */
}