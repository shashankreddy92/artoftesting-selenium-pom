package usingpomclasses;

import org.openqa.selenium.WebDriver;
import pompackage.HomePagePOM;
import pompackage.LogInPagePOM;
import utilitypackage.ActionUtility;
import utilitypackage.PropertyFileUtility;
import utilitypackage.WebBrowserUtility;

public class BuyingSingleItem {
	static PropertyFileUtility pfu;
	static WebBrowserUtility wbu;
	static ActionUtility au;

	static String browser;
	static String url;
	static String user;
	static String password;
	static String desiredBook;

	static WebDriver driver;

	static LogInPagePOM login;
	static HomePagePOM home;

	public static void main(String[] args) throws Exception {
		pfu = new PropertyFileUtility();

		browser = pfu.getData("browser");
		url = pfu.getData("url");
		user = pfu.getData("username");
		password = pfu.getData("password");
		desiredBook = pfu.getData("desiredBook");
 
		System.out.println(password + "  " + user);

		wbu = new WebBrowserUtility();

		wbu.openBrowser(browser);
		wbu.openUrl(url);
		wbu.waitForElement(10);

		driver = wbu.getDriver();

		au = new ActionUtility(driver);

		login = new LogInPagePOM(driver);

		au.clearContent(login.getUserNameField());

		wbu.dumbWait(1);

		au.writeInElement(login.getUserNameField(), user);

		wbu.dumbWait(1);

		au.clearContent(login.getPasswordField());

		wbu.dumbWait(1);

		au.writeInElement(login.getPasswordField(), password);

		wbu.dumbWait(1);

		au.clickOnElement(login.getLogInButton());

		// login.perfromLogIn(user,password);

		home = new HomePagePOM(driver);

		 home.addBookToCartByName(desiredBook);
		 
		 System.out.println(desiredBook + " added to cart");
		 
		 home.openCart();
		 
		 System.out.println("Cart opened");
		 
		 home.clickCheckout();
		 
		 System.out.println("Checkout clicked");
		
		

	}
}
