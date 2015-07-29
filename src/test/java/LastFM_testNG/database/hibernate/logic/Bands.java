package LastFM_testNG.database.hibernate.logic;

import javax.persistence.*;

/**
 * Created by solomin-y on 7/29/2015.
 *
 create table lf_bands (
    id_band				integer AUTO_INCREMENT not null,
    band_name			varchar(100) not null,
    primary key (id_band)
 );

 */
@Entity
@Table(name = "lf_bands")
public class Bands {

    private long idBand;
    private String nameBand;

    @Id
    @GeneratedValue
    @Column(name = "id_band")
    public long getIdBand() {
        return idBand;
    }

    public void setIdBand(long idBand) {
        this.idBand = idBand;
    }

    @Column(name = "band_name")
    public String getNameBand() {
        return nameBand;
    }

    public void setNameBand(String nameBand) {
        this.nameBand = nameBand;
    }
}
