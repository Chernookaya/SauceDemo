package tests;

import org.testng.annotations.Test;

public class CartPageTest extends BaseTest {

    @Test
    public void deleteProduct() {
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");;
        productsPage.addToCart("Sauce Labs Bike Light");
        productsPage.openCart();
        cartPage.deleteProduct("Sauce Labs Bike Light");
    }
}
