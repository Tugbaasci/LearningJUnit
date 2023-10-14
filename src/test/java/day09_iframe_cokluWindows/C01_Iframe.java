package day09_iframe_cokluWindows;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class C01_Iframe extends TestBase {
   /*
   1 ) https://the-internet.herokuapp.com/iframe adresine gidin.
   2) Bir metod olusturun: iframeTest
    - “An IFrame containing….” textinin erisilebilir oldugunu test edin ve  konsolda yazdirin.
    - Text Box’a “Merhaba Dunya!” yazin.
    - TextBox’in altinda bulunan “Elemental Selenium” linkini textinin gorunur oldugunu dogrulayin ve  konsolda yazdirin.
    */

    @Test
    public void test01(){
        //1 ) https://the-internet.herokuapp.com/iframe adresine gidin.
        driver.get("https://the-internet.herokuapp.com/iframe");
        //2) Bir metod olusturun: iframeTest
        //      - “An IFrame containing….” textinin erisilebilir oldugunu test edin ve  konsolda yazdirin.
        WebElement iframeYaziElementi=driver.findElement(By.tagName("h3"));
        Assert.assertTrue(iframeYaziElementi.isEnabled());
        //- Text Box’a “Merhaba Dunya!” yazin.
        WebElement iframe= driver.findElement(By.xpath("//*[@id='mce_0_ifr']"));
        driver.switchTo().frame(iframe);
        WebElement textBox= driver.findElement(By.tagName("p"));
        textBox.clear();
        textBox.sendKeys("Merhaba Dunya");
        driver.switchTo().defaultContent();

        //- TextBox’in altinda bulunan “Elemental Selenium” linkini textinin gorunur oldugunu dogrulayin ve  konsolda yazdirin.
        WebElement elemenalLinki= driver.findElement(By.linkText("Elemental Selenium"));
        Assert.assertTrue(elemenalLinki.isDisplayed());
        System.out.println(elemenalLinki.getText());

        bekle(2);
    }

}
