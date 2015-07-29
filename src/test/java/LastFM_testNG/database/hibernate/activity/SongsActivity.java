package LastFM_testNG.database.hibernate.activity;

import LastFM_testNG.database.hibernate.logic.Songs;

import java.util.List;

/**
 * Created by solomin-y on 7/29/2015.
 */
public interface SongsActivity {

    public void addSong(Songs songs);
    public List<Songs> getSongsByName(String name);
    public Songs getSongsById(long id);

}
