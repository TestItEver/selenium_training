package ru.stqa.training.selenium;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import java.util.List;


public class CountriesTests extends TestBase{

   @Test
   public void testCountries() {
      int s;
      String country1 = new String();
      String country2 = new String();
      String zones;

      login();
      driver.findElement(By.xpath("//li[@id='app-']/a[contains(@href, 'countries')]")).click();

      s = driver.findElements(By.xpath("//tr[@class='row']")).size();
      for (int i=1; i<=s; i++) {
         List<WebElement> cells = driver.findElements(By.xpath("//tr[@class='row'][" + i + "]//td"));
         country2 = cells.get(4).getAttribute("textContent");
         Assert.assertTrue(country2.compareTo(country1) > 0);

         zones = cells.get(5).getAttribute("textContent");
         if (!zones.equals("0")) {
            driver.findElement(By.xpath("//tr[@class='row'][" + i + "]//td//a")).click();
            timeZones();
         }

         country1 = country2;
      }
   }

   private void timeZones() {
      String zone1 = new String();
      String zone2 = new String();
      int s;
      s = driver.findElements(By.xpath("//table[@id='table-zones']//tr")).size();

      for (int i=2; i<s; i++) {
         List<WebElement> cells = driver.findElements(By.xpath("//table[@id='table-zones']//tr[" + i + "]/td"));
         zone2 = cells.get(2).getAttribute("textContent");
         Assert.assertTrue(zone2.compareTo(zone1) > 0);
         zone1 = zone2;
      }

      driver.findElement(By.xpath("//button[@name='cancel']")).click();
   }
}
