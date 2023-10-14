package team1_Sorular;

import org.junit.Test;
import org.openqa.selenium.Cookie;
import utilities.TestBase;

import java.util.Set;

public class T02_Cookies extends TestBase {
    @Test
    public  void test01(){
        //  1- Amazon anasayfaya gidin
        //  2- Tum cookie’leri listeleyin
        //  3- Sayfadaki cookies sayisinin 3’den buyuk oldugunu test edin
        //  4- ismi "skin" olan cookie degerinin "noskin" oldugunu test edin
        //  5- ismi “the best” ve degeri “kakaolu” olan bir cookie olusturun ve sayfaya ekleyin
        //  6- Eklenen cookie’nin sayfaya eklendigini test edin
        //  7- ismi "skin" olan cookie’yi silin ve silindigini test edin
        //  8- tum cookie’leri silin ve silindigini test edin
        driver.get("https://www.amazon.com");
        Set<Cookie> cookieSet= driver.manage().getCookies();


    }
}
