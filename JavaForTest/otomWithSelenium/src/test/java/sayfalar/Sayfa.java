package sayfalar;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Sayfa {
    WebDriver driver;

    public Sayfa(WebDriver driver) {
        this.driver = driver;
    }

    public void elemetGozukeneKadarBekle(String elementId){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20L));
        wait.until((ExpectedConditions.presenceOfElementLocated(By.id(elementId))));
    }

    public void tusaBas(String tusId){
        driver.findElement(By.id(tusId)).click();
    }

    public void alanaTxtGirisi(String elementId, String emailAdresi){
        driver.findElement(By.id(elementId)).sendKeys(emailAdresi);
    }
}
