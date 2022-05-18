import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class MyAccountTest {

    private WebDriver driver;

    @BeforeEach
    public void setUp(){
        System.setProperty("webdriver.chrome.driver","resources/chromedriver");
        driver = new ChromeDriver();
//        driver.manage().window().maximize();
        driver.get("http://testfasttrackit.info/selenium-test/");
    }


    @Test
    @Order(1)
    @DisplayName("Change password with a new one")
    public void changePassword(){
        driver.findElement(By.cssSelector(".skip-account .label")).click();
        driver.findElement(By.cssSelector("a[title='Log In'")).click();
        driver.findElement(By.id("email")).sendKeys("bancosagu@yahoo.com");
        driver.findElement(By.id("pass")).sendKeys("Pass1234");
        driver.findElement(By.id("send2")).click();
        WebElement dashboardTextElement = driver.findElement(By.cssSelector(".page-title h1"));
        Assertions.assertTrue(dashboardTextElement.isDisplayed());
        //driver.findElement(By.cssSelector("edit/changepass")).click();
        driver.get("http://testfasttrackit.info/selenium-test/customer/account/edit/changepass/1/");
        driver.findElement(By.id("current_password")).sendKeys("Pass1234");
        driver.findElement(By.id("password")).sendKeys("Pass12345");
        driver.findElement(By.id("confirmation")).sendKeys("Pass12345");
        driver.findElement(By.cssSelector(".button[title='Save']")).click();
        String confirmationMessage = driver.findElement(By.cssSelector("li.success-msg")).getText();
        Assertions.assertEquals("The account information has been saved.", confirmationMessage);

    }

    @Test
    @Order(2)
    @DisplayName("Change the password using the same as the new one")
    public void tryToUseTheSamePasswordAsNewPassword(){
        driver.findElement(By.cssSelector(".skip-account .label")).click();
        driver.findElement(By.cssSelector("a[title='Log In'")).click();
        driver.findElement(By.id("email")).sendKeys("bancosagu@yahoo.com");
        driver.findElement(By.id("pass")).sendKeys("Pass12345");
        driver.findElement(By.id("send2")).click();
        WebElement dashboardTextElement = driver.findElement(By.cssSelector(".page-title h1"));
        Assertions.assertTrue(dashboardTextElement.isDisplayed());
        //driver.findElement(By.cssSelector("edit/changepass")).click();
        driver.get("http://testfasttrackit.info/selenium-test/customer/account/edit/changepass/1/");
        driver.findElement(By.id("current_password")).sendKeys("Pass12345");
        driver.findElement(By.id("password")).sendKeys("Pass12345");
        driver.findElement(By.id("confirmation")).sendKeys("Pass12345");
        driver.findElement(By.cssSelector(".button[title='Save']")).click();
        String confirmationMessage = driver.findElement(By.cssSelector("li.success-msg")).getText();
        Assertions.assertEquals("The account information has been saved.", confirmationMessage);
    }

    @Test
    @Order(3)
    @DisplayName("Change the password back to the original")
    public void changeThePasswordBack(){
        driver.findElement(By.cssSelector(".skip-account .label")).click();
        driver.findElement(By.cssSelector("a[title='Log In'")).click();
        driver.findElement(By.id("email")).sendKeys("bancosagu@yahoo.com");
        driver.findElement(By.id("pass")).sendKeys("Pass12345");
        driver.findElement(By.id("send2")).click();
        WebElement dashboardTextElement = driver.findElement(By.cssSelector(".page-title h1"));
        Assertions.assertTrue(dashboardTextElement.isDisplayed());
        //driver.findElement(By.cssSelector("edit/changepass")).click();
        driver.get("http://testfasttrackit.info/selenium-test/customer/account/edit/changepass/1/");
        driver.findElement(By.id("current_password")).sendKeys("Pass12345");
        driver.findElement(By.id("password")).sendKeys("Pass1234");
        driver.findElement(By.id("confirmation")).sendKeys("Pass1234");
        driver.findElement(By.cssSelector(".button[title='Save']")).click();
        String confirmationMessage = driver.findElement(By.cssSelector("li.success-msg")).getText();
        Assertions.assertEquals("The account information has been saved.", confirmationMessage);

    }

    @AfterEach
    public void closeDriver(){
        driver.close();
    }






}
