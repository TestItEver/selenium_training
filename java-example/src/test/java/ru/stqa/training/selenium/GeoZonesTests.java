package ru.stqa.training.selenium;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class GeoZonesTests extends TestBase{

   @Test
   public void testGeoZones() {
      String zone1 = new String();
      String zone2 = new String();

      login();
      driver.findElement(By.xpath("//li[@id='app-']/a[contains(@href, 'geo_zones')]")).click();

      int s = driver.findElements(By.xpath("//tr[@class='row']")).size();
      System.out.println(s);

      for (int i=1; i<=s; i++) {
         List<WebElement> countries = driver.findElements(By.xpath("//tr[@class='row'][" + i + "]//td"));
         countries.get(2).findElement(By.xpath("./a")).click();

         int z = driver.findElements(By.xpath("//tr[@class='row']")).size();
         System.out.println(z);

         for (int l=2; l<z; l++) {
            List<WebElement> zones = driver.findElements(By.xpath("//tr[@class='row'][" + l + "]//td"));
            String name = zones.get(2).findElement(By.xpath("/select")).getAttribute("value");
            System.out.println(name);
         }

         driver.findElement(By.xpath("//button[@name='cancel']")).click();
      }
   }

}
