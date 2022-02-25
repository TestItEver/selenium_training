package ru.stqa.training.selenium;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.junit.Assert;

public class MyFirstTest extends TestBase{


   @Test
   public void myFirstTest() {
      driver.get("https://www.duckduckgo.com");
      driver.findElement(By.name("q")).sendKeys("webdriver");
      driver.findElement(By.id("search_button_homepage")).click();
   }

   @Test
   public void waitTest() {
      driver.navigate().to("https://www.duckduckgo.com");
      driver.findElement(By.name("q")).sendKeys("webdriver");
      driver.findElement(By.id("search_button_homepage")).click();
      Assert.assertTrue(isElementPresent(By.cssSelector("#links")));

   }

}
