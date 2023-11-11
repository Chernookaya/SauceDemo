import org.openqa.selenium.By;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class ProductsTest extends BaseTest {
    public static final String BASE_URL = "https://www.saucedemo.com";

    @Test
    public void buyProduct() {
        driver.get(BASE_URL);
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();
        driver.findElement(By.xpath("//*[text()='Sauce Labs Bike Light']" +
                "/ancestor::*[@class='inventory_item']//button")).click();

        driver.findElement(By.id("shopping_cart_container")).click();
        String productName = driver.findElement(By.cssSelector(".inventory_item_name")).getText();
        assertEquals(productName, "Sauce Labs Bike Light", "Error, Product not found!");
        String productPrice = driver.findElement(By.cssSelector(".inventory_item_price")).getText();
        assertEquals(productPrice, "$9.99", "Wrong price!");
    }
}