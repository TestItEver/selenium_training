package ru.stqa.training.selenium;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerOptions;

import java.util.concurrent.TimeUnit;

public class LoginTest extends TestBase{

   @Test
   public void loginTest() {
      driver.get("http://localhost/litecart/admin/");
      driver.findElement(By.name("username")).sendKeys("admin");
      driver.findElement(By.name("password")).sendKeys("admin");
      driver.findElement(By.name("login")).click();
   }

}
