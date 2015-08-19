package LastFM_testNG.database.hibernate.logic;

import javax.persistence.*;

/**
 * Created by solomin-y on 7/29/2015.
 *
 create table lf_songs (
    id_song				integer AUTO_INCREMENT not null,
    id_band				integer not null,
    song_name			varchar(100) not null,
    lf_key				varchar(30) not null,
    primary key (id_song),
    foreign key (id_band) references lf_bands (id_band)
 );

 */
@Entity
@Table(name = "lf_songs")
public class Songs {

    private long idSong;
    private long idBand;
    private String songName;
    private String lfKey;

    public Songs() {}

    public Songs(long idBand, String songName, String lfKey) {
        Bands bands = new Bands();
        String k = bands.bubu;

        this.idBand = idBand;
        this.songName = songName;
        this.lfKey = lfKey;
    }

    @Id
    @GeneratedValue
    @Column(name = "id_song")
    public long getIdSong() {
        return idSong;
    }

    public void setIdSong(long idSong) {
        this.idSong = idSong;
    }

    @Column(name = "id_band")
    public long getIdBand() {
        return idBand;
    }

    public void setIdBand(long idBand) {
        this.idBand = idBand;
    }

    @Column(name = "song_name")
    public String getSongName() {
        return songName;
    }

    public void setSongName(String songName) {
        this.songName = songName;
    }

    @Column(name = "lf_key")
    public String getLfKey() {
        return lfKey;
    }

    public void setLfKey(String lfKey) {
        this.lfKey = lfKey;
    }
}
