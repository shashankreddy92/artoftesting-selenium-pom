package pompackage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LogInPagePOM
{
   private By userNameField = By.xpath("//input[@id='uname']");
   private By passwordField = By.xpath("//input[@id='pass']");
   private By logInButton = By.xpath("//button[text()='Login']");

   WebDriver driver;

   public LogInPagePOM(WebDriver driver)
   {
       this.driver=driver;
   }

   public WebElement getUserNameField()
   {
       return driver.findElement(userNameField);
   }

   public WebElement getPasswordField()
   {
       return driver.findElement(passwordField);
   }

   public WebElement getLogInButton()
   {
       return driver.findElement(logInButton);
   }

}