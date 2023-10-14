package day06_notations_assertions;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import utilities.ReusableMethods;

import java.time.Duration;
public class C02_BeforeAfterNotasyonlari {
    //3 test method'u olusturup asagidaki gorevleri
    //bagimsiz olarak calisabilecek sekilde olusturun
    //1- Amazon anasayfaya gidip, url'in amazon icerdigini test edin,
    // sayfayi kapatin
    //2- Wisequarter anasayfaya gidip, title'in Wise icerdigini test edin
    //sayfayi kapatin
    //3- Youtube anasyafaya gidin,title'in best icermediginij test edin
    //sayfayi kapatin
    WebDriver driver;
    @Before
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }
    @After
    public void teardown(){
        ReusableMethods.bekle(2);
        driver.close();
    }
    @Test
    public void amazonTest(){
        driver.get("https://www.amazon.com");
        String expectedUrlIcerik="amazon";
        String actualUrl= driver.getCurrentUrl();
        if (actualUrl.contains(expectedUrlIcerik)){
            System.out.println("amazon test passed");
        }else{
            System.out.println("amazon test failed");
        }
    }
    @Test
    public void wiseTesti(){
        driver.get("https://www.wisequarter.com");
        String expectedTitleIcerik="Wise";
        String actualTitle=driver.getTitle();
        if (actualTitle.contains(expectedTitleIcerik)){
            System.out.println("wise quarter test passed");
        }else{
            System.out.println("wise quarter testi failed");
        }
    }
    @Test
    public void youtubeTest(){
        driver.get("https://www.youtube.com");
        String expectedTitleIcerik="best";
        String actualTitle=driver.getTitle();
        if (actualTitle.contains(expectedTitleIcerik)){
            System.out.println("youtube test passed");
        }else{
            System.out.println("youtube testi failed");
        }
    }
}
