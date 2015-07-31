package LastFM_testNG.database.hibernate.logic;

import org.joda.time.DateTime;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created by solomin-y on 7/31/2015.
 */
@Entity
@Table(name = "lf_history")
public class History {

    private long id;
    private long idBand;
    private long idSong;
    private DateTime scrobble_date;
}
