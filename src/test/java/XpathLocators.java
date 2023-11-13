import org.openqa.selenium.By;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class XpathLocators extends BaseTest {
    public static final String BASE_URL = "https://www.saucedemo.com";
    public static final String USERNAME = "standard_user";
    public static final String PASSWORD = "secret_sauce";

    @Test
    public void xpathSelectorsTest() {
        driver.get(BASE_URL);
        driver.findElement(By.id("user-name")).sendKeys(USERNAME);
        driver.findElement(By.id("password")).sendKeys(PASSWORD);
        driver.findElement(By.id("login-button")).click();
        driver.findElement(By.xpath("//*[text()='Sauce Labs Bike Light']" +
                "/ancestor::*[@class='inventory_item']//button")).click();
        driver.findElement(By.id("shopping_cart_container")).click();
        String productName = driver.findElement(By.cssSelector(".inventory_item_name")).getText();
        assertEquals(productName, "Sauce Labs Bike Light", "Error, Product not found!");
        String productPrice = driver.findElement(By.cssSelector(".inventory_item_price")).getText();
        assertEquals(productPrice, "$9.99", "Wrong price!");

        // Поиск элемента у которого есть аттрибут id cо значением header_container
        assertTrue(driver.findElement(By.xpath("//*[@id = 'header_container']")).isDisplayed());
        // Поиск элемента у которого текстовое значение содержит равно
        assertTrue(driver.findElement(By.xpath("//div[text() = 'Sauce Labs Bike Light']")).isDisplayed());
        assertTrue(driver.findElement(By.xpath("//*[. = 'Description']")).isDisplayed());
        //Поиск по частичному совпадению атрибута
        assertTrue(driver.findElement(By.xpath("//*[. = 'Description']")).isDisplayed());
        // Поиск элемента по частичному совпадению текста
        assertTrue(driver.findElement(By.xpath("//*[contains(text(), 'A red light')]")).isDisplayed());
        // Поиск элемента по частичному совпадению атрибута
        assertEquals(1, driver.findElements(By.xpath("//button[contains(@class,'cart_button')]")).size());

        // Поиск всех предков с тэгом div у элемента с тэгом button
        assertEquals(19, driver.findElements(By.xpath("//button/ancestor::div")).size());
        // Поиск всех потомков с тэгом div у элемента с тэгом nav
        assertEquals(1, driver.findElements(By.xpath("//div/descendant::nav")).size());
        //Использование following - Выбирает всё в документе после закрытия тэга текущего узла
        assertTrue(driver.findElement(By.xpath("//*[@class ='bm-burger-button']/following::ul")).isDisplayed());
        // Поиск родителя у элемента с тэгом h1
        assertTrue(driver.findElement(By.xpath("//li/parent::ul")).isDisplayed());
        //Использование preceding- Выбирает все узлы, которые появляются перед текущим узлом в документе
        assertTrue(driver.findElement(By.xpath("//*[@class ='shopping_cart_badge']/preceding::div")).isDisplayed());
        // Поиск элемента у которого есть аттрибут class cо значением и aттрибут aria-hidden со значением
        assertTrue(driver.findElement(By.xpath("//*[@id='checkout' and @name='checkout']")).isDisplayed());
    }
}