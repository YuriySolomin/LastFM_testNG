package LastFM_testNG.database.hibernate.utils;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.logging.Level;
import java.util.logging.Logger;

/**

 */
public class HibernateUtil {
    private static final Logger log = Logger.getAnonymousLogger();
    private static final ThreadLocal session = new ThreadLocal();
    private static final SessionFactory sessionFactory =
            new Configuration().configure().buildSessionFactory();

    protected HibernateUtil() {
    }

    public static Session getSession() {
        Session session = (Session) HibernateUtil.session.get();
        if (session == null) {
            session = sessionFactory.openSession();
            HibernateUtil.session.set(session);
        }
        return session;
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    protected void begin() {
        getSession().beginTransaction();
    }

    protected void commit() {
        getSession().getTransaction().commit();
    }

    protected void rollback() {
        try {
            getSession().getTransaction().rollback();
        } catch (HibernateException e) {
            log.log(Level.WARNING, "Cannot rollback", e);
        }
        try {
            getSession().close();
        } catch (HibernateException e) {
            log.log(Level.WARNING, "Cannot close", e);
        }
        HibernateUtil.session.set(null);
    }

    public static void close() {
        getSession().close();
        HibernateUtil.session.set(null);
    }

}
