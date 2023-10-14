package day14_writeExcel_ScreenShot_jsExecutor;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class C06_jsExecutor extends TestBase {
    @Test
    public void wiseTest(){
        //wisequarter ana sayfaya gidin
        driver.get("https://www.wisequarter.com");
        //alt kisimda bulunan "Go To Career Page" butonuna kadar asagi inin
        WebElement goToCareerElemneti=driver.findElement(By.partialLinkText("Go To Career Page"));
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        bekle(2);
        jse.executeScript("arguments[0].scrollIntoView(true);",goToCareerElemneti);
        bekle(2);
        jse.executeScript("arguments[0].click();",goToCareerElemneti);
        jse.executeScript("alert('yasasinnnn');");


    }


}
