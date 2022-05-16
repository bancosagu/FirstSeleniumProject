import org.junit.Assert;
import org.junit.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginTest {

    private WebDriver driver;

    @BeforeEach
    public void openDriver(){
        System.setProperty("webdriver.chrome.driver","resources/chromedriver");
        driver = new ChromeDriver();
//        driver.manage().window().maximize();
        driver.get("http://testfasttrackit.info/selenium-test/");
    }

    @Test
    public void loginWithValidCredentials(){

        driver.findElement(By.cssSelector(".skip-account .label")).click();
        driver.findElement(By.cssSelector("a[title='Log In'")).click();
        driver.findElement(By.id("email")).sendKeys("bancosagu@yahoo.com");
        driver.findElement(By.id("pass")).sendKeys("Pass1234");
        driver.findElement(By.id("send2")).click();
        WebElement dashboardTextElement = driver.findElement(By.cssSelector(".page-title h1"));
        String textFromElement = driver.findElement(By.cssSelector(".hello strong")).getText();
        Assert.assertTrue(dashboardTextElement.isDisplayed());
        Assert.assertEquals("Hello, Augustin Bancos!",textFromElement);
    }

    @Test
    public void loginWithInvalidPasswordTest() {
        driver.findElement(By.cssSelector(".skip-account .label")).click();
        driver.findElement(By.cssSelector("a[title='Log In'")).click();
        driver.findElement(By.id("email")).sendKeys("bancosagu@yahoo.com");
        driver.findElement(By.id("pass")).sendKeys("Pass12345");
        driver.findElement(By.id("send2")).click();
        String textFromElement = driver.findElement(By.cssSelector(".error-msg span")).getText();
        Assert.assertEquals("Invalid login or password.", textFromElement);
    }

    @Test
    public void loginWithInvalidEmail() {

        driver.findElement(By.cssSelector(".skip-account .label")).click();
        driver.findElement(By.cssSelector("a[title='Log In'")).click();
        driver.findElement(By.id("email")).sendKeys("bancosaguyahoo.com");
        driver.findElement(By.id("pass")).sendKeys("Pass1234");
        driver.findElement(By.id("send2")).click();
        String textFromElement = driver.findElement(By.cssSelector(".error-msg span")).getText();
        Assert.assertEquals("Invalid login or password.", textFromElement);
    }

    @Test
    public void loginWithoutEmailTest() {
        driver.findElement(By.cssSelector(".skip-account .label")).click();
        driver.findElement(By.cssSelector("a[title='Log In'")).click();
        driver.findElement(By.id("send2")).click();
        String textFromElement = driver.findElement(By.id("advice-required-entry-email")).getText();
        Assert.assertEquals("This is a required field.", textFromElement);
    }

    @Test
    public void loginWithoutPassTest() {
        driver.findElement(By.cssSelector(".skip-account .label")).click();
        driver.findElement(By.cssSelector("a[title='Log In'")).click();
        driver.findElement(By.id("email")).sendKeys("bancosagu@yahoo.com");
        driver.findElement(By.id("send2")).click();
        String textFromElement = driver.findElement(By.id("advice-required-entry-pass")).getText();
        Assert.assertEquals("This is a required field.", textFromElement);
    }

    @Test
    public void loginWithEmptyFieldsTest() {
        driver.findElement(By.cssSelector(".skip-account .label")).click();
        driver.findElement(By.cssSelector("a[title='Log In'")).click();
        driver.findElement(By.id("email")).sendKeys("");
        driver.findElement(By.id("pass")).sendKeys("");
        driver.findElement(By.id("send2")).click();
        String textFromElement = driver.findElement(By.id("advice-required-entry-pass")).getText();
        Assert.assertEquals("This is a required field.", textFromElement);
    }

    @AfterEach
    public void closeDriver(){

        driver.close();
    }



}
