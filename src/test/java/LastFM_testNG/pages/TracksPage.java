package LastFM_testNG.pages;

import LastFM_testNG.database.hibernate.activity.BandsImpl;
import LastFM_testNG.database.hibernate.activity.SongsImpl;
import LastFM_testNG.database.hibernate.logic.Bands;
import LastFM_testNG.database.hibernate.logic.History;
import LastFM_testNG.database.hibernate.logic.Songs;
import org.joda.time.DateTime;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;

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

    @FindBy(css = "svg > g:nth-last-of-type(3) rect")
    private List<WebElement> listOfRectToYears;

    @FindBy(css = "svg > g:nth-last-of-type(2) text tspan")
    private List<WebElement> listOfTexts;



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

  public List<History> workWithTracks() {
    if (listOfTracks == null || listOfTracks.isEmpty())
      getAllTracks();
    if (tracksHistory == null)
      tracksHistory = new ArrayList<History>();
    //
    for (WebElement webElement: listOfTracks) {
        long idBand = (new BandsImpl()).getBandsByName(webElement.findElement(By.cssSelector("td.subjectCell")).findElements(By.tagName("a")).get(0).getText()).get(0).getIdBand();
        long idSong = 0;
        List<Songs> songsList = (new SongsImpl()).getSongsByName(webElement.findElement(By.cssSelector("td.subjectCell")).findElements(By.tagName("a")).get(1).getText());
        if (songsList.size() == 1)
            idSong = songsList.get(0).getIdSong();
        else if (songsList.size() == 0) {
            Songs songs = new Songs(idBand, webElement.findElement(By.cssSelector("td.subjectCell")).findElements(By.tagName("a")).get(1).getText(), webElement.getAttribute("data-track-id"));
            (new SongsImpl()).addSong(songs);
            idSong = songs.getIdSong();
        }
        else
            throw new IllegalArgumentException("name: " + songsList.get(0).getSongName());

      DateTime dt = new DateTime(webElement.findElement(By.cssSelector(".dateCell.last")).findElement(By.tagName("time")).getAttribute("datetime")) ;
      History history = new History(idBand, idSong, dt);
      tracksHistory.add(history);
    }
    return tracksHistory;
  }

    public Map<String, WebElement> listOfDiagrams() {
        Map<String, WebElement> result = new Hashtable<String, WebElement>();
        if (listOfRectToYears.size() != listOfTexts.size())
            throw new IllegalArgumentException("Something is wrong in the page's css");
        int counter = 0;
        for (WebElement webElement: listOfRectToYears) {
            result.put(listOfTexts.get(counter++).getText(), webElement);
            System.out.println(webElement.getText());
        }
        return result;
    }

    public TracksPage clickSelectedDiagramm(String key) {
        listOfDiagrams().get(key).click();
        return createPage(TracksPage.class);
    }

}
