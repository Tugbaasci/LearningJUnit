package day06_notations_assertions;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C04_Assertions {
    // Amazon anasayfaya gidin, 3 farkli test metodu olusturarak
    // Asagidaki gorevleri yapin
    // 1- title'in Amazon icerdigini test edin
    // 2- Arama kutusuna Nutella yazip, aratin ve sonucun Nutella icerdigini test edin
    // 3- Arama kutusuna Java yazip, aratin ve sonucun Java icerdigini test edin
    static WebDriver driver;
    @BeforeClass
    public static void setup(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://www.amazon.com");
    }
    @AfterClass
    public static void teardown(){
        driver.close();
    }
    @Test
    public void titleTest() {
        String expectedTitle="Amazon";
        String actualTitle=driver.getTitle();
        Assert.assertTrue("title amazon icermiyor",actualTitle.contains(expectedTitle));
    }
    @Test
    public void nutellaTest(){
        WebElement aramaKutusu=driver.findElement(By.id("twotabsearchtextbox"));
        aramaKutusu.clear();
        aramaKutusu.sendKeys("Nutella"+ Keys.ENTER);
        String  sonucYazisi=driver.findElement(By.xpath("//div[@class='a-section a-spacing-small a-spacing-top-small']")).getText();
        String  expectedSonuc="Nutella";
        Assert.assertTrue(sonucYazisi.contains(expectedSonuc));
    }
    @Test
    public void javaTesti(){
        WebElement aramaKutusu=driver.findElement(By.id("twotabsearchtextbox"));
        aramaKutusu.clear();
        aramaKutusu.sendKeys("Java"+Keys.ENTER);
        String  sonucYazisi=driver.findElement(By.xpath("//div[@class='a-section a-spacing-small a-spacing-top-small']")).getText();
        String  expectedSonuc="Java";
        Assert.assertTrue(sonucYazisi.contains(expectedSonuc));
    }

}
