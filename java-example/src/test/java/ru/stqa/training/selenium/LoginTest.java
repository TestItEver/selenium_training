package ru.stqa.training.selenium;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class LoginTest {

   private WebDriver driver;

   @Before
   public void start() {
      //driver = new FirefoxDriver();
      driver = new ChromeDriver();
      driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
   }

   @Test
   public void loginTest() {
      driver.get("http://localhost/litecart/admin/");
      driver.findElement(By.name("username")).sendKeys("admin");
      driver.findElement(By.name("password")).sendKeys("admin");
      driver.findElement(By.name("login")).click();
   }

   @After
   public void stop() {
      driver.quit();
      driver = null;
   }
}
