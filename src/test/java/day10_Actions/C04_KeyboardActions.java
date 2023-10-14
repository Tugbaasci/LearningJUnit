package day10_Actions;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

import java.security.Key;

public class C04_KeyboardActions extends TestBase {
    //2- https://www.amazon.com sayfasina gidelim
    //3- Arama kutusuna actions method’larini kullanarak Samsung A71 yazdirin ve Enter’a basarak arama yaptirin
    //4- aramanin gerceklestigini test edin
    @Test
    public void test01(){
        driver.get("https://www.amazon.com");
        WebElement aramaKutusu= driver.findElement(By.id("twotabsearchtextbox"));
        aramaKutusu.click();
        Actions actions = new Actions(driver);
        actions.keyDown(Keys.SHIFT).sendKeys("S").keyUp(Keys.SHIFT).sendKeys("amsung").sendKeys(" ")
                .keyDown(Keys.SHIFT).sendKeys("a").keyUp(Keys.SHIFT).sendKeys("71").sendKeys(Keys.ENTER).perform();
        WebElement aramaSonuc= driver.findElement(By.xpath("(//div[@class='a-section a-spacing-small a-spacing-top-small'])[1]"));
        String actualYazi= aramaSonuc.getText();
        String expectedIcerik="Samsung A71";
        Assert.assertTrue(actualYazi.contains(expectedIcerik));
    }
}
