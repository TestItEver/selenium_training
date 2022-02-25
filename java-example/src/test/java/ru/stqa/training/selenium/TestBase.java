package ru.stqa.training.selenium;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class TestBase {

   public static WebDriver driver;
   public static WebDriverWait wait;

   @Before
   public void start() {

      if (driver != null) {
         return;
      }

      // Chrome
      ChromeOptions options = new ChromeOptions();
      options.setBinary("C:\\Program Files (x86)\\Google\\Chrome\\Application\\chrome.exe");
      options.addArguments("start-maximized");
      driver = new ChromeDriver(options);
      wait = new WebDriverWait(driver, 10);
      driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);

      Runtime.getRuntime().addShutdownHook(
              new Thread(() -> { driver.quit(); driver = null;})); // only one shutdown after all tests

      // Firefox
      // driver = new FirefoxDriver();
      // Capabilities caps = new ImmutableCapabilities("unexpectedAlertBehaviour", "dismiss");
      // System.out.println(((HasCapabilities) driver).getCapabilities());

      // Internet Explorer
      // InternetExplorerOptions options = new InternetExplorerOptions();
      // options.requireWindowFocus();
      // WebDriver driver = new InternetExplorerDriver(options);
   }


   public boolean isElementPresent(By locator) {
      try {
         driver.findElement(locator);
         return true;
      } catch (NoSuchElementException ex) {
         return false;
      }
   }

   public boolean areElementsPresent(By locator) {
      return driver.findElements(locator).size() > 0;
   }

   @After
   public void stop() {
      // driver.quit();
      // driver = null;
   }
}
