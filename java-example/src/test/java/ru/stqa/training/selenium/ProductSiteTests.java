package ru.stqa.training.selenium;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.ui.Select;

public class ProductSiteTests extends TestBase{

   @Before
   public void preconditions() {
      driver.get("http://localhost/litecart/");
      driver.findElement(By.linkText("Change")).click();
      driver.findElement(By.name("currency_code")).click();
      new Select(driver.findElement(By.name("currency_code"))).selectByVisibleText("US Dollars");
      driver.findElement(By.name("save")).click();
   }

   @Test
   public void testProductSite() {
      String regPrice = ".//s[@class='regular-price']";
      String actPrice = ".//strong[@class='campaign-price']";

      // Gathering data from the main page
      WebElement product = driver.findElement(By.xpath("//div[@id='box-campaigns']//li[1]/a[@class='link']"));
      String productName1 = product.getAttribute("title");

      String regPrice1 = product.findElement(By.xpath(regPrice)).getText();
      String colorStringRegPrice1 = product.findElement(By.xpath(regPrice)).getCssValue("color");
      String sizeRegPrice1 = product.findElement(By.xpath(regPrice)).getCssValue("font-size");
      String dRegPrice1 = product.findElement(By.xpath(regPrice)).getCssValue("text-decoration-line");

      String actPrice1 = product.findElement(By.xpath(actPrice)).getText();
      String colorStringActPrice1 = product.findElement(By.xpath(actPrice)).getCssValue("color");
      String sizeActPrice1 = product.findElement(By.xpath(actPrice)).getCssValue("font-size");
      String weightActPrice1 = product.findElement(By.xpath(actPrice)).getCssValue("font-weight");

      // Gathering data from the product page
      product.click();
      String productName2= driver.findElement(By.xpath("//h1")).getText();

      String regPrice2 = driver.findElement(By.xpath(regPrice)).getText();
      String colorStringRegPrice2 = driver.findElement(By.xpath(regPrice)).getCssValue("color");
      String sizeRegPrice2 = driver.findElement(By.xpath(regPrice)).getCssValue("font-size");
      String dRegPrice2 = driver.findElement(By.xpath(regPrice)).getCssValue("text-decoration-line");

      String actPrice2 = driver.findElement(By.xpath(actPrice)).getText();
      String colorStringActPrice2 = driver.findElement(By.xpath(actPrice)).getCssValue("color");
      String sizeActPrice2 = driver.findElement(By.xpath(actPrice)).getCssValue("font-size");
      String weightActPrice2 = driver.findElement(By.xpath(actPrice)).getCssValue("font-weight");

      // Tests
      // product name and prices on the main page are equal to the product name and prices on the product page
      Assert.assertEquals(productName1, productName2);
      Assert.assertEquals(regPrice1, regPrice2);
      Assert.assertEquals(actPrice1, actPrice2);

      // size of regular price is smaller than size of action price
      Assert.assertTrue(convertSize(sizeRegPrice1) < convertSize(sizeActPrice1));
      Assert.assertTrue(convertSize(sizeRegPrice2) < convertSize(sizeActPrice2));

      // color of regular price is grey
      java.awt.Color colorReg1 = convertColor(colorStringRegPrice1);
      Assert.assertTrue(colorReg1.getRed() == colorReg1.getGreen() && colorReg1.getGreen() == colorReg1.getBlue());
      java.awt.Color colorReg2 = convertColor(colorStringRegPrice2);
      Assert.assertTrue(colorReg2.getRed() == colorReg2.getGreen() && colorReg2.getGreen() == colorReg2.getBlue());

      // regular price is struck through
      Assert.assertTrue(dRegPrice1.equals("line-through"));
      Assert.assertTrue(dRegPrice2.equals("line-through"));

      // color of action price is red
      java.awt.Color colorAct1 = convertColor(colorStringActPrice1);
      Assert.assertTrue(colorAct1.getGreen() == 0 && colorAct1.getBlue() == 0);
      java.awt.Color colorAct2 = convertColor(colorStringActPrice2);
      Assert.assertTrue(colorAct2.getGreen() == 0 && colorAct2.getBlue() == 0);

      // action price is bold
      Assert.assertTrue(Integer.parseInt(weightActPrice1) >= 700);
      Assert.assertTrue(Integer.parseInt(weightActPrice2) >= 700);

   }

   private java.awt.Color convertColor(String s) {
      Color color = Color.fromString(s);
      return color.getColor();
   }

   private double convertSize(String s) {
      int l = s.length();
      return Double.parseDouble(s.substring(0, l-2));
   }

}
