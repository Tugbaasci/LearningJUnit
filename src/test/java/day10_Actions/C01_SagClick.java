package day10_Actions;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

import java.io.StringReader;
import java.lang.annotation.Target;
import java.util.Set;

public class C01_SagClick extends TestBase {
    @Test
    public void test01(){
    // 2- https://the-internet.herokuapp.com/context_menu sitesine gidin
        driver.get("https://the-internet.herokuapp.com/context_menu");
        String ilkSayfawhd= driver.getWindowHandle();
    // 3- Cizili alan uzerinde sag click yapin
        WebElement ciziliAlan= driver.findElement(By.id("hot-spot"));
        Actions actions = new Actions(driver);
        actions.contextClick(ciziliAlan).perform();

    // 4- Alert'te cikan yazinin "You selected a context menu" oldugunu test edin
        String actualAlertYazi=driver.switchTo().alert().getText();
        String expected="You selected a context menu";
        Assert.assertEquals(expected,actualAlertYazi);
    // 5- Tamam diyerek alert'i kapatalim
        driver.switchTo().alert().accept();

    // 6- Elemental Selenium linkine tiklayalim
        WebElement elementalSelenium= driver.findElement(By.linkText("Elemental Selenium"));
        elementalSelenium.click();

    // 7- Acilan sayfada h1 taginda "Make sure your code lands" yazdigini test edelim
        Set<String> whdSet=driver.getWindowHandles();
        String ikinciSayfawhd="";
        for (String each:whdSet) {
            if (!each.equals(ilkSayfawhd)){
               ikinciSayfawhd=each;
            }
        }
        driver.switchTo().window(ikinciSayfawhd);
        WebElement baslikYazi= driver.findElement(By.tagName("h1"));
        String expectedYazi="Make sure your code lands";
        String actualYazi= baslikYazi.getText();
        Assert.assertEquals(expectedYazi,actualYazi);

    }

}
