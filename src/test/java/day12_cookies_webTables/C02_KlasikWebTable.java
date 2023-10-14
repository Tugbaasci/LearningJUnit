package day12_cookies_webTables;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

import java.util.List;

public class C02_KlasikWebTable extends TestBase {
    @Test
    public void test01(){
        //1.“https://www.amazon.com” adresine gidin
        driver.get("https://www.amazon.com");
        //2.Sayfanin en altina inin
        Actions actions=new Actions(driver);
        actions.sendKeys(Keys.END).perform();
        bekle(2);
        //3.Web table tum body’sini yazdirin
        System.out.println(driver.findElement(By.xpath("//tbody")).getText());
        //4.Web table’daki satir sayisinin 7 oldugunu test edin
        List<WebElement> satir=driver.findElements(By.xpath("//tbody/tr"));
        int expectedSatirSayisi=7;
        int actualSatirSayisi=satir.size();
        Assert.assertEquals(expectedSatirSayisi,actualSatirSayisi);
        //5.Tum satirlari yazdirin
        for (int i = 0; i <satir.size() ; i++) {
            System.out.println(satir.get(i).getText());
        }
        //6. Web table’daki sutun sayisinin 13 olduğunu test edin
        List<WebElement> sutun=driver.findElements(By.xpath("//tbody/tr[1]/td"));
        int expectedSutunSayisi=13;
        int actualSutunSayisi=sutun.size();
        Assert.assertEquals(expectedSutunSayisi,actualSutunSayisi);

        //7. 5.sutunu yazdirin
        List<WebElement> sutun5List=driver.findElements(By.xpath("//tbody/tr/td[5]"));
        for (WebElement each:  sutun5List) {
            System.out.println(each.getText());
        }
        //8.Satir ve sutun sayisini parametre olarak alip,
        //  hucredeki bilgiyi döndüren bir method olusturun
        System.out.println(satirSutunBilgisi(3, 5));
    }
    public String satirSutunBilgisi(int satir,int sutun){
        String dinamikXpath="//tbody/tr["+satir+"]/td["+sutun+"]";
        WebElement sorulanElement=driver.findElement(By.xpath(dinamikXpath));
        return sorulanElement.getText();
    }

}
