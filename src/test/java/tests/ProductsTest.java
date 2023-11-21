package tests;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class ProductsTest extends BaseTest {

    @Test(description = "Check if any products can buy") //description необходим для красивых отчетов
    public void buyProduct() {

        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
        productsPage.addToCart("Sauce Labs Bike Light");
        //productsPage.addToCart("Sauce Labs Bike Light");
        productsPage.openCart();
        String productName = driver.findElement(By.cssSelector(".inventory_item_name")).getText();
        assertEquals(productName, "Sauce Labs Bike Light", "Error, Product not found!");
        String productPrice = driver.findElement(By.cssSelector(".inventory_item_price")).getText();
        assertEquals(productPrice, "$9.99", "Wrong price!");
    }
}