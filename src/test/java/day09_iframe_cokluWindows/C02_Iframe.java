package day09_iframe_cokluWindows;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.sql.SQLOutput;
import java.util.List;

public class C02_Iframe extends TestBase{
    //1) http://demo.guru99.com/test/guru99home/ sitesine gidiniz
    //2) sayfadaki iframe sayısını bulunuz.
    //3) ilk iframe'deki (Youtube) play butonuna tıklayınız.
    //4) ilk iframe'den çıkıp ana sayfaya dönünüz
    //5) ikinci iframe'deki (Jmeter Made Easy) linke
    // (https://www.guru99.com/live-selenium-project.html) tıklayınız
    @Test
    public void test01(){
       //1) http://demo.guru99.com/test/guru99home/ sitesine gidiniz
        driver.get("http://demo.guru99.com/test/guru99home/");
        //cookies cikinca iframe'in icine girin
        //WebElement cookiesIframe= driver.findElement(By.id("gdpr-consent-notice"));
        //driver.switchTo().frame(cookiesIframe).click();
        //cookies kabul edin, bende cikmadi
        //driver.findElement(By.xpath("//*[text()='Accept All]'")).click();

        //2) sayfadaki iframe sayısını bulunuz.
        List<WebElement> iFrameList=driver.findElements(By.tagName("iframe"));
        System.out.println("Sayfadaki iframe sayisi: "+iFrameList.size());

        //3) ilk iframe'deki (Youtube) play butonuna tıklayınız.
        WebElement youtubeIframe= driver.findElement(By.xpath("//iframe[@wmode='transparent']"));
        driver.switchTo().frame(youtubeIframe);
        WebElement youtubeButton=driver.findElement(By.xpath("//button[@aria-label='Play']"));
        youtubeButton.click();

        //4) ilk iframe'den çıkıp ana sayfaya dönünüz
        driver.switchTo().defaultContent();

        //5) ikinci iframe'deki (Jmeter Made Easy) linke
        // (https://www.guru99.com/live-selenium-project.html) tıklayınız
        WebElement Jmeter= driver.findElement(By.id("a077aa5e"));
        driver.switchTo().frame(Jmeter);
        driver.findElement(By.xpath("//img[@src='Jmeter720.png']")).click();


    }
}
