package LastFM_testNG.database.hibernate.activity;

import LastFM_testNG.database.hibernate.logic.Bands;
import LastFM_testNG.database.hibernate.logic.Songs;
import LastFM_testNG.database.hibernate.utils.HibernateUtil;
import org.hibernate.Query;
import org.hibernate.Session;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by solomin-y on 7/29/2015.
 */
public class SongsImpl implements SongsActivity {

    public void addSong(Songs songs) {
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.save(songs);
            session.getTransaction().commit();
        }catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
        }finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }

    }

    public List<Songs> getSongsByName(String name) {
        Session session = null;
        List<Songs> result = new ArrayList<Songs>();
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            Query query = session.createQuery("from Songs where songName = :name");
            query.setString("name", name);
            result = query.list();
        } catch (Exception e) {
            e.printStackTrace();

        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return result;

    }

    public Songs getSongsById(long id) {

        Session session = null;
        Songs result = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            result = (Songs) session.load(Songs.class, id);
        }catch (Exception e) {
            e.printStackTrace();

        }finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return result;

    }

}
