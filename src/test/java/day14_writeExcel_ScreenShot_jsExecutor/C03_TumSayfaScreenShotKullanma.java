package day14_writeExcel_ScreenShot_jsExecutor;

import org.junit.Assert;
import org.junit.Test;
import utilities.ReusableMethods;
import utilities.TestBase;

public class C03_TumSayfaScreenShotKullanma extends TestBase {
    @Test
    public void test01(){
        //wisequarter anasayfaya gidin,
        driver.get("https://www.wisequarter.com");
        //url'in wise icerdigini test edin
        String actualTitle=driver.getCurrentUrl();
        String expectedIcerik="wise";
        Assert.assertTrue(actualTitle.contains(expectedIcerik));
        //sonucu raporlamak icin tum sayfa screen shot alip kaydedin
        ReusableMethods.tumSayfaFotografCek(driver,"WQ");

    }
    @Test
    public void test02(){
        //ahmet bulutluoz anasayfaya gidin,
        driver.get("https://www.ahmetbulutluoz.com");
        //url'in bulut icerdigini test edin
        String actualUrl=driver.getCurrentUrl();
        String expectedIcerik="bulut";
        Assert.assertTrue(actualUrl.contains(expectedIcerik));
        //sonucu raporlamak icin tum sayfa screen shot alip kaydedin
        ReusableMethods.tumSayfaFotografCek(driver,"bulutluoz");
    }
    @Test
    public void test03(){
        //youtube anasayfaya gidin,
        driver.get("https://www.youtube.com");
        //url'in youtube icerdigini test edin
        String actualUrl=driver.getCurrentUrl();
        String expectedIcerik="youtube";
        Assert.assertTrue(actualUrl.contains(expectedIcerik));
        //sonucu raporlamak icin tum sayfa screen shot alip kaydedin
        ReusableMethods.tumSayfaFotografCek(driver,"youtube");
    }
}

