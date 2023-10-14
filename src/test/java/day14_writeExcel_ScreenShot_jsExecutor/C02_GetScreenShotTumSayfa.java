package day14_writeExcel_ScreenShot_jsExecutor;

import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.*;
import utilities.TestBase;

import java.io.File;
import java.io.IOException;

public class C02_GetScreenShotTumSayfa extends TestBase {
    @Test
    public void tumsayfaScreenShot() throws IOException {
      //amazon anasayfaya gidin
        driver.get("https://www.amazon.com");
      //Nutella icin arama yapin
        WebElement aramaKutusu=driver.findElement(By.id("twotabsearchtextbox"));
        aramaKutusu.sendKeys("Nutella"+ Keys.ENTER);
      //Sonuclarin Nutella icerdigini test edin
      WebElement sonucYaziElementi= driver.findElement(By.xpath("//div[@class='a-section a-spacing-small a-spacing-top-small']"));
      String expectedIcerik="Nutella";
      String actualYazi=sonucYaziElementi.getText();
      Assert.assertTrue(actualYazi.contains(expectedIcerik));
        // rapor icin sayfanin fotografini cekin
        TakesScreenshot tss = (TakesScreenshot) driver;
        File tumsaySS= new File("target/Screenshot/sayfa.png");
        File gecici= tss.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(gecici,tumsaySS);
    }
}
