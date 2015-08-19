package LastFM_testNG.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

/**
 * Sample page
 */
public class HomePage extends Page {

  @FindBy(how = How.TAG_NAME, using = "h1")
  @CacheLookup
  public WebElement header;

  @FindBy(how = How.CSS, using = ".site-auth .auth-link.auth-login-link")
  public WebElement loginLink;

  public HomePage(WebDriver webDriver) {
    super(webDriver);
  }

  public LoginPage clickLoginLink() {
    loginLink.click();
    return createPage(LoginPage.class);
  }

}
