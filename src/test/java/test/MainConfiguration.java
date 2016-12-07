package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;


public enum MainConfiguration {
  INSTANCE;
  private WebDriver driver;
  private WebDriverWait wait;

  MainConfiguration() {
    //Configuration for Firefox Driver
//    System.setProperty("webdriver.gecko.driver", "C:\\geckodriver-v0.11.1-win64\\geckodriver.exe");
//    System.setProperty("webdriver.gecko.driver", "/Users/GualyVc/IntelliJ/geckodriver");
//    driver = new FirefoxDriver();

    //Configuration for Google Chrome Drive
    System.setProperty("webdriver.chrome.driver", "C:\\chromedriver_win32\\chromedriver.exe");
    driver = new ChromeDriver();

    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    //driver.get("https://fundacionorgtest.crm2.dynamics.com/main.aspx");
    wait = new WebDriverWait(driver, 20);
  }

  public WebDriver getDriver() {
    return driver;
  }

  public WebDriverWait getWait() {
    return wait;
  }
}