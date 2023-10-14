package day06_notations_assertions;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C01_BeforeAfterNotasyonlari {
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
       driver=new ChromeDriver();
       driver.manage().window().maximize();
       driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
   }
   @After
    public void teardown(){
       driver.close();
   }
   @Test
    public void test01(){
       driver.get("https://www.amazon.com");
       String actualUrl=driver.getCurrentUrl();
       String expectedUrlIcerik="amazon";
       if (actualUrl.contains(expectedUrlIcerik)){
           System.out.println("amazon url testi passed");
       }else{
           System.out.println("amazon url testi failed");
       }
   }
   @Test
    public void test02(){
       driver.get("https://www.wisequarter.com");
       String actualTitle=driver.getTitle();
       String expectedTitleIcerik="Wise";
       if (actualTitle.contains(expectedTitleIcerik)){
           System.out.println("wise quarter title testi passed");
       }else {
           System.out.println("wise quarter title testi failed");
       }
   }
   @Test
    public void test03(){
       driver.get("https://www.youtube.com");
       String actualTitle=driver.getTitle();
       String expectedTitleIcerik="best";
       if (!actualTitle.contains(expectedTitleIcerik)){
           System.out.println("youtube baslik test passed");
       }else{
           System.out.println("youtube baslik testi failed");
       }
   }
}

