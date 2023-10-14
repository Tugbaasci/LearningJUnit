package day08_dropdownMenu_iframe;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import utilities.TestBase;
import utilities.TestBase_BeforeClass;

import java.util.List;

public class C02_dropdownMenu extends TestBase_BeforeClass {
    //  https://www.amazon.com/ adresine gidin.
    //- Test 1
    //  Arama kutusunun yanindaki kategori menusundeki kategori sayisinin
    //  45 oldugunu test edin
    //-Test 2
    //  1. Kategori menusunden Books secenegini  secin
    //  2. Arama kutusuna Java yazin ve aratin
    //  3. Bulunan sonuc sayisini yazdirin
    //  4. Sonucun Java kelimesini icerdigini test edin
    WebElement dropdownAmazon;
    Select select;
    @Before
    public void sayfayaGit(){
        driver.get("https://www.amazon.com/");
        dropdownAmazon= driver.findElement(By.xpath("//select[@id='searchDropdownBox']"));
        select = new Select(dropdownAmazon);
    }
    @Test
    public void test01(){
        //  Arama kutusunun yanindaki kategori menusundeki kategori sayisinin
        //  45 oldugunu test edin
        List<WebElement> optionsList= select.getOptions();
        int expectedSayi=45;
        int actualSayi= optionsList.size();
        Assert.assertEquals("Kategori sayisi 45 degil",expectedSayi,actualSayi);
    }
    @Test
    public void test02(){
        //  1. Kategori menusunden Books secenegini  secin
        //  2. Arama kutusuna Java yazin ve aratin
        //  3. Bulunan sonuc sayisini yazdirin
        //  4. Sonucun Java kelimesini icerdigini test edin

        //1. Kategori menusunden Books secenegini  secin
        select.selectByVisibleText("Books");

        //  2. Arama kutusuna Java yazin ve aratin
        WebElement aramakutusu=driver.findElement(By.id("twotabsearchtextbox"));
        aramakutusu.sendKeys("Java"+ Keys.ENTER);

        //  3. Bulunan sonuc sayisini yazdirin
        WebElement sonucYazisi=driver.findElement(By.xpath("(//div[@class='a-section a-spacing-small a-spacing-top-small'])[1]"));
        System.out.println(sonucYazisi.getText());

        //  4. Sonucun Java kelimesini icerdigini test edin
        String expectedIcerik="Java";
        String actualSonucYazisi=sonucYazisi.getText();
        Assert.assertTrue(actualSonucYazisi.contains(expectedIcerik));
    }
}
