package day10_Actions;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class C03_MoveToElement extends TestBase {
    //1- https://www.amazon.com/ adresine gidin
    //2- Sag ust bolumde bulunan “Account & Lists” menusunun acilmasi icin mouse’u bu menunun ustune getirin
    //3- “Create a list” butonuna basin
    //4- Acilan sayfada “Your Lists” yazisi oldugunu test edin
    @Test
    public void test01(){
        driver.get("https://www.amazon.com/");
        WebElement accounts=driver.findElement(By.xpath("//a[@*='nav-link-accountList']"));
        Actions actions = new Actions(driver);
        actions.moveToElement(accounts).perform();
        WebElement createAlist=driver.findElement(By.xpath("//span[text()='Create a List']"));
        createAlist.click();
        WebElement yourLists= driver.findElement(By.id("my-lists-tab"));
        String expectedYazi="Your Lists";
        String actualYazi= yourLists.getText();
        Assert.assertEquals(expectedYazi,actualYazi);


    }
}
