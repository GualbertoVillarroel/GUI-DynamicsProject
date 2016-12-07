package PageFactory;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

public class DynamicsLogin {
  /**
   * All WebElements are identified by @FindBy annotation
   */
  WebDriver driver;

  @FindBy(id = "cred_userid_inputtext")
  WebElement userId;

  @FindBy(id = "cred_password_inputtext")
  WebElement password;

  @FindBy(id = "cred_sign_in_button")
  WebElement signInButton;


  public DynamicsLogin(WebDriver driver) {
    this.driver = driver;

    //This initElements method will create all WebElements
    AjaxElementLocatorFactory factory = new AjaxElementLocatorFactory(driver, 100);
    PageFactory.initElements(factory, this);
  }

  //Set user id in textbox
  public void setUserId(String strUserId) {
    userId.sendKeys(strUserId);
  }

  //Set password in password textbox
  public void setPassword(String strPassword) {
    password.sendKeys(strPassword);
    password.sendKeys(Keys.ENTER);
  }

  //Click on sign in button
  public void clickLogin() {
    signInButton.click();
  }

  //Return Sign In Button webElement
  public WebElement getLoginButton() {
    return signInButton;
  }

  public void loginToDynamics(String strUserId, String strPasword) {
    //Fill user id
    this.setUserId(strUserId);

    //Fill password
    this.setPassword(strPasword);
  }
}