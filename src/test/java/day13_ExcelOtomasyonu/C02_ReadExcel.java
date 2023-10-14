package day13_ExcelOtomasyonu;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.Assert;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class C02_ReadExcel {
    @Test
    public void test01() throws IOException {
        //ilgili ayarlari yapip, workbook'u olusturun
        //2.sayfaya gidin
        //kullanilan en son satirin 24.satir old. test edin
        //fiziki kullanilan satir sayisinin 8 old test edin
        String dosyaYolu="src/test/java/day13_ExcelOtomasyonu/ulkeler1.xlsx";
        FileInputStream fis= new FileInputStream(dosyaYolu);
        Workbook workbook = WorkbookFactory.create(fis);

        Sheet sayfa2= workbook.getSheet("Sayfa2");
        int expectedSonSatirNo=24;
        int actualSonSatirNo= sayfa2.getLastRowNum()+1;
        Assert.assertEquals(expectedSonSatirNo,actualSonSatirNo);

        int expectedFizikiSatirSayisi=8;
        int actualFizikiSatirSayisi=sayfa2.getPhysicalNumberOfRows();//Kullanilmis satir Satir sayisi
        Assert.assertEquals(expectedFizikiSatirSayisi,actualFizikiSatirSayisi);


    }
}
