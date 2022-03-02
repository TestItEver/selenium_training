package ru.stqa.training.selenium;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;


public class GeoZonesTests extends TestBase{

   @Test
   public void testGeoZones() {

      login();
      driver.findElement(By.xpath("//li[@id='app-']/a[contains(@href, 'geo_zones')]")).click();

      int s = driver.findElements(By.xpath("//table[@class='dataTable']//tr[@class='row']")).size();
      for (int i=1; i<=s; i++) {
         String zone1 = new String();
         String zone2 = new String();
         List<WebElement> countries = driver.findElements(By.xpath("//table[@class='dataTable']//tr[@class='row'][" + i + "]/td"));
         countries.get(2).findElement(By.xpath("./a")).click();

         int z = driver.findElements(By.xpath("//table[@class='dataTable']//tr")).size();
         for (int l=2; l<z; l++) {
            List<WebElement> zones = driver.findElements(By.xpath("//table[@class='dataTable']//tr[" + l + "]/td"));
            String country = zones.get(1).findElement(By.xpath(".//span[@class='selection']")).getAttribute("textContent");
            String timeZoneValue = zones.get(2).findElement(By.xpath("./select")).getAttribute("value");

            if (timeZoneValue.equals("")) {
               zone2 = country;
            } else {
               zone2 = zones.get(2).findElement(By.xpath(".//option[@selected='selected']")).getText();
            }

            Assert.assertTrue(zone2.compareTo(zone1) > 0);
            if (zone2.compareTo(zone1) < 0) {
               System.out.println(zone1 + " " + zone2);
            }
            zone1 = zone2;
         }
         driver.findElement(By.xpath("//button[@name='cancel']")).click();

      }
   }
}
