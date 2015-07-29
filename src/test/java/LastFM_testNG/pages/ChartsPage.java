package LastFM_testNG.pages;

import LastFM_testNG.database.hibernate.activity.BandsImpl;
import LastFM_testNG.database.hibernate.logic.Songs;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

/**

 */
public class ChartsPage extends BasePage {

    @FindBy(css = "tbody tr td.subjectCell a")
    private List<WebElement> listOfChartsLinks;

    @FindBy(css = "tbody tr")
    private List<WebElement> listOfChartsObjects;

    public ChartsPage(WebDriver webDriver) {
        super(webDriver);
    }

    public List<WebElement> getListOfChartsLinks() {
        return listOfChartsLinks;
    }

    public List<String> getAllBandsNames() {
        List<String> result = new ArrayList<String>();
        for (WebElement webElement: listOfChartsLinks) {
            result.add(webElement.getText());
        }
        return result;
    }

    public List<Songs> getAllSongs() {
        List<Songs> result = new ArrayList<Songs>();
        for (WebElement webElement: listOfChartsObjects) {
            Songs songs = new Songs();
            songs.setLfKey(webElement.getAttribute("data-track-id"));
            String bandName = webElement.findElements(By.cssSelector(".subjectCell a")).get(0).getText();
            String songName = webElement.findElements(By.cssSelector(".subjectCell a")).get(1).getText();
            songs.setSongName(songName);
            songs.setIdBand((new BandsImpl()).getBandsByName(bandName).get(0).getIdBand());
            result.add(songs);
        }
        return result;
    }
}
