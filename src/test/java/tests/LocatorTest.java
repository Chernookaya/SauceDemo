package tests;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;
import static org.testng.Assert.assertEquals;

public class LocatorTest extends BaseTest {
    public static final String BASE_URL = "https://www.saucedemo.com";

    @Test
    public void locators() {
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
        /*driver.findElement(By.id("login-button"));
        driver.findElement(By.name("login-button"));
        driver.findElement(By.tagName("input"));
        driver.findElement(By.xpath("//div[text()='Swag Labs']"));
        driver.findElement(By.xpath("//div[contains(@class,'logo')]"));
        driver.findElement(By.xpath("//*[text()='standard_user']//ancestor::div"));
        driver.findElement(By.xpath("//input[@placeholder='Username']")).sendKeys("standard_user");
        driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys("secret_sauce");
        driver.findElement(By.className("submit-button")).click();*/
        // Поиск по id
        assertTrue(driver.findElement(By.cssSelector("#menu_button_container")).isDisplayed());
        //   аналог по id
        assertTrue(driver.findElement(By.id("menu_button_container")).isDisplayed());
        // Поиск по class name
        assertTrue(driver.findElement(By.cssSelector(".title")).isDisplayed());
        //   аналог по classname
        assertTrue(driver.findElement(By.className("title")).isDisplayed());
        // Поиск по tagname
        assertTrue(driver.findElement(By.cssSelector("span")).isDisplayed());
        //   аналог по tagname
        assertTrue(driver.findElement(By.tagName("span")).isDisplayed());
        // Поиск по linktext
        assertTrue(driver.findElement(By.linkText("Sauce Labs Fleece Jacket")).isDisplayed());
        // Поиск по partiallinktext
        assertTrue(driver.findElement(By.partialLinkText("Sauce Labs Bolt T-Shirt")).isDisplayed());
        // Поиск по нескольким значения в аттрибуте class
        assertTrue(driver.findElement(By.cssSelector(".btn.btn_small")).isDisplayed());
        // Поиск по всем элементам атрибута bm-item которые являются потомками элемента с именем bm-item-list
        assertEquals(4, driver.findElements(By.cssSelector(".bm-item-list .bm-item")).size());
        // Поиск по id и значению из аттрибута class
        assertEquals(1, driver.findElements(By.cssSelector("#item_4_img_link .inventory_item_img")).size());
        //Поиск по tagname и значению из аттрибута class
        assertEquals(4, driver.findElements(By.cssSelector("a.menu-item")).size());
        // Поиск всех элементов у которых присутствует аттрибут title
        assertEquals(13, driver.findElements(By.cssSelector("[style]")).size());
        // Поиск всех элементов у которых присутствует аттрибут style с конкретным значением
        assertEquals(2, driver.findElements(By.cssSelector("[style='width: 100%; height: 100%;']")).size());
        // Поиск всех элементов у которых присутствует аттрибут id со значением заканчивающимся на какое-то value
        assertEquals(2, driver.findElements(By.cssSelector("[id$='btn']")).size());
        // Поиск всех элементов у которых присутствует аттрибут id со значением начинающимся на какое-то value
        assertEquals(4, driver.findElements(By.cssSelector("[id^=r]")).size());
        // Поиск всех элементов у которых присутствует аттрибут id со значением начинающимся на какое-то слово
        assertEquals(2, driver.findElements(By.cssSelector("[id|=react]")).size());
        // Поиск всех элементов у которых присутствует аттрибут title со значением содержащим слово целиком
        assertEquals(1, driver.findElements(By.cssSelector("[class~=title]")).size());
        // Поиск всех элементов у которых присутствует аттрибут title со значением содержащим какой текст
        assertEquals(56, driver.findElements(By.cssSelector("[class*=inventory]")).size());
    }

    @Test
    public void xpathSelectorsTest() {

        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
        productsPage.addToCart("Sauce Labs Bike Light");
        productsPage.openCart();

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