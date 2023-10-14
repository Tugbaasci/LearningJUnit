package day09_iframe_cokluWindows;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.DeviceRotation;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import utilities.TestBase;

public class C03_CokluPencere extends TestBase {
    // amazon ana sayfaya gidip url'in amazon icerdigini test edin
    // yeni bir tab'da wisequarter.com'a gidin ve url'in wise icerdigini test edin
    // yeni bir pencere olarak youtube'a gidin ve url'in youtube icerdigini test edin
    // wisequarter'in acik oldugu sayfaya donup title'in Wise icerdigini test edin
    // Amazon'un acik oldugu sayfaya donun ve Title'in Amazon icerdigini test edin
    @Test
    public void test01(){
        // amazon ana sayfaya gidip url'in amazon icerdigini test edin
       driver.get("https://www.amazon.com");
       String expectedIcerik="amazon";
       String actualUrl=driver.getCurrentUrl();
       Assert.assertTrue(actualUrl.contains(expectedIcerik));
       String amazonWHD=driver.getWindowHandle();

        // yeni bir tab'da wisequarter.com'a gidin ve url'in wise icerdigini test edin
        driver.switchTo().newWindow(WindowType.TAB);
        driver.get("https://www.wisequarter.com");
        expectedIcerik="wise";
        actualUrl= driver.getCurrentUrl();
        Assert.assertTrue(actualUrl.contains(expectedIcerik));
        String wiseWHD=driver.getWindowHandle();

        // yeni bir pencere olarak youtube'a gidin ve url'in youtube icerdigini test edin
       driver.switchTo().newWindow(WindowType.WINDOW);
       driver.get("https://Www.youtube.com");
       String actualURL= driver.getCurrentUrl();
       String expectedUrlIcerik="youtube";
       Assert.assertTrue(actualURL.contains(expectedUrlIcerik));
       String youtubeWHD= driver.getWindowHandle();

        // wisequarter'in acik oldugu sayfaya donup title'in Wise icerdigini test edin
       driver.switchTo().window(wiseWHD);
       expectedIcerik="Wise";
       String actualTitle= driver.getTitle();
       Assert.assertTrue(actualTitle.contains(expectedIcerik));

        // Amazon'un acik oldugu sayfaya donun ve Title'in Amazon icerdigini test edin
        driver.switchTo().window(amazonWHD);
        expectedIcerik="Amazon";
        actualTitle= driver.getTitle();
        Assert.assertTrue(actualTitle.contains(expectedIcerik));
    }
}
