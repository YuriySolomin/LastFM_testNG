package LastFM_testNG.database.hibernate.utils;

import LastFM_testNG.database.hibernate.activity.BandsImpl;
import LastFM_testNG.database.hibernate.activity.SongsImpl;
import LastFM_testNG.database.hibernate.logic.Bands;
import LastFM_testNG.database.hibernate.logic.History;
import LastFM_testNG.database.hibernate.logic.Songs;
import org.joda.time.DateTime;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

/**

 */
public class ParseToDatabaseObject implements Parser {

    public void parseWebElementsList(List<WebElement> webElementList) {
        for (WebElement webElement: webElementList) {
            long idBand = 0;
            List<Bands> bandsList = (new BandsImpl()).getBandsByName(webElement.findElement(By.cssSelector("td.subjectCell")).findElements(By.tagName("a")).get(0).getText());
            if (bandsList.size() == 1)
                idBand = bandsList.get(0).getIdBand();
            else if (bandsList.size() == 0) {
                Bands bands = new Bands(webElement.findElement(By.cssSelector("td.subjectCell")).findElements(By.tagName("a")).get(0).getText());
                (new BandsImpl()).addObject(bands);
                idBand = bands.getIdBand();
            }
            else
                throw new IllegalArgumentException("name: " + bandsList.get(0).getNameBand());
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


        }
    }

}
