package LastFM_testNG.core;

/**
 * Created with IntelliJ IDEA.
 * User: solomin-y
 * Date: 7/17/15
 * Time: 9:11 AM

 */
public interface LastFMService {

  public <T> void Save(T data);
  public <T> T Load();
}
