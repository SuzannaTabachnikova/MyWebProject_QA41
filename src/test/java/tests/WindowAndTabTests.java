package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Set;

public class WindowAndTabTests {
    public static void switchTab(){
        WebDriver driver =new ChromeDriver();
        driver.get("https://demoqa.com/browser-windows");
        driver.manage().window()
                .maximize();
        String mainWindowHandler = driver.getWindowHandle();
        WebElement newButton = driver.findElement(By.xpath("//button[@id='tabButton']"));
        newButton.click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.numberOfWindowsToBe(2));
        Set<String> allWindowHands = driver.getWindowHandles();
        String newWindowHandler ="";
        for (String windowHandle: allWindowHands){
            if(!windowHandle.equals(mainWindowHandler)){
                newWindowHandler = windowHandle;
                break;
            }
        }
        driver.switchTo().window(newWindowHandler);
        WebElement newPageElement = driver.findElement(By.xpath("//h1[@id='sampleHeading']"));
        newPageElement.click();
        driver.quit();

    }
}
