package test;

import PageFactory.DynamicsPage;
import PageFactory.DynamicsLogin;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertTrue;

public class LoginTest {
  WebDriver driver;
  WebDriverWait wait;
  DynamicsLogin objLogin;
  DynamicsPage objHomePage;


  @BeforeTest
  public void setup() {

    System.setProperty("webdriver.chrome.driver", "C:\\chromedriver_win32\\chromedriver.exe");
    driver = new ChromeDriver();
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    String baseUrl = "https://fundacionorgtest.crm2.dynamics.com/main.aspx";
    driver.get(baseUrl);
    wait = new WebDriverWait(driver, 20);

    //Singleton
//    MainConfiguration mainConfiguration = MainConfiguration.INSTANCE;
//    driver = mainConfiguration.getDriver();
//    wait = mainConfiguration.getWait();
  }

  @Test(priority = 0)
  public void testLogin() {
    //Create Login Page object
    objLogin = new DynamicsLogin(driver);

    //Login to Dynamics application
    objLogin.loginToDynamics("hcoca@fundacionOrgTest.onmicrosoft.com", "Control123");
    wait.until(ExpectedConditions.elementToBeClickable(objLogin.getLoginButton()));
    objLogin.clickLogin();

    //Go the next page
    objHomePage = new DynamicsPage(driver);

    //Verify main navegationBar in home page is displayed
    wait.until(ExpectedConditions.elementToBeClickable(objHomePage.getMainNavegationBar()));
    assertTrue(objHomePage.getMainNavegationBar().isDisplayed());
  }

  @AfterTest
  public void tearDown() {
    driver.quit();
  }
}