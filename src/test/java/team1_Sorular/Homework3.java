package team1_Sorular;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.support.locators.RelativeLocator;
import org.openqa.selenium.support.ui.Select;
import utilities.TestBase;

import java.util.List;

public class Homework3 extends TestBase {
    @Test
    public void test01(){
        //Test01 :
        //1- amazon gidin
        driver.get("https://www.amazon.com");
        //2- Arama kutusunun solundaki dropdown menuyu handle edip listesini ekrana yazdırın
        WebElement dropDownElement= driver.findElement(By.xpath("//select[@id='searchDropdownBox']"));
        Select select = new Select(dropDownElement);
        List<WebElement> optionsList= select.getOptions();
        int sira=1;
        for (WebElement each:optionsList) {
            System.out.println(sira+" - "+each.getText());
            sira++;
        }
        //3- dropdown menude 40 eleman olduğunu doğrulayın
        int expectedOptionSayi=40;
        int actualOptionSayi=optionsList.size();
        Assert.assertNotEquals(expectedOptionSayi,actualOptionSayi);
    }
    @Test
    public  void test02(){
        //Test02
        driver.get("https://www.amazon.com");
        //2- arama kutusuna iphone yazip aratin ve bulunan sonuç sayısını yazdırın
        WebElement aramaKutusu= driver.findElement(By.id("twotabsearchtextbox"));
        aramaKutusu.sendKeys("iphone"+Keys.ENTER);
        //3- sonuc sayisi bildiren yazinin iphone icerdigini test edin
        WebElement sonucYazisi= driver.findElement(By.xpath("(//div[@class='a-section a-spacing-small a-spacing-top-small'])[1]"));
        String expectedIcerik="iphone";
        String actualSonuc= sonucYazisi.getText();
        Assert.assertTrue(actualSonuc.contains(expectedIcerik));
        //4- ikinci ürüne relative locater kullanarak tıklayin
        WebElement ilkUrun=driver.findElement(By.xpath("(//div[@class='a-section aok-relative s-image-fixed-height'])[1]"));
        WebElement ikinciUrunElemnti=driver.findElement(RelativeLocator.with(By.tagName("img")).below(ilkUrun));
        ikinciUrunElemnti.click();
        //5- ürünün title'ni ve fiyatını variable’a assign edip ürünü sepete ekleyelim
    }

    //Test03
    //1- yeni bir sekme açarak amazon anasayfaya gidin
    //2-dropdown’dan bebek bölümüne secin
    //3-bebek puset aratıp bulunan sonuç sayısını yazdırın
    //4-sonuç yazsının puset içerdiğini test edin
    //5-üçüncü ürüne relative locater kullanarak tıklayin
    //6-title ve fiyat bilgilerini assign edelim ve ürünü sepete ekleyin
    //Test 4
    //1-sepetteki ürünlerle eklediğimiz ürünlerin aynı olduğunu isim ve fiyat olarak doğrulayın








}
