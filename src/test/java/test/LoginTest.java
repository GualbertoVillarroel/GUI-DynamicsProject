package test;

import PageFactory.DynamicsHomePage;
import PageFactory.DynamicsLogin;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

public class LoginTest {
  WebDriver driver;
  WebDriverWait wait;
  DynamicsLogin objLogin;
  DynamicsHomePage objHomePage;
  private String baseUrl;

  @BeforeTest
  public void setup() {
    MainConfiguration mainConfiguration = MainConfiguration.INSTANCE;
    driver = mainConfiguration.getDriver();
    baseUrl = "https://fundacionorgtest.crm2.dynamics.com/main.aspx";
    driver.get(baseUrl);
    wait = mainConfiguration.getWait();
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
    objHomePage = new DynamicsHomePage(driver);

    //Verify navegation bar in home page is displayed
    wait.until(ExpectedConditions.elementToBeClickable(objHomePage.getNavegationBar()));
    assertTrue(objHomePage.getNavegationBar().isDisplayed());
  }

  @AfterTest
  public void tearDown() {
    driver.quit();
  }
}