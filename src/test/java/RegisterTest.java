import org.checkerframework.common.value.qual.StaticallyExecutable;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.UUID;


public class RegisterTest {

    private WebDriver driver;

    @Before
    public void openDriver(){
        System.setProperty("webdriver.chrome.driver","resources/chromedriver");
        driver = new ChromeDriver();
//        driver.manage().window().maximize();
        driver.get("http://testfasttrackit.info/selenium-test/");
    }

    @Test
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
        Assert.assertEquals("Thank you for registering with Madison Island.", textFromElement);

    }
    private static String randomEmail() {
        return "bancosagu" + UUID.randomUUID().toString() + "@gmail.com";
    }


    //possible to register from checkout page

    @After
    public void closeDriver(){
        driver.close();
    }
}
