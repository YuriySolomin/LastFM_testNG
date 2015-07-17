package LastFM_testNG.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: solomin-y
 * Date: 7/15/15
 * Time: 11:38 AM

 */
public class GeneralChartsPage extends BasePage {

  @FindBy(css = ".recentTracksContainer a[href$='tracks']")
  public WebElement linkToTracksList;

    @FindBy(css = ".module-body.chart.chartoverall.current a[href$='artists']")
    private WebElement linkToBandsPage;

  @FindBy(css = ".flip")
  public List<WebElement> partsOfGeneralCount;


  public GeneralChartsPage(WebDriver webDriver) {
    super(webDriver);
  }

  public TracksPage clickLinkToTracks() {
    linkToTracksList.click();
    return createPage(TracksPage.class);
  }

    public BandsPage clickLinkToBands() {
        linkToBandsPage.click();
        return createPage(BandsPage.class);
    }

  public long getGeneralCountOfTracks() {
    String result = "";
    for (WebElement element: partsOfGeneralCount) {
      result+= element.getText();
    }
    return Long.parseLong(result);
  }


}
