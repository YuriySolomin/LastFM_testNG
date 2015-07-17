package LastFM_testNG.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import javax.xml.ws.WebEndpoint;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: solomin-y
 * Date: 7/15/15
 * Time: 9:44 AM
 */
public class MainPage extends Page {

  private final String myLastFMChartsLink = "http://www.lastfm.ru/user/YurijSol";

  @FindBy(css = ".user-badge")
  public WebElement linkToChartsPage;


  public MainPage(WebDriver webDriver) {
    super(webDriver);
  }

  public GeneralChartsPage clickLinkToCharts() {
    linkToChartsPage.click();
    return createPage(GeneralChartsPage.class);
  }

  public GeneralChartsPage openByLink() {
    driver.get(myLastFMChartsLink);
    return createPage(GeneralChartsPage.class);
  }


}
