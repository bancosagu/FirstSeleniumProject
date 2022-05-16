import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

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

//test add to wishlist + login + check wishlist
    @AfterEach
    public void closeDriver(){

        driver.close();
    }
}
