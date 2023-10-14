package practice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class P03 {
        /*    Exercise-1:

BeforeClass ile driver'i oluşturun ve class icinde static yapin
Maximize edin ve 10 sn bekletin
http://www.qooqle.com adresine gidin
1-arama kutusuna "12 Angry Men” yaz ip, cikan sonuc şayisini yazdinin
2-arama kutusuna "Vizontele” yaz ip, cikan sonuc şayisini yazdirin
3-arama kutusuna "Saving Private Ryan” yaz4p, cikan sonuc şayisini yazdirin
AfterClass ile kapatin.
     */
    static WebDriver driver;
    @BeforeClass
    public static void setup(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }
    @Before
    public void befor(){
        driver.get("https://www.google.com");
    }
    @After
    public void after(){

    }
    //@AfterClass
    //public static void teardown(){
    //    driver.close();
    //}
    @Test
    public void test01(){
        //cookie kabul et
        driver.findElement(By.xpath("//button[@id='L2AGLb']")).click();
        driver.findElement(By.xpath("//textarea[@id='APjFqb']")).sendKeys("12 Angry Men"+ Keys.ENTER);
        WebElement sonucYazisi=driver.findElement(By.xpath("//div[@id='result-stats']"));
        System.out.println(sonucYazisi.getText());
        driver.findElement(By.xpath("//textarea[@id='APjFqb']")).sendKeys("Vizontele"+ Keys.ENTER);
        sonucYazisi= driver.findElement(By.xpath("//div[@id='result-stats']"+Keys.ENTER));



    }
}
