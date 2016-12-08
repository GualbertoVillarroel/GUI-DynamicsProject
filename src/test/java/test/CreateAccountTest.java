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

import static org.testng.Assert.assertEquals;


public class CreateAccountTest {
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
  public void testCreateAccountTest() {
    //Create Login Page object
    objLogin = new DynamicsLogin(driver);

    //Login to Dynamics application
    objLogin.loginToDynamics("hcoca@fundacionOrgTest.onmicrosoft.com", "Control123");
    wait.until(ExpectedConditions.elementToBeClickable(objLogin.getLoginButton()));
    objLogin.clickLogin();

    //Go the next page
    objHomePage = new DynamicsPage(driver);

    //Go to create a new account
    wait.until(ExpectedConditions.elementToBeClickable(objHomePage.getNavTabGlobal()));
    objHomePage.getNavTabGlobal().click();

    wait.until(ExpectedConditions.elementToBeClickable(objHomePage.getRecAccountButton()));
    objHomePage.getRecAccountButton().click();

    wait.until(ExpectedConditions.visibilityOf(objHomePage.getAccountFormTittle()));
    assertEquals(objHomePage.getAccountFormTittle().getText().toString(), "Account");

    //Change to iFrame
    driver.switchTo().defaultContent();
    WebElement element = driver.findElement(By.id("NavBarGloablQuickCreate"));
    driver.switchTo().frame(element);

    //Verify the Account Name text is displayed
    wait.until(ExpectedConditions.elementToBeClickable(objHomePage.getAccountNameLabel()));
    assertEquals(objHomePage.getAccountNameLabel().getText().toString(), "Account Name");

    //Fill the name of the new account
    wait.until(ExpectedConditions.elementToBeClickable(objHomePage.getAccountNameTextField()));
    objHomePage.getAccountNameTextField().click();
    objHomePage.getAccountNameTextField().sendKeys("New account 2 created by Selenium");

    //Change to default frame
    driver.switchTo().defaultContent();
    driver.findElement(By.xpath("//*[@id=\"globalquickcreate_actionsdiv_NavBarGloablQuickCreate\"]")).click();

    wait.until(ExpectedConditions.elementToBeClickable(objHomePage.getSaveNewAccountButton()));
    objHomePage.getSaveNewAccountButton().click();
  }

  @AfterTest
  public void tearDown() {
    driver.quit();
  }
}