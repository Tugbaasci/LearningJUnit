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

public class sonraBak extends TestBase {
    @Test
    public void test01() {
        //Test01 :
        //1- amazon gidin
        driver.get("https://www.amazon.com");
        //2- Arama kutusunun solundaki dropdown menuyu handle edip listesini ekrana yazdırın
        WebElement dropdownMenu= driver.findElement(By.xpath("//select[@title='Search in']"));
        dropdownMenu.click();
        //3- dropdown menude 40 eleman olduğunu doğrulayın
        Select select = new Select(dropdownMenu);
        List<WebElement> optionsList= select.getOptions();
        for (WebElement each:optionsList) {
            System.out.println(each.getText());
        }
        int expectedOptionSayisi=40;
        int actualOptionSayisi=optionsList.size();
        Assert.assertEquals(expectedOptionSayisi,actualOptionSayisi);
    }
    @Test
    public void test02(){
        //Test02
        driver.get("https://www.amazon.com");
        //1- dropdown menuden elektronik bölümü seçin
        WebElement dropdownMenu= driver.findElement(By.xpath("//select[@title='Search in']"));
        Select select = new Select(dropdownMenu);
        List<WebElement> optionsList= select.getOptions();
        for (WebElement each:optionsList) {
            if (each.getText().equals("Electronics")){
                each.click();
            }
        }
        //2- arama kutusuna iphone yazip aratin ve bulunan sonuç sayısını yazdırın
        WebElement aramaKutusu= driver.findElement(By.id("twotabsearchtextbox"));
        aramaKutusu.sendKeys("iphone"+ Keys.ENTER);
        WebElement sonucYazisi=driver.findElement(By.xpath("(//div[@class='a-section a-spacing-small a-spacing-top-small'])[1]"));
        System.out.println("Iphone icin sonuc sayisi: "+sonucYazisi.getText());
        //3- sonuc sayisi bildiren yazinin iphone icerdigini test edin
        String expectedIcerik="iphone";
        String actualSonuc= sonucYazisi.getText();
        Assert.assertTrue(actualSonuc.contains(expectedIcerik));

        //4- ikinci ürüne relative locater kullanarak tıklayin
        WebElement ilkUrun=driver.findElement(By.xpath("(//div[@class='a-section a-spacing-base'])[1]"));
        WebElement ikinciUrun=driver.findElement(RelativeLocator.with(By.tagName("div")).toRightOf(ilkUrun));
        ikinciUrun.click();
        //5- ürünün title'ni ve fiyatını variable’a assign edip ürünü sepete ekleyelim
        WebElement ikinciUrunTitle=driver.findElement(By.xpath("//h1[@class='a-size-large a-spacing-none']"));
        String urunTitle=ikinciUrunTitle.getText();
        //WebElement ikiUrunFiyat=driver.findElement(By.xpath(""))
    }
    @Test
    public void test03(){
        //Test03
        //1- yeni bir sekme açarak amazon anasayfaya gidin
        driver.switchTo().newWindow(WindowType.TAB);
        driver.get("https://www.amazon.com");

        //2-dropdown’dan bebek bölümüne secin
        WebElement dropdownMenu= driver.findElement(By.xpath("//select[@id='searchDropdownBox']"));
        Select select = new Select(dropdownMenu);
        select.selectByVisibleText("Baby");

        //3-bebek puset aratıp bulunan sonuç sayısını yazdırın
        WebElement aramaKutusu= driver.findElement(By.id("twotabsearchtextbox"));
        aramaKutusu.sendKeys("baby stroller"+Keys.ENTER);
        WebElement sonucYazisi=driver.findElement(By.xpath("(//div[@class='a-section a-spacing-small a-spacing-top-small'])[1]"));
        System.out.println("Bebek puseti icin arama sonucu: "+sonucYazisi.getText());
        //4-sonuç yazsının puset içerdiğini test edin
        String expectedIcerik="stroller";
        String actualsonuc= sonucYazisi.getText();
        Assert.assertTrue(actualsonuc.contains(expectedIcerik));
        //5-üçüncü ürüne relative locater kullanarak tıklayin
        WebElement ikinciUrun=driver.findElement(By.xpath("(//div[@class='a-section aok-relative s-image-fixed-height'])[2]"));
        WebElement birinciUrun=driver.findElement(RelativeLocator.with(By.tagName("div")).above(ikinciUrun));
        birinciUrun.click();
        //6-title ve fiyat bilgilerini assign edelim ve ürünü sepete ekleyin
        WebElement urunEtiket=driver.findElement(By.xpath("//span[@id='productTitle']"));
        WebElement urunFiyat=driver.findElement(By.xpath("//span[@class='a-price a-text-price a-size-medium apexPriceToPay']"));
        WebElement sepeteEkle=driver.findElement(By.xpath("//input[@*='exportsUndeliverable-cart-announce']"));
        sepeteEkle.click();
        //Test 4
        //1-sepetteki ürünlerle eklediğimiz ürünlerin aynı olduğunu isim ve fiyat olarak doğrulayın
    }
}
