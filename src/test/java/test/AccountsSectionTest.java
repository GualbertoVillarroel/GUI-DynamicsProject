package test;

import PageFactory.DynamicsPage;
import PageFactory.DynamicsLogin;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;


public class AccountsSectionTest {
  WebDriver driver;
  WebDriverWait wait;
  DynamicsLogin objLogin;
  DynamicsPage objHomePage;

  @BeforeTest
  public void setup() {
    MainConfiguration mainConfiguration = MainConfiguration.INSTANCE;
    driver = mainConfiguration.getDriver();
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
    objHomePage = new DynamicsPage(driver);

    //Go to Accounts Section
    wait.until(ExpectedConditions.elementToBeClickable(objHomePage.getMainNavegationBar()));

    wait.until(ExpectedConditions.elementToBeClickable(objHomePage.getNavTabSalesButton()));
    objHomePage.getNavTabSalesButton().click();

    wait.until(ExpectedConditions.elementToBeClickable(objHomePage.getCustomersAccountsButton()));
    objHomePage.getCustomersAccountsButton().click();

    //Change to iFrame
    driver.switchTo().defaultContent();
    WebElement element = driver.findElement(By.id("contentIFrame0"));
    driver.switchTo().frame(element);

    //Verify the accounts list is displayed
    wait.until(ExpectedConditions.elementToBeClickable(objHomePage.getListAccountsContainer()));
    assertTrue(objHomePage.getListAccountsContainer().isDisplayed());
  }

  @AfterTest
  public void tearDown() {
    driver.quit();
  }
}