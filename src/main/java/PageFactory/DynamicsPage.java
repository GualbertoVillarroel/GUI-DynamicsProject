package PageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

public class DynamicsPage {
  WebDriver driver;

  //Main Navegation MenuBar
  @FindBy(id = "navBar")
  WebElement mainNavegationBar;

  //Navegation MenuItem Sales
  @FindBy(css = "span:contains(\"Sales\")")
  WebElement navItemSalesButton;

  //Navegation MenuItem SalesTab
  @FindBy(css = "span#TabSFA[title=Sales]")
  WebElement navTabSalesButton;


  //SALES SECTION
  //SalesTab > Customers > Accounts
  @FindBy(id = "nav_accts")
  WebElement customersAccountsButton;

  @FindBy(id = "navTabGlobalCreateImage")
  WebElement navTabGlobal;

  //Accounts List
  @FindBy(id = "crmGrid")
  WebElement listAccountsContainer;


  //NEW SECTION
  //New > Records > Account
  @FindBy(xpath = ".//*[@id='{70816501-edb9-4740-a16c-6a5efbc05d84}']")
  WebElement recAccountButton;

  //Title of the Account form
  @FindBy(className = "mscrm-globalqc-entityname")
  WebElement accountFormTittle;

  //Button to save a new account
  @FindBy(id = "globalquickcreate_save_button_NavBarGloablQuickCreate")
  WebElement saveNewAccountButton;


  //FRAME SECTION OF NEW ACCOUNTS
  //iFrame (id = "NavBarGloablQuickCreate")
  @FindBy(id = "name_cl")
  WebElement accountNameLabel;

  @FindBy(id = "name_i")
  WebElement accountNameTextField;

  @FindBy(xpath = ".//*[@id='telephone1_i']")
  WebElement mainPhoneTextField;


  public DynamicsPage(WebDriver driver) {
    this.driver = driver;
    //This initElements method will create all WebElements
    AjaxElementLocatorFactory factory = new AjaxElementLocatorFactory(driver, 100);
    PageFactory.initElements(factory, this);
  }

  public WebElement getMainNavegationBar() {
    return mainNavegationBar;
  }

  public WebElement getNavItemSalesButton() {
    return navItemSalesButton;
  }

  public WebElement getNavTabSalesButton() {
    return navTabSalesButton;
  }

  public WebElement getCustomersAccountsButton() {
    return customersAccountsButton;
  }

  public void clickSalesButton() {
    navItemSalesButton.click();
  }

  public void clickAccountButton() {
    customersAccountsButton.click();
  }

  public WebElement getNavTabGlobal() {
    return navTabGlobal;
  }

  public WebElement getRecAccountButton() {
    return recAccountButton;
  }

  public WebElement getAccountFormTittle() {
    return accountFormTittle;
  }

  public WebElement getAccountNameLabel() {
    return accountNameLabel;
  }

  public WebElement getAccountNameTextField() {
    return accountNameTextField;
  }

  public WebElement getMainPhoneTextField() {
    return mainPhoneTextField;
  }

  public WebElement getSaveNewAccountButton() {
    return saveNewAccountButton;
  }

  public WebElement getListAccountsContainer() {
    return listAccountsContainer;
  }
}