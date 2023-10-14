package day09_iframe_cokluWindows;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.util.Set;

public class C04_KontrolsuzCokluWindow extends TestBase {
    /*
    ● https://the-internet.herokuapp.com/windows adresine gidin.
● Sayfadaki textin “Opening a new window” olduğunu doğrulayın.
● Sayfa başlığının(title) “The Internet” olduğunu doğrulayın.
● Click Here butonuna basın.
● Acilan yeni pencerenin sayfa başlığının (title) “New Window” oldugunu dogrulayin.
● Sayfadaki textin “New Window” olduğunu doğrulayın.
● Bir önceki pencereye geri döndükten sonra sayfa başlığının “The Internet” olduğunu doğrulayın.
     */

    @Test
    public void test01(){
     //https://the-internet.herokuapp.com/windows adresine gidin.
     driver.get("https://the-internet.herokuapp.com/windows");
     String ilkSyfawhd= driver.getWindowHandle();
     bekle(2);

     //Sayfadaki textin “Opening a new window” olduğunu doğrulayın.
     String actualYazi=driver.findElement(By.tagName("h3")).getText();
     String expectedYazi="Opening a new window";
     Assert.assertEquals(expectedYazi,actualYazi);
        bekle(2);


     //Sayfa başlığının(title) “The Internet” olduğunu doğrulayın.
     String expectedTitle="The Internet";
     String actualTitle= driver.getTitle();
     Assert.assertEquals(expectedTitle,actualTitle);
        bekle(2);


     //Click Here butonuna basın.
    driver.findElement(By.linkText("Click Here")).click();
        bekle(2);


    //Acilan yeni pencerenin sayfa başlığının (title) “New Window” oldugunu dogrulayin.
    Set<String> whdSeti= driver.getWindowHandles();
    String ikinciwhd="";
        for (String each: whdSeti) {
            if (!each.equals(ilkSyfawhd)){
                ikinciwhd=each;
            }
        }
        driver.switchTo().window(ikinciwhd);
        String actualTitle2=driver.getTitle();
        String expecetdTitle2="New Window";
        Assert.assertEquals(expecetdTitle2,actualTitle2);
        bekle(2);


    // Bir önceki pencereye geri döndükten sonra sayfa başlığının “The Internet” olduğunu doğrulayın.
    driver.switchTo().window(ilkSyfawhd);
    String expectedTitle3="The Internet";
    String actualTitle3= driver.getTitle();
    Assert.assertEquals(expectedTitle3,actualTitle3);
        bekle(2);


    }
}
