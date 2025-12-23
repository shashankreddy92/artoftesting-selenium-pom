package utilitypackage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class ActionUtility
{
    WebDriver driver;

    Actions action;

    public ActionUtility(WebDriver driver)
    {
        this.driver = driver;
        action = new Actions(driver);

    }

    public void writeInElement(WebElement element, String data)
    {
        action.sendKeys(element,data).perform();
    }

    public void clickOnElement(WebElement element)
    {
       action.click(element).perform();
    }

    public void clearContent(WebElement element)
    {
        element.clear();
    }
}