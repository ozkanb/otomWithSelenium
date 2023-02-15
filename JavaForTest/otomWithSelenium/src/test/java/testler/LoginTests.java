package testler;

import org.checkerframework.checker.units.qual.C;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import sayfalar.AnaSayfa;
import sayfalar.GirisYapSayfasi;

import java.time.Duration;

public class LoginTests {

    private WebDriver driver;
    private AnaSayfa anaSayfa;
    private GirisYapSayfasi girisYapSayfasi;

    @BeforeEach
    void setup(){
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        anaSayfa = new AnaSayfa(driver);
        girisYapSayfasi = new GirisYapSayfasi(driver);
        driver.get("https://www.hepsiburada.com");
    }
    @Test
    void hepsiburadaLoginTesti() throws InterruptedException {

        //wait.until((ExpectedConditions.presenceOfElementLocated(By.id("myAccount"))));
        anaSayfa.elemetGozukeneKadarBekle(anaSayfa.hesabim);
        //driver.findElement(By.id("myAccount")).click();
        anaSayfa.tusaBas(anaSayfa.hesabim);

        //wait.until((ExpectedConditions.presenceOfElementLocated(By.id("login"))));
        anaSayfa.elemetGozukeneKadarBekle(anaSayfa.girisYap);
        //driver.findElement(By.id("login")).click();
        anaSayfa.tusaBas(anaSayfa.girisYap);

        //wait.until((ExpectedConditions.presenceOfElementLocated(By.id("txtUserName"))));
        girisYapSayfasi.elemetGozukeneKadarBekle(girisYapSayfasi.email);
        //driver.findElement(By.id("txtUserName")).sendKeys("e-mail");
        girisYapSayfasi.alanaTxtGirisi(girisYapSayfasi.email, "e-mail");

        //wait.until((ExpectedConditions.presenceOfElementLocated(By.id("btnLogin"))));
        girisYapSayfasi.elemetGozukeneKadarBekle(girisYapSayfasi.girisYapTusu);
        girisYapSayfasi.tusaBas(girisYapSayfasi.girisYapTusu);
        Thread.sleep(5000);
    }
    @Test
    public void urunAramaAlaniTesti(){
        anaSayfa.elemetGozukeneKadarBekleCss(anaSayfa.urunArama);
        anaSayfa.alanaTxtGirisiCss(anaSayfa.urunArama, "Araba");
        anaSayfa.klavyeTusunaBas(anaSayfa.urunArama, Keys.ENTER);
    }
    @AfterEach
    void teardown(){
        driver.close();
    }
}
