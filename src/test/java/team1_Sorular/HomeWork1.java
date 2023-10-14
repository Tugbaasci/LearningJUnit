package team1_Sorular;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class HomeWork1 extends TestBase {
    @Test
    public void odev1(){
        //Yeni Class olusturun ActionsClassHomeWork
        //1- "http://webdriveruniversity.com/Actions" sayfasina gidin
        driver.get("http://webdriveruniversity.com/Actions");
        //2- Hover over Me First" kutusunun ustune gelin
        Actions actions = new Actions(driver);
        WebElement hoverOver= driver.findElement(By.xpath("(//button[@class='dropbtn'])[1]"));
        actions.moveToElement(hoverOver).perform();
        bekle(1);
        //3- Link 1" e tiklayin
        WebElement link1= driver.findElement(By.xpath("(//a[@class='list-alert'])[1]"));
        link1.click();
        //4- Popup mesajini yazdirin
        System.out.println("Pop up mesaji: "+driver.switchTo().alert().getText());
        bekle(2);

        //5- Popup'i tamam diyerek kapatin
        driver.switchTo().alert().accept();

        //6- “Click and hold" kutusuna basili tutun
        WebElement clickAndholdElementi= driver.findElement(By.xpath("//div[@id='click-box']"));
        actions.clickAndHold(clickAndholdElementi).perform();
        //7-“Click and hold" kutusunda cikan yaziyi yazdirin
        System.out.println("Click and hold yazisi "+clickAndholdElementi.getText());
        //8- “Double click me" butonunu cift tiklayin
        WebElement doubleClickElementi= driver.findElement(By.tagName("h2"));
        actions.doubleClick(doubleClickElementi).perform();
    }
}
