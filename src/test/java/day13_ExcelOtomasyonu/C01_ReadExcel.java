package day13_ExcelOtomasyonu;

import org.apache.poi.ss.usermodel.*;
import org.junit.Assert;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;

public class C01_ReadExcel {
    @Test
    public void readExcelTest() throws IOException {
    String dosyaYolu="src/test/java/day13_ExcelOtomasyonu/ulkeler1.xlsx";
        FileInputStream fis= new FileInputStream(dosyaYolu);
        Workbook workbook = WorkbookFactory.create(fis);
        Sheet sheet= workbook.getSheet("Sayfa1");
        Row row = sheet.getRow(3);//index 0'dan basliyor
        Cell cell= row.getCell(3); //       ''
        System.out.println(cell);//Cezayir
        //1.satirdaki 2.hucreye gidelim ve yazdiralim
        System.out.println(sheet.getRow(0).getCell(1));

        //1.satirdaki 2.hucreyi bir String degiskene atayalim ve yazdiralim
        String bilgiHucre2=sheet.getRow(0).getCell(1).toString();
        System.out.println(bilgiHucre2);
        //2.satir 4.cell'in Afganistan'in baskenti Kabil old. test edelim
        String expectedData="Kabil";
        String actualData=sheet.getRow(1).getCell(3).toString();
        Assert.assertEquals(expectedData,actualData);
        //Satir sayisini bulalim
        System.out.println(sheet.getLastRowNum()+1);//index'ten dolayi 1 ekledik
        //Fiziki olarak kullanilan satir sayisini bulalim
        System.out.println(sheet.getPhysicalNumberOfRows());
        //Ingilizce ulke isimleri ve baskentleri bir map olarak kaydedelim
        String isim;
        String baskent;
        Map<String ,String> ulkelerMap=new TreeMap<>();
        for (int i = 1; i <= sheet.getLastRowNum(); i++) {
            isim=sheet.getRow(i).getCell(0).toString();
            baskent=sheet.getRow(i).getCell(1).toString();
            ulkelerMap.put(isim,baskent);
        }
        //Ulkeler excel'inde Canada isimli bir ulke old. test edin
        Assert.assertTrue(ulkelerMap.containsKey("Canada"));

        //Ulkeler excel'inde Cuba'nin baskentinin Havana old. test edin
        String expectedBaskent="Havana";
        String actualBaskent=ulkelerMap.get("Cuba").toString();
        Assert.assertEquals(expectedBaskent,actualBaskent);


    }
}
