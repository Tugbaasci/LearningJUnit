package day14_writeExcel_ScreenShot_jsExecutor;

import org.apache.poi.ss.usermodel.*;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class C01_WriteExcel {
    //3) Adimlari takip ederek 1.sayfa 1.satira kadar gidelim
    //4) 5.hucreye yeni bir cell olusturalim
    //5) Olusturdugumuz hucreye “Nufus” yazdiralim
    //6) 2.satir nufus kolonuna 1500000 yazdiralim
    //7) 10.satir nufus kolonuna 250000 yazdiralim
    //8) 15.satir nufus kolonuna 54000 yazdiralim
    //9) Dosyayi kaydedelim
    //10)Dosyayi kapatalim
    /*@Test
    public void test01() throws IOException {
    String dosyaYolu="src/test/java/day13_ExcelOtomasyonu/ulkeler.xlsx";
    FileInputStream fis=new FileInputStream(dosyaYolu);
    Workbook workbook = WorkbookFactory.create(fis);
    Sheet sayfa1 = workbook.getSheet("Sayfa1");
    sayfa1.getRow(0).createCell(4);
    sayfa1.getRow(0).getCell(4).setCellValue("Nufus");
    sayfa1.getRow(1).createCell(4).setCellValue("1500000");
    sayfa1.getRow(9).createCell(4).setCellValue("250000");
    sayfa1.getRow(14).createCell(4).setCellValue("54000");
    FileOutputStream fos = new FileOutputStream(dosyaYolu);
    workbook.write(fos);
    fis.close();
    fos.close();
    workbook.close();}*/
    @Test
    public void test1() throws IOException {
        String dosyaYolu="src/test/java/day13_ExcelOtomasyonu/ulkeler.xlsx";
        FileInputStream fis = new FileInputStream(dosyaYolu);
        Workbook workbook = WorkbookFactory.create(fis);
        Sheet sayfa1 = workbook.getSheet("Sayfa1");
        sayfa1.getRow(0).createCell(5);
        sayfa1.getRow(1).createCell(5).setCellValue("100000");
        sayfa1.getRow(2).createCell(5).setCellValue("100000");
        sayfa1.getRow(3).createCell(5).setCellValue("10000");
        FileOutputStream fos = new FileOutputStream(dosyaYolu);
        workbook.write(fos);
        fis.close();
        fos.close();
        workbook.close();

    }



}
