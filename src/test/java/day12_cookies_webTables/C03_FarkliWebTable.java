package day12_cookies_webTables;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.util.List;

public class C03_FarkliWebTable extends TestBase {
    @Test
    public void test01(){
    // 1. “https://demoqa.com/webtables” sayfasina gidin
        driver.get("https://demoqa.com/webtables");

    //  2. Headers da bulunan basliklari yazdirin
    List<WebElement> headersList = driver.findElements(By.xpath("//div[@role='columnheader']"));
        for (int i = 0; i < headersList.size(); i++) {
            System.out.println((i+1)+"- "+headersList.get(i).getText());
        }
    //  3. 3.sutunun basligini yazdirin
        WebElement title3= driver.findElement(By.xpath("(//div[@role='columnheader'])[3]"));
        System.out.println("3. sutun basligi "+title3.getText());
        //System.out.println(headersList.get(2).getText());

    //  4. Tablodaki tum datalari yazdirin
        List<WebElement> dataList=driver.findElements(By.xpath("//div[@class='rt-tbody']"));
        for (int i = 0; i < dataList.size(); i++) {
            System.out.println((i+1)+"- "+dataList.get(i).getText());
        }
    //  5. Tabloda kac tane bos olmayan cell (data) oldugunu yazdirin
        List<WebElement> dataList2=driver.findElements
                (By.xpath("((//*[@role='rowgroup']) //*[@role = 'gridcell'])"));
        int sayac=0;
        for (WebElement each:dataList2) {
            if (!each.getText().isBlank()){
                sayac++;
                System.out.println(sayac+" "+each.getText());
            }
        }
        System.out.println("Bos olmayan hucre sayisi= "+sayac);

    //  6. Tablodaki satir sayisini yazdirin
        List<WebElement> satriElementleriListesi=driver.findElements(By.xpath("//div[@role='rowgroup']"));
        System.out.println("Tablodaki satir sayisi: " + satriElementleriListesi.size());
    //  7. Tablodaki sutun sayisini yazdirin
        List<WebElement> element2Satir=driver.findElements(By.xpath("(//div[@role='rowgroup'])[2]//div[@role='gridcell']"));
        System.out.println("Tablodaki sutun sayisi= " + element2Satir.size());
    //  8. Tablodaki 3.kolonu yazdirin
        List<WebElement> kolon3List=driver.findElements(By.xpath("(//div[@role='rowgroup'])//div[@role='gridcell'][3]"));
        System.out.println("============3.Kolon==============");
        for (WebElement each: kolon3List) {
            if (!each.getText().isBlank()){
                System.out.println(each.getText());
            }
        }

    //  9. Tabloda "First Name" i Kierra olan kisinin Salary'sini yazdirin
        String dinamikIsimLocate;
        String dinamikMaasLocate;
        String isim;
        String maas;
        // (//div[@role='rowgroup'])[3]//div[@role='gridcell'][1]
        // (//div[@role='rowgroup'])[3]//div[@role='gridcell'][5]
        for (int i = 1; i < satriElementleriListesi.size(); i++) {
        dinamikIsimLocate="(//div[@role='rowgroup'])["+i+"]//div[@role='gridcell'][1]";
        dinamikMaasLocate="(//div[@role='rowgroup'])["+i+"]//div[@role='gridcell'][5]";
        isim=driver.findElement(By.xpath(dinamikIsimLocate)).getText();
        maas=driver.findElement(By.xpath(dinamikMaasLocate)).getText();
        if (isim.equals("Kierra")){
            System.out.println("Kierra'nin maasi: " + maas);
        }
        }

    // 10. bir method olusturun,satir ve sutun sayisini girdigimde bana datayi yazdirsin
        //((//*[@role=‘rowgroup’]) //*[@role = ‘gridcell’])
        //  //*[@*=‘rt-tbody’]
        // ((//*[@role=‘rowgroup’])[1] //*[@role = ‘gridcell’])[5]
        // //*[@*=‘columnheader’]
        dataYaz(3,3);
    }
    public void dataYaz(int satir,int sutun){
        String dinamikXpath="(//div[@role='rowgroup'])["+satir+"]//div[@role='gridcell']["+sutun+"]";
        WebElement aranan=driver.findElement(By.xpath(dinamikXpath));
        System.out.println(satir+".ci satir, "+sutun+".ci sutun bilgi: "+aranan.getText());
    }
}