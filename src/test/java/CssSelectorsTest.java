import org.openqa.selenium.By;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class CssSelectorsTest extends BaseTest {
    public static final String BASE_URL = "https://www.saucedemo.com";
    public static final String USERNAME = "standard_user";
    public static final String PASSWORD = "secret_sauce";

    @Test
    public void cssSelectorsTest() {
        driver.get(BASE_URL);
        driver.findElement(By.id("user-name")).sendKeys(USERNAME);
        driver.findElement(By.id("password")).sendKeys(PASSWORD);
        driver.findElement(By.id("login-button")).click();

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
}