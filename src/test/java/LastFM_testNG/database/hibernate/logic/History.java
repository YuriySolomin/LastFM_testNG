package LastFM_testNG.database.hibernate.logic;

import org.hibernate.annotations.Type;
import org.joda.time.DateTime;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by solomin-y on 7/31/2015.
 */
@Entity
@Table(name = "lf_history")
public class History {

    private long id;
    private long idBand;
    private long idSong;
    private DateTime scrobbleDate;
    private Set<Bands> bandses = new HashSet<Bands>();


    public History() {}

    public History(long idBand, long idSong, DateTime scrobbleDate) {
        this.idBand = idBand;
        this.idSong = idSong;
        this.scrobbleDate = scrobbleDate;
    }

    @Id
    @GeneratedValue
    @Column(name = "id")
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Column(name = "id_band")
    public long getIdBand() {
        return idBand;
    }

    public void setIdBand(long idBand) {
        this.idBand = idBand;
    }

    @Column(name = "id_song")
    public long getIdSong() {
        return idSong;
    }

    public void setIdSong(long idSong) {
        this.idSong = idSong;
    }

    @Column(name = "scrobble_date")
    @Type(type="org.joda.time.contrib.hibernate.PersistentDateTime")
    public DateTime getScrobbleDate() {
        return scrobbleDate;
    }

    public void setScrobbleDate(DateTime scrobbleDate) {
        this.scrobbleDate = scrobbleDate;
    }

    @OneToMany
    @JoinColumn(name = "id_band")
    public Set<Bands> getBandses() {
        return bandses;
    }

    public void setBandses(Set<Bands> bandses) {
        this.bandses = bandses;
    }
}
