package tests;

import org.openqa.selenium.By;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class LoginTest extends BaseTest {


    @Test(description = "Check if user successful login")
    public void successfulLogin() {

        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
        assertEquals(
                productsPage.getTitle(),
                "Products",
                "User is not logged in or page is opened");
    }

    @DataProvider(name = "loginData") //всегда будет записываться единообразно
    public Object[][] loginData() {
        return new Object[][]{
                {"", "", "Epic sadface: Username is required"},
                {"standard_user", "secret_sauce", "Epic sadface: Username and password do not match any user in this service"},
                {"locked_out_user", "secret_sauce", "Epic sadface: Sorry, this user has been locked out."}
        };
    }


    @Test(description = "Negative Login tests",dataProvider = "loginData")
    public void negativeLogin(String user, String password, String expectedError) {
        /*System.out.println(user);
        System.out.println(password);
        System.out.println(expectedError);
        System.out.println("------------------");*/
        loginPage.open();
        loginPage.login(user, password);
        assertEquals(
                loginPage.getErrorMessage(),
                expectedError,
                "Wrong error message is shown");
    }

    @Test(description = "Username is required")
    public void emptyFields() {
        loginPage.open();
        loginPage.login("", "");
        assertEquals(
                loginPage.getErrorMessage(),
                "Epic sadface: Username is required", "ERROR");
    }

    @Test(description = "Log in with wrong password")
    public void wrongPassword() {
        loginPage.open();
        loginPage.login("standard_user", "15secret_sauce");
        assertEquals(loginPage.getErrorMessage(),
                "Epic sadface: Username and password do not match any user in this service", "ERROR");
    }

    @Test(description = "Log in as locked_out_user")
    public void lockedUser() {
        loginPage.open();
        loginPage.login("locked_out_user", "secret_sauce");
        assertEquals(loginPage.getErrorMessage(),
                "Epic sadface: Sorry, this user has been locked out.", "ERROR");
    }
}