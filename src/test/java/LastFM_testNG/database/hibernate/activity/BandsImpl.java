package LastFM_testNG.database.hibernate.activity;

import LastFM_testNG.database.hibernate.logic.Bands;
import LastFM_testNG.database.hibernate.utils.HibernateUtil;
import org.hibernate.Query;
import org.hibernate.Session;

import java.util.ArrayList;
import java.util.List;

/**

 */
public class BandsImpl implements GeneralActivity {

    public <T> void addObject(T band) {
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.save(band);
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

    public <T> void deleteObject(T object) {}

    public <T> T getObject(long objectId) {
        return null;
    }


    public List<Bands> getBandsByName(String name) {
        Session session = null;
        List<Bands> result = new ArrayList<Bands>();
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            Query query = session.createQuery("from Bands where nameBand = :name");
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

    public Bands getBandsById(long id) {
        Session session = null;
        Bands result = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            result = (Bands) session.load(Bands.class, id);
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
