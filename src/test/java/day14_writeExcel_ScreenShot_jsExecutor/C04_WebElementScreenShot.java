package day14_writeExcel_ScreenShot_jsExecutor;

import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import utilities.ReusableMethods;
import utilities.TestBase;

import java.io.File;
import java.io.IOException;

public class C04_WebElementScreenShot extends TestBase {
    @Test
    public void test01() throws IOException {
    //amazona gidin
    //Nutella icin arama yapin
    //Sonuclarin Nutella icerdigini test edelim
    //Rapora eklemek icin sonuc yazisinin screenshot'ini alin
        driver.get("https://www.amazon.com");
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Nutella"+ Keys.ENTER);
        WebElement actualSonuc=driver.findElement(By.xpath("//div[@class='a-section a-spacing-small a-spacing-top-small']"));
        String actualSonucYazisi=actualSonuc.getText();
        String expectedIcerik="Nutella";
        Assert.assertTrue(actualSonucYazisi.contains(expectedIcerik));
        File sonucYazisi= new File("target/screenShots/sonucYazisi.jpg");
        File gecici = actualSonuc.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(gecici,sonucYazisi);
        ReusableMethods.webElementFotoCek(actualSonuc,"NutellaArama");
    }
}
