import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class WishListTest {

    private WebDriver driver;

    @BeforeEach
    public void openDriver(){
        System.setProperty("webdriver.chrome.driver","resources/chromedriver");
        driver = new ChromeDriver();
//        driver.manage().window().maximize();
        driver.get("http://testfasttrackit.info/selenium-test/");
    }

    @Test
    public void addToWishlistAsGuest() {
        driver.findElement(By.cssSelector(".level0.nav-5.parent")).click();
        driver.findElement(By.cssSelector("h2 a")).click();
        driver.findElement(By.cssSelector(".link-wishlist")).click();
        String textFromElement = driver.findElement(By.cssSelector(".content.fieldset h2 ")).getText();
        Assertions.assertEquals("ALREADY REGISTERED?", textFromElement);

    }

    @Test
    public void addToWishlistAsGuestThanLoginAndCheck(){
        driver.findElement(By.cssSelector(".level0.nav-5.parent")).click();
        driver.findElement(By.cssSelector("h2 a")).click();
        driver.findElement(By.cssSelector(".link-wishlist")).click();
        driver.findElement(By.id("email")).sendKeys("bancosagu@yahoo.com");
        driver.findElement(By.id("pass")).sendKeys("Pass1234");
        driver.findElement(By.id("send2")).click();
        WebElement myWishlistHeader = driver.findElement(By.cssSelector(".page-title h1"));
        Assertions.assertTrue(myWishlistHeader.isDisplayed());
        String wishlistEmptyMessage = driver.findElement(By.cssSelector(".wishlist-empty")).getText();
        Assertions.assertEquals("You have no items in your wishlist.", wishlistEmptyMessage);
        //Dupa login nu apare produsul selectat in wishlist

    }


    @AfterEach
    public void closeDriver(){

        driver.close();
    }
}
