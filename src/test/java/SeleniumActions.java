import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SeleniumActions {
    private WebDriver driver;
    SeleniumActions(WebDriver driver){

        this.driver = driver;
    }

    public boolean isDisplayed(By e, int TimeOut) {
        try {
            new WebDriverWait(driver, TimeOut).until(ExpectedConditions.visibilityOfElementLocated(e));
        } catch (Exception exception) {
            return false;
        }
        return true;
    }

    boolean isDisplayed(WebElement e, int TimeOut) {
        try {
            new WebDriverWait(driver, TimeOut).until(ExpectedConditions.visibilityOf(e));
        } catch (Exception exception) {
            return false;
        }
        return true;
    }


    public boolean isClickable(By e, int TimeOut) {
        try {
            new WebDriverWait(driver, TimeOut).until(ExpectedConditions.elementToBeClickable(e));
        } catch (Exception exception) {
            return false;
        }
        return true;

    }
   /* public boolean isClickable (WebElement element, int timeout){
        try{
            new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(element));
        } catch (Exception exception){
            return false;
        };
        return true;
    }

    */

    public boolean isClickable(WebElement e, int TimeOut) {
        try {
            new WebDriverWait(driver, TimeOut).until(ExpectedConditions.elementToBeClickable(e));
        } catch (Exception s) {
            return false;
        }
        return true;
    }


    public boolean isPresent(WebElement e, int TimeOut) {
        try {
            new WebDriverWait(driver, TimeOut).until(ExpectedConditions.elementToBeSelected(e));
        } catch (Exception s) {
            return false;
        }
        return true;
    }
    public boolean isPresent(By e,int TimeOut){
        try {
            new WebDriverWait(driver, TimeOut).until(ExpectedConditions.elementToBeSelected(e));
        } catch (Exception exception) {
            return false;
        }
        return true;

    }
}
