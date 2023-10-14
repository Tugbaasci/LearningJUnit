package day11_fileTestleri_Waits;

import org.junit.Assert;
import org.junit.Test;

import java.nio.file.Files;
import java.nio.file.Paths;

public class C02_DinamikDosyaYolu {
    @Test
    public void test01(){
        String dinamikDosyaYolu = System.getProperty("user.home") + "/Desktop/example.jpg" ;
        System.out.println(dinamikDosyaYolu);
        Assert.assertTrue(Files.exists(Paths.get(dinamikDosyaYolu)));
        //text.txt' nin dosya yolu:
        //C:\Users\41768\IdeaProjects\Team120_JUnit_Fall2023\
        // src\test\java\day11_fileTestleri_waits\text.txt
        String dinamikTextDosyayolu = System.getProperty("user.dir") +
                                "/src/test/java/day11_fileTestleri_Waits/text.txt";
        System.out.println(dinamikTextDosyayolu);
        Assert.assertTrue(Files.exists(Paths.get(dinamikTextDosyayolu)));
    }
}
