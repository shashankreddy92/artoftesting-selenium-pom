package pompackage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class HomePagePOM
{
    @FindBy(xpath = "//a[contains(@class,'Header_logoLink__Hzzf9')]")
    private WebElement homePageLink;

    @FindBy(xpath = "//*[name()='svg' and contains(@class,'Header_cart')]")
    private WebElement cartIcon;

    @FindBy(xpath = "//button[text()='Checkout']")
    private WebElement checkoutButton;

    @FindBy(xpath = "//div[@class='Products_item__Za1Q4']")
    private List<WebElement> allBooks;

    public HomePagePOM(WebDriver driver)
    {
        PageFactory.initElements(driver, this);
    }

    // ✅ Add "War and Peace" to cart
    public void addBookToCartByName(String bookName)
    {
        boolean found = false;

        for (WebElement book : allBooks)
        {
            WebElement title = book.findElement(
                By.xpath(".//div[@class='Products_title__7ggYL']")
            );

            if (title.getText().equalsIgnoreCase(bookName))
            {
                book.findElement(
                    By.xpath(".//button[text()='Add To Cart']")
                ).click();
                found = true;
                break;
            }
        }

        if (!found)
        {
            System.out.println("Book not found: " + bookName);
        }
    }

    // ✅ Open Cart
    public void openCart()
    {
        cartIcon.click();
    }

    // ✅ Click Checkout
    public void clickCheckout()
    {
        checkoutButton.click();
    }
}
