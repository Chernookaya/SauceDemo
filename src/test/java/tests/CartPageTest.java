package tests;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class CartPageTest extends BaseTest {

    @Test(description = "Check if products delete from cart")
    public void deleteProduct() {
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
        ;
        productsPage.addToCart("Sauce Labs Bike Light");
        productsPage.openCart();
        cartPage.deleteProduct("Sauce Labs Bike Light");
        assertEquals(cartPage.getNumberOfProducts(), 0, "Product not deleted");
    }
}
