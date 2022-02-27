package ru.stqa.training.selenium;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;


public class AdminSiteTests extends TestBase {

   @Test
   public void testMenu() {

      login();

      List<WebElement> listMenu = driver.findElements(By.xpath("//li[@id='app-']"));
      int s1 = listMenu.size();

      for (int i = 1; i<=s1; i++) {
         driver.findElement(By.xpath("//li[@id='app-'][" + i + "]//a")).click();
         Assert.assertTrue(isElementPresent(By.xpath("//h1")));

         int s2 = driver.findElements(By.xpath("//li[@id='app-'][" + i + "]/ul[@class='docs']//a")).size();
         if (s2>0) {
            for (int l = 1; l<=s2; l++){
               driver.findElement(By.xpath("//li[@id='app-'][" + i + "]/ul[@class='docs']/li[" + l + "]/a")).click();
               Assert.assertTrue(isElementPresent(By.xpath("//h1")));
            }
         }
      }
   }
}
