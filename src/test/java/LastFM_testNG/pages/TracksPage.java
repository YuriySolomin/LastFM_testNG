package LastFM_testNG.pages;

import LastFM_testNG.objects.Band;
import LastFM_testNG.objects.History;
import LastFM_testNG.objects.Track;
import org.joda.time.DateTime;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: solomin-y
 * Date: 7/15/15
 * Time: 11:48 AM

 */
public class TracksPage extends BasePage {

  private List<History> tracksHistory;

  @FindBy(css = "a[href*='view=compact']")
  public WebElement linkSwitchToCompact;

  @FindBy(css = "table#deletablert tr")
  private List<WebElement> listOfTracks;

  public TracksPage(WebDriver webDriver) {
    super(webDriver);
  }

  public TracksPage clickSwitchToCompact() {
    linkSwitchToCompact.click();
    return this;
  }

  public List<WebElement> getAllTracks() {
    return listOfTracks;
  }

  public void workWithTracks() {
    if (listOfTracks == null || listOfTracks.isEmpty())
      getAllTracks();
    if (tracksHistory == null)
      tracksHistory = new ArrayList<History>();
    //
    for (WebElement webElement: listOfTracks) {
      Track track = new Track(Long.parseLong(webElement.getAttribute("data-track-id")), webElement.findElement(By.cssSelector("td.subjectCell")).findElements(By.tagName("a")).get(1).getText());
      Band band = new Band(webElement.findElement(By.cssSelector("td.subjectCell")).findElements(By.tagName("a")).get(0).getText());
      track.setBand(band);
      DateTime dt = new DateTime(webElement.findElement(By.cssSelector(".dateCell.last")).findElement(By.tagName("time")).getAttribute("datetime")) ;
      History history = new History(band, track, dt);
      tracksHistory.add(history);
    }
  }

}
