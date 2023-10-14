package team1_Sorular;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.Test;
import org.openqa.selenium.OutputType;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class T01_Excel {
    @Test
    public void test1() throws IOException {
        //Soru: isimlerden olusan bir string dizisini ülkeler.xlsx dosyasinin sayfa2,
        // 1. sütununa yukaridan asagiya dogru yazdiriniz
       String[] isimler={"Ayse","Fatma","Nuriye","Sati","Zinet"};
       String dosyaYolu="src/test/java/day13_ExcelOtomasyonu/ulkeler.xlsx";
       FileInputStream fis = new FileInputStream(dosyaYolu);
       Workbook workbook = WorkbookFactory.create(fis);
       Sheet sayfa2= workbook.getSheet("Sayfa2");
       sayfa2.getRow(0).createCell(0).setCellValue("isimler");
        for (int i = 0; i < isimler.length; i++) {
            if (sayfa2.getRow(i+1)==null){
                sayfa2.createRow(i+1);
            }
            sayfa2.getRow(i+1).createCell(0).setCellValue(isimler[i]);
        }
        FileOutputStream fos = new FileOutputStream(dosyaYolu);
        workbook.write(fos);
        fis.close();
        fos.close();
        workbook.close();


    }
}
