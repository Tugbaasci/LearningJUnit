package day12_cookies_webTables;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.Cookie;
import utilities.TestBase;

import java.util.Set;

public class C01_cookies extends TestBase {
@Test
    public void test01(){
    //1- Amazon anasayfaya gidin
    driver.get("https://www.amazon.com");

    //2- tum cookie’leri listeleyin
    Set<Cookie> cookieSet=driver.manage().getCookies();
    int sira=1;
    for (Cookie each:cookieSet) {
        System.out.println(sira+"- "+each);
        sira++;
    }
    //System.out.println(cookieSet);


    //3- Sayfadaki cookies sayisinin 5’den buyuk oldugunu test edin
    int expectedCookiSayisi=5;
    int actualCookieSayisi=cookieSet.size();
    Assert.assertTrue(actualCookieSayisi>expectedCookiSayisi);

    //4- ismi i18n-prefs olan cookie degerinin USD oldugunu test edin
    String expectedValue="USD";
    String cookieValue=driver.manage().getCookieNamed("i18n-prefs").getValue();
    Assert.assertEquals(expectedValue,cookieValue);

    //5- ismi “en sevdigim cookie” ve degeri “cikolatali” olan bir cookie olusturun ve sayfaya ekleyin
    Cookie cookie= new Cookie("en sevdigim cookie","cikolatali");
    driver.manage().addCookie(cookie);

    //6- eklediginiz cookie’nin sayfaya eklendigini test edin
    cookieSet=driver.manage().getCookies();
    boolean cookieEklendiMi=false;
    for (Cookie each: cookieSet) {
        if (each.getName().equals("en sevdigim cookie")){
            cookieEklendiMi=true;
        }
    }
    Assert.assertTrue(cookieEklendiMi);

    //7- ismi skin olan cookie’yi silin ve silindigini test edin
    driver.manage().deleteCookieNamed("skin");
    cookieSet=driver.manage().getCookies();
    boolean cookieSilindiMi=true;
    for (Cookie each:cookieSet) {
        if (each.getName().equals("skin")){
            cookieSilindiMi=false;
        }
    }
    Assert.assertTrue(cookieSilindiMi);

    //8- tum cookie’leri silin ve silindigini test edin
    driver.manage().deleteAllCookies();
    cookieSet=driver.manage().getCookies();
    int expectedCookieSayisi=0;
    actualCookieSayisi=cookieSet.size();
    Assert.assertEquals(expectedCookieSayisi,actualCookieSayisi);
}
}
