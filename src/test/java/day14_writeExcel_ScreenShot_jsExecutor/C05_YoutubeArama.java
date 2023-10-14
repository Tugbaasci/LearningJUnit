package day14_writeExcel_ScreenShot_jsExecutor;

import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.*;
import utilities.TestBase;

import java.io.File;
import java.io.IOException;

public class C05_YoutubeArama extends TestBase {
    @Test
    public void test01() throws IOException {
    //youtube anasayfaya gidin
    driver.get("https://www.youtube.com");
    //cookies kabul edin
    driver.findElement(By.xpath("(//div[@class='yt-spec-touch-feedback-shape__fill'])[14]")).click();
    bekle(2);
    WebElement youtubeAramaKutusu=driver.findElement(By.xpath("//input[@id='search']"));
    youtubeAramaKutusu.click();
    youtubeAramaKutusu.sendKeys("ahmet bulutluoz"+Keys.ENTER);
    WebElement ilkVideoTitle=driver.findElement(By.xpath("//a[@title='QA - SDET Tanıtım Programı']"));
    String actualtitle= ilkVideoTitle.getText();
    String expectedIcerik="SDET";
    Assert.assertTrue(actualtitle.contains(expectedIcerik));
        TakesScreenshot tss = (TakesScreenshot) driver;
        File kaynak= new File("target/screenShots/bulutArama.jpg");
        File gecici = tss.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(gecici,kaynak);
    }
}
