package day07_assertions_checkbox;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import utilities.ReusableMethods;

import java.time.Duration;

public class C02_Assertions {
    /*
    2) https://www.youtube.com adresine gidin
    3) Aşağıdaki adları kullanarak 4 test metodu oluşturun ve gerekli testleri yapin
    ○ titleTest  => Sayfa başlığının “YouTube” oldugunu test edin
    ○ imageTest  => YouTube resminin görüntülendiğini (isDisplayed()) test edin
    ○ Search Box ’in erisilebilir oldugunu test edin (isEnabled())
    ○ wrongTitleTest => Sayfa basliginin “youtube” olmadigini dogrulayin
     */
    static WebDriver driver;
   @BeforeClass
   public static void setup(){
       WebDriverManager.chromedriver().setup();
       driver=new ChromeDriver();
       driver.manage().window().maximize();
       driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
       driver.get("https://www.youtube.com");
       WebElement cookie= driver.findElement(By.xpath("(//div[@class='yt-spec-touch-feedback-shape yt-spec-touch-feedback-shape--touch-response-inverse'])[1]"));
       cookie.click();
   }
   @AfterClass
   public static void teardown(){
    //driver.close();
   }
   @Test
    public void test01(){
     // titleTest  => Sayfa başlığının “YouTube” oldugunu test edin
     String youtubeTitle=driver.getTitle();
     String expected="YouTube";
     Assert.assertEquals(expected,youtubeTitle);
   }
   @Test
    public void test02(){
    //imageTest  => YouTube resminin görüntülendiğini (isDisplayed()) test edin
    WebElement youtubeLogo=driver.findElement(By.xpath("(//a[@class='yt-simple-endpoint style-scope ytd-topbar-logo-renderer'])[1]"));
    //WebElement logoElementi = driver.findElement(By.xpath("(//div[@class='style-scope ytd-topbar-logo-renderer'])[1]"));
    Assert.assertTrue(youtubeLogo.isDisplayed());
   }
   @Test
    public void test03() {
       //Search Box ’in erisilebilir oldugunu test edin (isEnabled())
       WebElement searchBox = driver.findElement(By.xpath("(//form[@id='search-form'])"));
       Assert.assertTrue(searchBox.isEnabled());
   }
   @Test
   public void test04(){
      //wrongTitleTest => Sayfa basliginin “youtube” olmadigini dogrulayin
      String youtubeTitle= driver.getTitle();
      String expectedIcerik="youtube";
      Assert.assertNotEquals(expectedIcerik,youtubeTitle);
   }
}