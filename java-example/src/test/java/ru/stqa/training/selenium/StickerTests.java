package ru.stqa.training.selenium;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class StickerTests extends TestBase{

   @Test
   public void stickerTest() {

      int numberOfStickers;

      driver.get("http://localhost/litecart/");
      List<WebElement> products = driver.findElements(By.xpath("//li[contains(@class, 'product')]"));

      for (WebElement element : products) {
         numberOfStickers = element.findElements(By.xpath(".//div[contains(@class, 'sticker')]")).size();
         Assert.assertTrue(numberOfStickers == 1);
      }

   }
}
