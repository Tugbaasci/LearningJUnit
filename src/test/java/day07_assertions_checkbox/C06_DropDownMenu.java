package day07_assertions_checkbox;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import utilities.TestBase;

public class C06_DropDownMenu extends TestBase {
    @Test
    public void test01(){
        driver.get("https://www.amazon.com");
        WebElement dropdownElement= driver.findElement(By.xpath("//select[@title='Search in']"));
        Select select = new Select(dropdownElement);
        select.selectByValue("search-alias=arts-crafts-intl-ship");
        select.selectByIndex(3);
        select.selectByVisibleText("Automotive");
    }
}
