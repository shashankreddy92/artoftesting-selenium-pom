package utilitypackage;

import org.openqa.selenium.InvalidArgumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

public class WebBrowserUtility
{
   private WebDriver driver;

    public void openBrowser(String browser)
    {
        switch (browser.toLowerCase())
        {
            case "chrome":
                driver = new ChromeDriver();
                break;
            case "firefox":
                driver = new FirefoxDriver();
                break;
            case "edge":
                System.setProperty("webdriver.edge.driver","./msedgedriver.exe");
                driver = new EdgeDriver();
                break;
            default: throw new InvalidArgumentException("The Browser Name is incorrect");
        }

        driver.manage().window().maximize();
    }

    public WebDriver getDriver()
    {
        return driver;
    }

    public void openUrl(String url)
    {
        driver.get(url);
    }

    public void waitForPageLoad(int num)
    {
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(num));
    }

    public void waitForElement(int num)
    {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(num));
    }

    public void closeBrowser()
    {
        if (driver!=null)
        {
            driver.quit();
        }
    }

    public void dumbWait(int num) throws Exception
    {
        Thread.sleep(num*1000);
    }

}