package day11_fileTestleri_Waits;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class C03_File_uploadTesti extends TestBase {
    @Test
    public void fileUpload(){
        //1.https://the-internet.herokuapp.com/upload adresine gidelim
        driver.get("https://the-internet.herokuapp.com/upload");

        //2.chooseFile butonuna basalim
        WebElement chooseFileButonu=driver.findElement(By.id("file-upload"));
        String dinamikYolu=System.getProperty("user.dir")+"/src/test/java/day11_fileTestleri_Waits/text.txt";
        chooseFileButonu.sendKeys(dinamikYolu);
        //3.text.txt dosyasini secelim.
        //4.Upload butonuna basalim.
        driver.findElement(By.id("file-submit")).click();
        //5.“File Uploaded!” textinin goruntulendigini test edelim.
        WebElement sonucYazi=driver.findElement(By.tagName("h3"));
        String expected="File Uploaded!";
        String actual= sonucYazi.getText();
        Assert.assertEquals(expected,actual);
    }
}
