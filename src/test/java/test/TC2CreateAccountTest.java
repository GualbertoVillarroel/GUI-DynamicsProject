package test;

import PageFactory.DynamicsPage;
import PageFactory.DynamicsLogin;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;


public class TC2CreateAccountTest {
  WebDriver driver;
  WebDriverWait wait;
  DynamicsLogin objLogin;
  DynamicsPage objDynamPage;

  @BeforeTest
  public void setup() {
    //Without Singleton
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

  @Test(priority = 1)
  public void testCreateAccountTest() {
    //Create Login Page object
    objLogin = new DynamicsLogin(driver);


    //Modelo
//    HomePage home = objLogin.login(username, passsword);
//
//    AccountFormPage account =  home.goToCreateAccount();
//
//    home = account.createAccount("name");
//
//    AccountListPage account = home.goToAccountList();
//
//    AssertTrue (acount.VerifyAccount("name"));





    //Login to Dynamics application
    objLogin.loginToDynamics("hcoca@fundacionOrgTest.onmicrosoft.com", "Control123");
    wait.until(ExpectedConditions.elementToBeClickable(objLogin.getLoginButton()));
    objLogin.clickLogin();

    //Go the next page
    objDynamPage = new DynamicsPage(driver);

    //Go to create a new account
    wait.until(ExpectedConditions.elementToBeClickable(objDynamPage.getNavTabGlobal()));
    objDynamPage.getNavTabGlobal().click();

    wait.until(ExpectedConditions.elementToBeClickable(objDynamPage.getRecAccountButton()));
    objDynamPage.getRecAccountButton().click();

    wait.until(ExpectedConditions.visibilityOf(objDynamPage.getAccountFormTittle()));
    assertEquals(objDynamPage.getAccountFormTittle().getText().toString(), "Account");

    //Change to iFrame
    driver.switchTo().defaultContent();
    WebElement element = driver.findElement(By.id("NavBarGloablQuickCreate"));
    driver.switchTo().frame(element);

    //Verify the Account Name text is displayed
    wait.until(ExpectedConditions.elementToBeClickable(objDynamPage.getAccountNameLabel()));
    assertEquals(objDynamPage.getAccountNameLabel().getText().toString(), "Account Name");

    //Fill the name of the new account
    wait.until(ExpectedConditions.visibilityOf(objDynamPage.getAccountNameTextField()));

      driver.switchTo().alert();
      driver.switchTo().alert().accept();

      wait.until(ExpectedConditions.elementToBeClickable(objDynamPage.getAccountNameTextField()));

      objDynamPage.getAccountNameTextField().click();
      objDynamPage.getAccountNameTextField().sendKeys("New account 2 created by Selenium");

      //Change to default frame
      driver.switchTo().defaultContent();
      // driver.findElement(By.xpath("//*[@id=\"globalquickcreate_actionsdiv_NavBarGloablQuickCreate\"]")).click();
//    wait.until(ExpectedConditions.visibilityOf(objDynamPage.getAccountNameTextField()));
    if (!objDynamPage.getNavBarQuickCreate().isEnabled()){
      driver.switchTo().alert();
      driver.switchTo().alert().accept();
    } else {
      wait.until(ExpectedConditions.elementToBeClickable(objDynamPage.getNavBarQuickCreate()));
      objDynamPage.getNavBarQuickCreate().click();

      wait.until(ExpectedConditions.elementToBeClickable(objDynamPage.getSaveNewAccountButton()));
      objDynamPage.getSaveNewAccountButton().click();

    }

//
//    //Go to Accounts Section
//    driver.navigate().refresh();
//    wait.until(ExpectedConditions.elementToBeClickable(objDynamPage.getMainNavegationBar()));
//
//    wait.until(ExpectedConditions.elementToBeClickable(objDynamPage.getNavTabSalesButton()));
//    objDynamPage.getNavTabSalesButton().click();
//
//    wait.until(ExpectedConditions.elementToBeClickable(objDynamPage.getCustomersAccountsButton()));
//    objDynamPage.getCustomersAccountsButton().click();
//
//    //Change to iFrame
//    driver.switchTo().defaultContent();
//    element = driver.findElement(By.id("contentIFrame0"));
//    driver.switchTo().frame(element);
//
//    //Verify the accounts list is displayed
//    wait.until(ExpectedConditions.elementToBeClickable(objDynamPage.getListAccountsContainer()));
//    assertTrue(objDynamPage.getListAccountsContainer().isDisplayed());
//
//    // assertTrue(driver.findElement(By.xpath("//*[@id=\"gridBodyTable\"]")).getText().contains("New account 2 created by Selenium"));
//    assertTrue(objDynamPage.getAccountsTable().getText().contains("New account 2 created by Selenium"));

  }

  @AfterTest
  public void tearDown() {
    driver.quit();
  }
}