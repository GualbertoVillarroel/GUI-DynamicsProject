package test;

import PageFactory.DynamicsHomePage;
import PageFactory.DynamicsLogin;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class CreateAccountTest {
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
  public void testCreateAccountTest() {
    //Create Login Page object
    objLogin = new DynamicsLogin(driver);

    //Login to Dynamics application
    objLogin.loginToDynamics("hcoca@fundacionOrgTest.onmicrosoft.com", "Control123");
    wait.until(ExpectedConditions.elementToBeClickable(objLogin.getLoginButton()));
    objLogin.clickLogin();

    //Go the next page
    objHomePage = new DynamicsHomePage(driver);

//    wait.until(ExpectedConditions.elementToBeClickable(objHomePage.getNavegationBar()));
//
//    wait.until(ExpectedConditions.elementToBeClickable(objHomePage.getSalesTabButton()));
//    objHomePage.getSalesTabButton().click();
//
//    wait.until(ExpectedConditions.elementToBeClickable(objHomePage.getNavAccountsButton()));
//    objHomePage.getNavAccountsButton().click();

    wait.until(ExpectedConditions.elementToBeClickable(objHomePage.getNavTabGlobal()));
    objHomePage.getNavTabGlobal().click();

    wait.until(ExpectedConditions.elementToBeClickable(objHomePage.getRecordsAccountButton()));
    objHomePage.getRecordsAccountButton().click();

    wait.until(ExpectedConditions.visibilityOf(objHomePage.getAccountTittle()));
    assertEquals(objHomePage.getAccountTittle().getText().toString(), "Account");

    //Change to iFrame
    driver.switchTo().defaultContent();
    WebElement element = driver.findElement(By.id("NavBarGloablQuickCreate"));
    driver.switchTo().frame(element);

    wait.until(ExpectedConditions.elementToBeClickable(objHomePage.getAccountNameLabel()));
    assertEquals(objHomePage.getAccountNameLabel().getText().toString(), "Account Name");

    wait.until(ExpectedConditions.elementToBeClickable(objHomePage.getAccountNameTextField()));
    objHomePage.getAccountNameTextField().click();
    objHomePage.getAccountNameTextField().sendKeys("New account 2 created by Selenium");
    //objHomePage.getAccountNameTextField().sendKeys(Keys.ENTER);

//    wait.until(ExpectedConditions.elementToBeSelected(objHomePage.getMainPhoneTextField()));
//    objHomePage.getMainPhoneTextField().click();
//    objHomePage.getMainPhoneTextField().sendKeys("123456");
   // objHomePage.getMainPhoneTextField().sendKeys(Keys.ENTER);
    //wait.until(ExpectedConditions.textToBePresentInElementValue(objHomePage.getAccountNameTextField(), "New account 2 created by Selenium"));

    //Change to default frame
    driver.switchTo().defaultContent();

    wait.until(ExpectedConditions.elementToBeClickable(objHomePage.getSaveAccountButton()));
    objHomePage.getSaveAccountButton().click();
  }

  @AfterTest
  public void tearDown() {
    //driver.quit();
  }
}