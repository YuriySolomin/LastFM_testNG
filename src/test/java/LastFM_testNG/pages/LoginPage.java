package LastFM_testNG.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

/**
 * Created with IntelliJ IDEA.
 * User: solomin-y
 * Date: 7/13/15
 * Time: 2:24 PM

 */
public class LoginPage extends Page {

  @FindBy(how = How.ID, using = "id_username")
  public WebElement loginInput;

  @FindBy(how = How.ID, using = "id_password")
  public WebElement passwordInput;

  @FindBy(how = How.NAME, using = "submit")
  public WebElement loginButton;

  public LoginPage(WebDriver webDriver) {
      super(webDriver);
  }

  public void setLogin(String login) {
    loginInput.sendKeys(login);
  }

  public void setPassword(String password) {
    passwordInput.sendKeys(password);
  }

  public MainPage clickLoginButton() {
    loginButton.click();
    return createPage(MainPage.class);
  }
}
