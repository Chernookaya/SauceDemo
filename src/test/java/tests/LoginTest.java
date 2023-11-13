package tests;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class LoginTest extends BaseTest {


    @Test
    public void successfulLogin() {

        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
        assertEquals(
                productsPage.getTitle(),
                "Products",
                "User is not logged in or page is opened");
    }

    @Test
    public void emptyFields() {
        loginPage.open();
        loginPage.login("", "");
        assertEquals(loginPage.getErrorMessage(),
                "Epic sadface: Username is required", "ERROR");
    }

    @Test
    public void wrongPassword() {
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
        assertEquals(loginPage.getErrorMessage(),
                "Epic sadface: Username and password do not match any user in this service", "ERROR");
    }

    @Test
    public void lockedUser() {
        loginPage.open();
        loginPage.login("locked_out_user", "secret_sauce");
        assertEquals(loginPage.getErrorMessage(),
                "Epic sadface: Sorry, this user has been locked out.", "ERROR");
    }
}