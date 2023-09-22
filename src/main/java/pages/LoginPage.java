package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import pages.BasePage;

public class LoginPage extends BasePage {
    By emailFieldLocator = By.name("login");
    By passwordFieldLocator = By.name("password");
    By loginButtonLocator = By.name("commit");
    public LoginPage(WebDriver driver) {
        super(driver);
    }
    public void login(String email, String password) {
        WebElement emailElement = driver.findElement(emailFieldLocator);
        emailElement.sendKeys(email);
        WebElement passwordElement = driver.findElement(passwordFieldLocator);
        passwordElement.sendKeys(password);
        WebElement button = driver.findElement(loginButtonLocator);
        button.click();
    }
    @Override
    public boolean isDisplayed() {
        boolean isLoginButtonDisplayed = actions.isDisplayed(loginButtonLocator, 10);
        return isLoginButtonDisplayed;
    }



}