package LastFM_testNG.database.hibernate.activity;

import LastFM_testNG.database.hibernate.logic.Bands;

import java.util.List;

/**
 * Created by solomin-y on 7/29/2015.
 */
public interface BandsActivity {

    public void addBand(Bands band);
    public List<Bands> getBandsByName(String name);
    public Bands getBandsById(long id);
}
