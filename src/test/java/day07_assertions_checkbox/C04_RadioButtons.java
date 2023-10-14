package day07_assertions_checkbox;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.time.Duration;

public class C04_RadioButtons {
   /*
   Gerekli yapiyi olusturun ve aşağıdaki görevi tamamlayın.
 a. Verilen web sayfasına gidin.
     https://facebook.com
 b. Cookies’i kabul edin
 c. Create an account buton’una basin
 d. Radio button elementlerini locate edin ve size uygun olani secin
 e. Sectiginiz radio button’un seçili, ötekilerin seçili olmadigini test edin
    */
    WebDriver driver;
    @Before
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }
    @After
    public void teardown(){
        //driver.close();
    }
    @Test
    public void radioButtonTest() {
        //Verilen web sayfasına gidin:https://facebook.com
        driver.get("https://facebook.com");

        // Cookies’i kabul edin
        driver.findElement(By.xpath("//button[@title='Allow all cookies']")).click();

        // Create an account buton’una basin
        driver.findElement(By.xpath("//a[@data-testid='open-registration-form-button']")).click();

        // Radio button elementlerini locate edin ve size uygun olani secin
        WebElement femaleButton=driver.findElement(By.xpath("(//input[@*='_8esa'])[1]"));
        WebElement maleButton=driver.findElement(By.xpath("(//input[@*='_8esa'])[2]"));
        WebElement customButton=driver.findElement(By.xpath("(//input[@*='_8esa'])[3]"));
        femaleButton.click();

        // Sectiginiz radio button’un seçili, ötekilerin seçili olmadigini test edin
        Assert.assertTrue(femaleButton.isSelected()
                                && !maleButton.isSelected()
                                && !customButton.isSelected());
    }
}
