package LastFM_testNG.objects;

import org.joda.time.DateTime;

import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * User: solomin-y
 * Date: 7/15/15
 * Time: 1:24 PM

 */
public class History {
  private Band band;
  private Track track;
  private DateTime dateOfScrobble;

  public History(Band band, Track track, DateTime date) {
    this.band = band;
    this.track = track;
    dateOfScrobble = date;
  }

  public Band getBand() {
    return band;
  }

  public void setBand(Band band) {
    this.band = band;
  }

  public Track getTrack() {
    return track;
  }

  public void setTrack(Track track) {
    this.track = track;
  }

  public DateTime getDateOfScrobble() {
    return dateOfScrobble;
  }

  public void setDateOfScrobble(DateTime dateOfScrobble) {
    this.dateOfScrobble = dateOfScrobble;
  }
}
