package ru.stqa.training.selenium;

import org.junit.Test;
import org.openqa.selenium.By;

public class GeoZonesTests extends TestBase{

   @Test
   public void testCountries() {
      int s;
      String zone1 = new String();
      String zone2 = new String();

      login();
      driver.findElement(By.xpath("//li[@id='app-']/a[contains(@href, 'geo_zones')]")).click();

      s = driver.findElements(By.xpath("//tr[@class='row']")).size();
      System.out.println(s);

   }

}
