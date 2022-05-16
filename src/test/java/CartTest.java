import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CartTest {
    private WebDriver driver;


    @BeforeEach
    void setUp() {
        System.setProperty("webdriver.chrome.driver","resources/chromedriver");
        driver = new ChromeDriver();
//        driver.manage().window().maximize();
        driver.get("http://testfasttrackit.info/selenium-test/");

    }
    //add to cart without account
    //add to cart while loged in
    //add to cart without chosing characteristics
    //product added in cart is saved after logging out
    //


    @Test
    void checkIfProductIsAddedToCart() {

    }


    @AfterEach
    static void closeDriver() {
        driver.close();

    }
}
