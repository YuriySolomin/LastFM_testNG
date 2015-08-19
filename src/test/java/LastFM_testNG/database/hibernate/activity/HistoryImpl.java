package LastFM_testNG.database.hibernate.activity;

import LastFM_testNG.database.hibernate.logic.History;
import LastFM_testNG.database.hibernate.utils.HibernateUtil;
import org.hibernate.Session;

/**
 * Created by solomin-y on 8/3/2015.
 */
public class HistoryImpl implements HistoryActivity {

    public void addHistory(History history) {
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.save(history);
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
}
