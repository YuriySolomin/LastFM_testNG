package LastFM_testNG.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created with IntelliJ IDEA.
 * User: solomin-y
 * Date: 7/15/15
 * Time: 11:38 AM

 */
public class GeneralChartsPage extends BasePage {

  @FindBy(css = ".recentTracksContainer a[href$='tracks']")
  public WebElement linkToTracksList;

  public GeneralChartsPage(WebDriver webDriver) {
    super(webDriver);
  }

  public TracksPage clickLinkToTracks() {
    linkToTracksList.click();
    return createPage(TracksPage.class);
  }

}
