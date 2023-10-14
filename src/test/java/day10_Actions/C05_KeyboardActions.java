package day10_Actions;

import com.github.javafaker.Faker;
import org.checkerframework.checker.units.qual.K;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class C05_KeyboardActions extends TestBase {

    @Test
    public void test01(){
    //1- https://www.facebook.com adresine gidelim
    //2- Cookies kabul edin
    //3- Yeni hesap olustur butonuna basalim
    //4- Ad, soyad, mail ve sifre kutularina deger yazalim ve kaydol tusuna basalim
    //5- Kaydol tusuna basalim
        driver.get("https://www.facebook.com");
        WebElement cookieAccept= driver.findElement(By.xpath("//button[text()='Allow all cookies']"));
        cookieAccept.click();
        driver.findElement(By.xpath("//a[text()='Create new account']")).click();
        WebElement nameAlan= driver.findElement(By.name("firstname"));

       Actions actions = new Actions(driver);
       Faker faker = new Faker();
       String email=faker.internet().emailAddress();
       actions.click(nameAlan).sendKeys(faker.name().firstName()).sendKeys(Keys.TAB)
               .sendKeys(faker.name().lastName()).sendKeys(Keys.TAB).sendKeys(email)
               .sendKeys(Keys.TAB).sendKeys(email).sendKeys(Keys.TAB)
               .sendKeys(faker.internet().password()).sendKeys(Keys.TAB)
               .sendKeys(Keys.TAB).sendKeys("22").sendKeys(Keys.TAB)
               .sendKeys("Feb").sendKeys(Keys.TAB).sendKeys("1984")
               .sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys(Keys.ARROW_RIGHT).sendKeys(Keys.ARROW_LEFT).perform();
       driver.findElement(By.name("websubmit")).click();
       bekle(2);

    }
}
