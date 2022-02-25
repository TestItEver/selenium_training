package ru.stqa.training.selenium;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class StickerTests extends TestBase{

   @Test
   public void stickerTest() {

      int numberOfProducts;
      int numberOfStickers;

      driver.get("http://localhost/litecart/");

      // Box-most-popular
      numberOfProducts = driver.findElements(By.xpath("//div[@id='box-most-popular']//li")).size();
      for (int i=1; i<=numberOfProducts; i++){
         numberOfStickers = driver.findElements(By.xpath("//div[@id='box-most-popular']//li[" + i + "]//div[contains(@class, 'sticker')]")).size();
         Assert.assertEquals(1, numberOfStickers);
      }

      // Box-campaigns
      numberOfProducts = driver.findElements(By.xpath("//div[@id='box-campaigns']//li")).size();
      for (int i=1; i<=numberOfProducts; i++){
         numberOfStickers = driver.findElements(By.xpath("//div[@id='box-most-popular']//li[" + i + "]//div[contains(@class, 'sticker')]")).size();
         Assert.assertEquals(1, numberOfStickers);
      }

      // Box-latest-products
      numberOfProducts = driver.findElements(By.xpath("//div[@id='box-latest-products']//li")).size();
      for (int i=1; i<=numberOfProducts; i++){
         numberOfStickers = driver.findElements(By.xpath("//div[@id='box-most-popular']//li[" + i + "]//div[contains(@class, 'sticker')]")).size();
         Assert.assertEquals(1, numberOfStickers);
      }
      
   }
}
