import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class RegisterTest {
//Adăugați în clasa RegisterTest un test(o noua metoda) în care să automatizați
// pașii necesari pentru înregistrarea cu succes a unui utilizator nou
// (deschideți homepage-ul, apăsați pe Account, apăsați pe Register, completați
// toate câmpurile de pe pagina Register - atenție ca email-ul să fie unic, bifați
// opțiunea pentru primirea newsleterr-ului). Folosiți identificatori diferiți pentru
// câmpurile de pe pagina Register (id, name, className). Pe viitor, după învățarea altor
// identificatori, veți reveni pentru a apăsa și butonul Register. Apelati metoda aceasta
// in metoda main din clasa pentru a rula testul.

    public void registerWithValidData(){
        System.setProperty("webdriver.chrome.driver","resources/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://testfasttrackit.info/selenium-test/");
        driver.findElement(By.cssSelector("#header > div > div.skip-links > div > a > span.label")).click();
        driver.findElement(By.cssSelector("#header-account > div > ul > li:nth-child(5) > a")).click();
        driver.findElement(By.id("firstname")).sendKeys("Augustin");
        driver.findElement(By.id("lastname")).sendKeys("Bancos");
        driver.findElement(By.id("email_address")).sendKeys("bancosagu@yahoo.com");
        driver.findElement(By.id("password")).sendKeys("Pass1234");
        driver.findElement(By.id("confirmation")).sendKeys("Pass1234");
        driver.findElement(By.className("checkbox")).click();
        driver.findElement(By.cssSelector("#form-validate > div.buttons-set > button > span > span")).click();
        driver.quit();
    }
}
