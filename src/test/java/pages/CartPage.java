package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartPage extends BasePage {

    private final By CHECKOUT = By.id("checkout");
    private final String DELETE_PRODUCT_PATTERN = "//*[text()='%s']/ancestor::*[contains(@class, 'cart_item_label')]//button";

    public CartPage(WebDriver driver) {
        super(driver);
    }

    public void open() {
        driver.get(BASE_URL + "/cart.html");
    }

    public void checkout() {
        driver.findElement(CHECKOUT).click();
    }

    public void deleteProduct(String productName) {
        By removeButtonLocator = By.xpath(String.format(DELETE_PRODUCT_PATTERN, productName));
        driver.findElement(removeButtonLocator).click();
    }
}
