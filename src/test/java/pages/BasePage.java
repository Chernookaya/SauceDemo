package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Listeners;
import tests.TestListener;

public abstract class BasePage {
    final String BASE_URL = "https://www.saucedemo.com/";
    WebDriverWait wait;
    WebDriver driver;

    BasePage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver,20);
        //WebElement element = driver.findElement(By.id());
        //wait.until(ExpectedConditions.visibilityOfElementLocated())
    }
}
