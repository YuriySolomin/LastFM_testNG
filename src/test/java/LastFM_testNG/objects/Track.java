package LastFM_testNG.objects;

/**
 * Created with IntelliJ IDEA.
 * User: solomin-y
 * Date: 7/15/15
 * Time: 12:26 PM

 */
public class Track {
  private long trackId;
  private String trackName;
  private Band band;

  public Track(long trackId, String name) {
    this.trackId = trackId;
    trackName = name;
  }

  public long getTrackId() {
    return trackId;
  }

  public void setTrackId(long trackId) {
    this.trackId = trackId;
  }

  public String getTrackName() {
    return trackName;
  }

  public void setTrackName(String trackName) {
    this.trackName = trackName;
  }

  public Band getBand() {
    return band;
  }

  public void setBand(Band band) {
    this.band = band;
  }
}
