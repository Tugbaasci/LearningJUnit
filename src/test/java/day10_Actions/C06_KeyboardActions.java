package day10_Actions;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class C06_KeyboardActions extends TestBase {
    @Test
    public void test01(){
        //2- https://html.com/tags/iframe/ sayfasina gidelim
        //3- video’yu gorecek kadar asagi inin
        //4- videoyu izlemek icin Play tusuna basin
        //5- videoyu calistirdiginizi test edin
        driver.get("https://html.com/tags/iframe/");
        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        bekle(3);
        WebElement iframe= driver.findElement(By.xpath("//*[@*='https://www.youtube.com/embed/owsfdh4gxyc']"));
        driver.switchTo().frame(iframe);
        bekle(1);
        WebElement playtusu= driver.findElement(By.xpath("//button[@aria-label='Play']"));
        playtusu.click();
        bekle(1);
        WebElement youtubeLogo=driver.findElement(By.xpath("//*[@title='Watch on YouTube']"));
        Assert.assertTrue(youtubeLogo.isDisplayed());
        bekle(2);
    }
}
