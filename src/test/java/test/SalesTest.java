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

public class SalesTest {
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

  @Test
  public void testSalesAccecs() {
    //Create Login Page object
    objLogin = new DynamicsLogin(driver);

    //Login to Dynamics application
    objLogin.loginToDynamics("hcoca@fundacionOrgTest.onmicrosoft.com", "Control123");
    wait.until(ExpectedConditions.elementToBeClickable(objLogin.getLoginButton()));
    objLogin.clickLogin();

    //Go the next page
    objHomePage = new DynamicsHomePage(driver);

    wait.until(ExpectedConditions.elementToBeClickable(objHomePage.getNavegationBar()));
    assertTrue(objHomePage.getNavegationBar().isDisplayed());

    wait.until(ExpectedConditions.elementToBeClickable(objHomePage.getSalesTabButton()));
    //assertTrue(objHomePage.getSalesTabButton().isDisplayed());
    objHomePage.getSalesTabButton().click();

    wait.until(ExpectedConditions.elementToBeClickable(objHomePage.getNavAccountsButton()));
    objHomePage.getNavAccountsButton().click();
  }

  @AfterTest
  public void tearDown() {
    driver.quit();
  }
}