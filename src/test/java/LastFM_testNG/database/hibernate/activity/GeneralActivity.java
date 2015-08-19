package LastFM_testNG.database.hibernate.activity;

/**
 * Created by solomin-y on 8/3/2015.
 */
public interface GeneralActivity {

    public <T> void addObject(T object);
    public <T> void deleteObject(T object);
    public <T> T getObject(long objectId);

}
