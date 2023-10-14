package day09_iframe_cokluWindows;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.TestBase;

import java.util.Set;

public class C05_KontrolsuzCokluSayfa extends TestBase {
    @Test
    public void test01(){
        // https://the-internet.herokuapp.com/iframe url'ine gidin
        driver.get("https://the-internet.herokuapp.com/iframe");

        // sayfa basliginin Internet icerdigini test edin
        String actualTitle=driver.getTitle();
        String expectedTitleParca="Internet";
        Assert.assertTrue(actualTitle.contains(expectedTitleParca));

        // Elemental Selenium linkini tiklayin
        driver.findElement(By.linkText("Elemental Selenium")).click();
        String ilkSayfawhd=driver.getWindowHandle();

        // Yeni acilan tab'in Title'inin Selenium icerdigini test edin
        Set<String> whdSet= driver.getWindowHandles();
        String ikinciSayfawhd="";
        for (String each:whdSet) {
            if (!ilkSayfawhd.equals(each)){
                ikinciSayfawhd=each;
            }
        }
        driver.switchTo().window(ikinciSayfawhd);
        String expectedtitleParca="Selenium";
        String actualTitle2=driver.getTitle();
        Assert.assertTrue(actualTitle2.contains(expectedtitleParca));

        // Ilk sayfaya donup url'in internet icerdigini test edin
        driver.switchTo().window(ilkSayfawhd);
        String ilkUrl="internet";
        String actualUrl=driver.getCurrentUrl();
        Assert.assertTrue(actualUrl.contains(ilkUrl));
    }

}
