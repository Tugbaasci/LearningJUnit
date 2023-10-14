package team1_Sorular;

import com.github.javafaker.Faker;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

import java.util.Set;

public class HandleWindow extends TestBase {
    @Test
    public void test01(){
        //1."http://webdriveruniversity.com/" adresine gidin
        driver.get("http://webdriveruniversity.com/");
        //2."Login Portal" a kadar asagi inin
        Actions actions = new Actions(driver);
        WebElement loginPortalElementi= driver.findElement(By.xpath("(//div[@class='section-title'])[2]"));
        String ilkSayfaWhd= driver.getWindowHandle();
        actions.scrollToElement(loginPortalElementi).perform();
        //3."Login Portal" a tiklayin
        loginPortalElementi.click();
        //4.Diger window'a gecin
        Set<String> sayfaWhdSet=driver.getWindowHandles();
        String ikinciSayfaWhd="";
        for (String each:sayfaWhdSet) {
            if (!each.equals(ilkSayfaWhd)){
                ikinciSayfaWhd=each;
            }
        }
        driver.switchTo().window(ikinciSayfaWhd);
        //5."username" ve "password" kutularina deger yazdirin
        Faker faker = new Faker();
        driver.findElement(By.xpath("//input[@id='text']")).sendKeys(faker.name().name());
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys(faker.internet().password());

        //6."login" butonuna basin
        driver.findElement(By.xpath("//button[@type='submit']")).click();

        //7.Popup'ta cikan yazinin "validation failed" oldugunu test edin
       String actualPopupYaziElementi= driver.switchTo().alert().getText();
       String expectedPopUpYaziElementi="validation failed";
       Assert.assertEquals(expectedPopUpYaziElementi,actualPopupYaziElementi);

        //8.Ok diyerek Popup'i kapatin
       driver.switchTo().alert().accept();

        //9.Ilk sayfaya geri donun
        driver.switchTo().window(ilkSayfaWhd);

        //10.Ilk sayfaya donuldugunu test edin
        String actualSayfaUrl= driver.getCurrentUrl();
        String expectedSayfaUrl="http://webdriveruniversity.com/";
        Assert.assertEquals(expectedSayfaUrl,actualSayfaUrl);
    }
}
