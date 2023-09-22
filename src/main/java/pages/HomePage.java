package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import pages.BasePage;

public class HomePage extends BasePage {
    public HomePage(WebDriver driver) {
        super(driver);
    }

    public HomePage(FirefoxDriver geckoDriver){
        super(geckoDriver);
    }

    By avatarLocator = By.cssSelector(".Button-label .avatar.circle");
    @Override
    public boolean isDisplayed() {
        boolean isAvatarDisplayed = actions.isDisplayed(avatarLocator, 10);
        return isAvatarDisplayed;
    }
}
