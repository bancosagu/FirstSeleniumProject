
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.UUID;


public class RegisterTest {

    private WebDriver driver;

    @BeforeEach
    public void openDriver(){
        System.setProperty("webdriver.chrome.driver","resources/chromedriver");
        driver = new ChromeDriver();
//        driver.manage().window().maximize();
        driver.get("http://testfasttrackit.info/selenium-test/");
    }

    private static String randomEmail() {
        return "bancosagu" + UUID.randomUUID().toString() + "@gmail.com";
        //genereaza mail nou de fiecare data, insa nu primesc confirmare
    }

    @Test
    @DisplayName("Register using valid data")
    public void registerWithValidData(){
        driver.findElement(By.cssSelector(".skip-account .label")).click();
        driver.findElement(By.cssSelector("a[title='Register']")).click();
        driver.findElement(By.id("firstname")).sendKeys("Augustin");
        driver.findElement(By.id("lastname")).sendKeys("Bancos");
        driver.findElement(By.id("email_address")).sendKeys(randomEmail());
        driver.findElement(By.id("password")).sendKeys("Pass1234");
        driver.findElement(By.id("confirmation")).sendKeys("Pass1234");
        driver.findElement(By.className("checkbox")).click();
        driver.findElement(By.cssSelector(".button[title=Register]")).click();
        String textFromElement = driver.findElement(By.cssSelector(".success-msg")).getText();
        Assertions.assertEquals("Thank you for registering with Madison Island.", textFromElement);

    }


    @AfterEach
    public void closeDriver(){
        driver.close();
    }
}
