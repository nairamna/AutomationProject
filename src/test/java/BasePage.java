import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public abstract class BasePage implements Loadable {
    protected WebDriver driver;
    protected SeleniumActions actions;
    public BasePage(WebDriver webDriver) {
        this.driver = webDriver;
        this.actions = new SeleniumActions(driver);
    }

    public BasePage(FirefoxDriver geckoDriver){
        this.driver = geckoDriver;
        this.actions = new SeleniumActions(geckoDriver);
    }
}