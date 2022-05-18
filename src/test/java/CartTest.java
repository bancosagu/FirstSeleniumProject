import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class CartTest {
    private WebDriver driver;


    @BeforeEach
    public void setUp() {
        System.setProperty("webdriver.chrome.driver","resources/chromedriver");
        driver = new ChromeDriver();
//        driver.manage().window().maximize();
        driver.get("http://testfasttrackit.info/selenium-test/");
    }



    @Test
    public void addProductToCartAsGuestSellectingColorAndSize(){
        driver.findElement(By.cssSelector("h3 a[title^='Elizabeth']")).click();
        driver.findElement(By.id("swatch21")).click();
        driver.findElement(By.id("swatch80")).click();
        driver.findElement(By.cssSelector("div.add-to-cart-buttons")).click();
        WebElement dashboardTextElement = driver.findElement(By.cssSelector("div.page-title"));
        String textFromElement = driver.findElement(By.cssSelector("ul.messages")).getText();
        Assertions.assertTrue(dashboardTextElement.isDisplayed());
        Assertions.assertEquals("Elizabeth Knit Top was added to your shopping cart.", textFromElement);
    }

    @Test
    void tryToAddProductToCartWithoutCharacteristics(){
        driver.findElement(By.cssSelector("h3 a[title^='Elizabeth']")).click();
        driver.findElement(By.cssSelector("div.add-to-cart-buttons")).click();
        String errorMessageColor = driver.findElement(By.id("advice-required-entry-attribute92")).getText();
        Assertions.assertEquals("This is a required field.", errorMessageColor);
        String errorMessageSize = driver.findElement(By.id("advice-required-entry-attribute180")).getText();
        Assertions.assertEquals("This is a required field.", errorMessageSize);
    }

    @Test
    public void addProductToCartWhileLoggedIn(){
        driver.findElement(By.cssSelector(".skip-account .label")).click();
        driver.findElement(By.cssSelector("a[title='Log In'")).click();
        driver.findElement(By.id("email")).sendKeys("bancosagu@yahoo.com");
        driver.findElement(By.id("pass")).sendKeys("Pass1234");
        driver.findElement(By.id("send2")).click();
        //navigate to homepage
        driver.get("http://testfasttrackit.info/selenium-test/");
        driver.findElement(By.cssSelector("h3 a[title^='Elizabeth']")).click();
        driver.findElement(By.id("swatch21")).click();
        driver.findElement(By.id("swatch80")).click();
        driver.findElement(By.cssSelector("div.add-to-cart-buttons")).click();
        WebElement dashboardTextElement = driver.findElement(By.cssSelector("div.page-title"));
        String textFromElement = driver.findElement(By.cssSelector("ul.messages")).getText();
        Assertions.assertTrue(dashboardTextElement.isDisplayed());
        Assertions.assertEquals("Elizabeth Knit Top was added to your shopping cart.", textFromElement);
    }

    @Test
    public void productIsSavedInCartAfterLogOut(){
        driver.findElement(By.cssSelector(".skip-account .label")).click();
        driver.findElement(By.cssSelector("a[title='Log In'")).click();
        driver.findElement(By.id("email")).sendKeys("bancosagu@yahoo.com");
        driver.findElement(By.id("pass")).sendKeys("Pass1234");
        driver.findElement(By.id("send2")).click();
        //navigate to homepage
        driver.get("http://testfasttrackit.info/selenium-test/");
        driver.findElement(By.cssSelector("h3 a[title^='Elizabeth']")).click();
        driver.findElement(By.id("swatch21")).click();
        driver.findElement(By.id("swatch80")).click();
        driver.findElement(By.cssSelector("div.add-to-cart-buttons")).click();
        //logout
        driver.findElement(By.cssSelector(".skip-account .label")).click();
        driver.findElement(By.cssSelector("a[title='Log Out']")).click();
        //login back
        driver.findElement(By.cssSelector(".skip-account .label")).click();
        driver.findElement(By.cssSelector("a[title='Log In'")).click();
        driver.findElement(By.id("email")).sendKeys("bancosagu@yahoo.com");
        driver.findElement(By.id("pass")).sendKeys("Pass1234");
        driver.findElement(By.id("send2")).click();
        //check cart
        driver.get("http://testfasttrackit.info/selenium-test/checkout/cart/");
        String valueFromElementQty= driver.findElement(By.cssSelector(".input-text.qty[title='Qty']")).getText();
        Assertions.assertEquals("2", valueFromElementQty);
        //nu reuseste sa citeasca valoarea in campul "qty"
        //empty cart
        driver.findElement(By.cssSelector(".button2[title='Empty Cart']")).click();
    }
    @Test
    void emptyCartButtonTest(){
        driver.findElement(By.cssSelector(".skip-account .label")).click();
        driver.findElement(By.cssSelector("a[title='Log In'")).click();
        driver.findElement(By.id("email")).sendKeys("bancosagu@yahoo.com");
        driver.findElement(By.id("pass")).sendKeys("Pass1234");
        driver.findElement(By.id("send2")).click();
        //navigate to homepage
        driver.get("http://testfasttrackit.info/selenium-test/");
        driver.findElement(By.cssSelector("h3 a[title^='Elizabeth']")).click();
        driver.findElement(By.id("swatch21")).click();
        driver.findElement(By.id("swatch80")).click();
        driver.findElement(By.cssSelector("div.add-to-cart-buttons")).click();
        driver.findElement(By.cssSelector(".button2[title='Empty Cart']")).click();
        String dashboardTextElementCartEmpty = driver.findElement(By.cssSelector(".page-title")).getText();
        Assertions.assertTrue(dashboardTextElementCartEmpty.contentEquals("SHOPPING CART IS EMPTY"));
    }

    @Test
    void addProductToCartWithQtyTwo(){
        driver.findElement(By.cssSelector("h3 a[title^='Elizabeth']")).click();
        driver.findElement(By.id("swatch21")).click();
        driver.findElement(By.id("swatch80")).click();
        driver.findElement(By.id("qty")).clear();
        driver.findElement(By.id("qty")).sendKeys("2");
        driver.findElement(By.cssSelector("div.add-to-cart-buttons")).click();
        WebElement dashboardTextElement = driver.findElement(By.cssSelector("div.page-title"));
        String textFromElement = driver.findElement(By.cssSelector("ul.messages")).getText();
        Assertions.assertTrue(dashboardTextElement.isDisplayed());
        Assertions.assertEquals("Elizabeth Knit Top was added to your shopping cart.", textFromElement);
        String valueFromElement= driver.findElement(By.cssSelector(".input-text.qty[title='Qty']")).getText();
        Assertions.assertEquals("2",valueFromElement);
    //testul cade de fiecare data deoarece nu reuseste sa citeasca valoarea in campul "qty"

    }


        //change quantity in cart using update button





    @AfterEach

    public void closeDriver() {
        driver.close();

    }

}
