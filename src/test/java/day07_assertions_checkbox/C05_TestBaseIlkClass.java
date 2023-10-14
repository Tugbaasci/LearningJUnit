package day07_assertions_checkbox;

import org.junit.Test;
import utilities.ReusableMethods;
import utilities.TestBase;

public class C05_TestBaseIlkClass extends TestBase {
    @Test
    public void test01(){
        driver.get("https://www.amazon.com");
        bekle(3);
    }
}
