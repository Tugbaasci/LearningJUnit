package day08_dropdownMenu_iframe;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class C03_JavaScriptAlert extends TestBase {
    @Test
    public void test01(){
        driver.get("https://www.youtube.com");
        bekle(5);
    }
    @Test
    public void test02(){
        //	-  https://the-internet.herokuapp.com/javascript_alerts adresine gidin
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");

        //	- 1.alert'e tiklayin
        driver.findElement(By.xpath("//*[text()='Click for JS Alert']")).click();

        //	-  Alert'deki yazinin "I am a JS Alert" oldugunu test edin
        String expectedYazi="I am a JS Alert";
        String actualYazi = driver.switchTo().alert().getText();
        Assert.assertEquals(expectedYazi,actualYazi);

        //	-  OK tusuna basip alert'i kapatin
        driver.switchTo().alert().accept();
    }
    @Test
    public void test03(){
        //	- https://the-internet.herokuapp.com/javascript_alerts adresine gidin
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");

        //	- 2.alert'e tiklayalim
        driver.findElement(By.xpath("//*[text()='Click for JS Confirm']")).click();

        //	- Cancel'a basip, cikan sonuc yazisinin "You clicked: Cancel" oldugunu test edin
        driver.switchTo().alert().dismiss();
        String expectedYazi="You clicked: Cancel";
        String actualYazi=driver.findElement(By.xpath("//p[@id='result']")).getText();
        Assert.assertEquals(expectedYazi,actualYazi);

    }
    @Test
    public void test04(){
        //	- https://the-internet.herokuapp.com/javascript_alerts adresine gidin
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");

        //	- 3.alert'e tiklayalim
        driver.findElement(By.xpath("//*[text()='Click for JS Prompt']")).click();

        //	- Cikan prompt ekranina "Abdullah" yazdiralim
        driver.switchTo().alert().sendKeys("Abdullah");

        //	- OK tusuna basarak alert'i kapatalim
        driver.switchTo().alert().accept();

        //	- Cikan sonuc yazisinin Abdullah icerdigini test edelim
        String expectedSonucYazi="Abdullah";
        String actualSonucYazi=driver.findElement(By.xpath("//p[@id='result']")).getText();
        Assert.assertTrue(actualSonucYazi.contains(expectedSonucYazi));
    }
}
