package ru.stqa.training.selenium;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;


public class AdminSiteTests extends TestBase {

   @Test
   public void testMenu() {

      driver.get("http://localhost/litecart/admin/");
      driver.findElement(By.name("username")).sendKeys("admin");
      driver.findElement(By.name("password")).sendKeys("admin");
      driver.findElement(By.name("login")).click();

      String[] menu = {"appearance", "catalog", "countries", "customers", "geo_zones", "languages", "modules", "orders", "pages",
                         "reports", "settings", "slides", "tax", "translations", "users", "vqmods"};

      for (int i=0; i<menu.length; i++) {
         WebElement menuElement = menuFinder(menu[i]);
         menuElement.click();
         Assert.assertTrue(isElementPresent(By.xpath("//h1")));
         System.out.println("Menu " + menu[i]);
         System.out.println("Test for menu " + menu[i] + " is " + isElementPresent(By.xpath("//h1")));

         List<WebElement> items = listFinder(menu[i]);
         if (items.size() > 0) {
            for (int l=1; l<=items.size(); l++){
               itemFinder(menu[i], l).click();
               Assert.assertTrue(isElementPresent(By.xpath("//h1")));
               System.out.println("Test for " + l + ". item in menu " + menu[i] + " is " + isElementPresent(By.xpath("//h1")));
            }
         }
         System.out.println("-----------------------------------------------------------------");
      }
   }

   private WebElement itemFinder(String menu, int l) {
      return driver.findElement(By.xpath("//li[@id='app-']/a[contains(@href, '" + menu + "')]/../ul[@class='docs']/li[" + l + "]"));
   }

   private List<WebElement> listFinder(String menu) {
      return driver.findElements(By.xpath("//li[@id='app-']/ul[@class='docs']//a[contains(@href, '" + menu + "')]"));
   }

   private WebElement menuFinder(String menu) {
      return driver.findElement(By.xpath("//li[@id='app-']/a[contains(@href, '" + menu + "')]"));
   }
}
