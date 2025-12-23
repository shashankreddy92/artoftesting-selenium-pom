package usingpomclasses;

import org.openqa.selenium.WebDriver;
import pompackage.LogInPagePOM;
import utilitypackage.ActionUtility;
import utilitypackage.PropertyFileUtility;
import utilitypackage.WebBrowserUtility;


public class LogInUsingPOM
{
    static PropertyFileUtility pfu;
    static WebBrowserUtility wbu;
    static ActionUtility au;

    static LogInPagePOM login;

    static String browser;
    static String url;
    static String user;
    static String password;

    static WebDriver driver;

    public static void main(String[] args)  throws Exception{

        pfu = new PropertyFileUtility();

        browser = pfu.getData("browser");
        url = pfu.getData("url");
        user = pfu.getData("user");
        password = pfu.getData("password");

        wbu = new WebBrowserUtility();

        wbu.openBrowser(browser);
        wbu.openUrl(url);
        wbu.waitForElement(10);
        driver = wbu.getDriver();


        login = new LogInPagePOM(driver);

        au = new ActionUtility(driver);

        au.clearContent(login.getUserNameField());

        wbu.dumbWait(1);

        au.writeInElement(login.getUserNameField(),user);

        wbu.dumbWait(1);

        au.clearContent(login.getPasswordField());

        wbu.dumbWait(1);

        au.writeInElement(login.getPasswordField(),password);

        wbu.dumbWait(1);

        au.clickOnElement(login.getLogInButton());

    }
}