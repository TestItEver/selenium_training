package ru.stqa.training.selenium;

import org.junit.After;
import org.junit.Before;
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
      driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

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

   @After
   public void stop() {
      // driver.quit();
      // driver = null;
   }
}
