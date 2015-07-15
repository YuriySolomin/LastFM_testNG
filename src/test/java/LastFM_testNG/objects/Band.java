package LastFM_testNG.objects;

/**
 * Created with IntelliJ IDEA.
 * User: solomin-y
 * Date: 7/15/15
 * Time: 12:26 PM
 * To change this template use File | Settings | File Templates.
 */
public class Band {
  private long bandId;
  private String bandName;

  public Band(String name) {
    bandName = name;
  }

  public long getBandId() {
    return bandId;
  }

  public void setBandId(long bandId) {
    this.bandId = bandId;
  }

  public String getBandName() {
    return bandName;
  }

  public void setBandName(String bandName) {
    this.bandName = bandName;
  }

}
