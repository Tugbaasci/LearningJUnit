package day05_JUnitFrameWork;


import org.junit.Ignore;
import org.junit.Test;


public class C02_TestNotasyonu {
    @Test
    public  void amazontest(){
        System.out.println("amazon testi calisti");
    }
    @Ignore
    public void youtubetest(){
        System.out.println("youtube testi calisti");
    }
    public void wisetest(){
        System.out.println("wise test i calisti");
    }
    public void test04(){
        //verilen iki sayidan sayi1'in daha buyuk oldugunu test edin
        int sayi1=10;
        int syai2=50;

        if (sayi1>syai2){
            System.out.println("karsilastirma testi passed");
        }else{
            System.out.println("karsilastirma testi failed");
            throw new IllegalArgumentException();
        }
    }
}
