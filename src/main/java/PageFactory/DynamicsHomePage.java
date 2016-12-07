package PageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

public class DynamicsHomePage {
  WebDriver driver;

  @FindBy(id = "navBar")
  WebElement navegationBar;

  @FindBy(css = "span:contains(\"Sales\")")
  WebElement salesButton;


  @FindBy(css = "span#TabSFA[title=Sales]")
  WebElement salesTabButton;

  //  @FindBy(css = "#nav_accts > span.nav-rowLabel")
  @FindBy(id = "nav_accts")
  WebElement navAccountsButton;

  @FindBy(id = "navTabGlobalCreateImage")
  WebElement navTabGlobal;

  @FindBy(xpath = ".//*[@id='{70816501-edb9-4740-a16c-6a5efbc05d84}']")
  WebElement recordsAccountButton;

  @FindBy(className = "mscrm-globalqc-entityname")
  WebElement accountTittle;

  @FindBy(id = "globalquickcreate_save_button_NavBarGloablQuickCreate")
  WebElement saveAccountButton;


  //iFrame (id="NavBarGloablQuickCreate") webElements
  @FindBy(id = "name_cl")
  WebElement accountNameLabel;

  @FindBy(id = "name_i")
  WebElement accountNameTextField;

  @FindBy(id="telephone1_i")
  WebElement mainPhoneTextField;




  public DynamicsHomePage(WebDriver driver) {
    this.driver = driver;
    //This initElements method will create all WebElements
    AjaxElementLocatorFactory factory = new AjaxElementLocatorFactory(driver, 100);
    PageFactory.initElements(factory, this);
  }

  public WebElement getNavegationBar() {
    return navegationBar;
  }

  public WebElement getSalesButton() {
    return salesButton;
  }

  public WebElement getSalesTabButton() {
    return salesTabButton;
  }

  public WebElement getNavAccountsButton() {
    return navAccountsButton;
  }

  public void clickSalesButton() {
    salesButton.click();
  }

  public void clickAccountButton() {
    navAccountsButton.click();
  }

  public WebElement getNavTabGlobal() {
    return navTabGlobal;
  }

  public WebElement getRecordsAccountButton() {
    return recordsAccountButton;
  }

  public WebElement getAccountTittle() {
    return accountTittle;
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

  public WebElement getSaveAccountButton() {
    return saveAccountButton;
  }
}