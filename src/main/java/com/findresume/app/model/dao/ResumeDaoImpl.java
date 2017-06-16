package com.findresume.app.model.dao;

import com.findresume.app.model.Resume;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import javax.persistence.Query;
import java.util.List;

/**
 * Created by lollipop on 16.06.2017.
 */
public class ResumeDaoImpl implements ResumeDao{
    private static Configuration aConf;
    private static SessionFactory sessionFactory;

    static {
        aConf = new Configuration()
                .addAnnotatedClass(Resume.class);

        sessionFactory = aConf.configure().buildSessionFactory();
    }

    @Override
    public void putResumesIntoDB(List<Resume> resumeList) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        for (Resume resume : resumeList) {
            session.saveOrUpdate(resume);
        }
        session.getTransaction().commit();
        session.close();

    }

    @Override
    public void deleteAllResumesFromDB() {
        Session session = sessionFactory.openSession();
        List<Resume> resumeList = getResumesFromDB();
        session.beginTransaction();
        for (Resume resume : resumeList) {
            session.delete(resume);
        }
        session.getTransaction().commit();
        session.close();

    }

    @Override
    public List<Resume> getResumesFromDB() {
        Session session = sessionFactory.openSession();
        Query query = session.createQuery("from Resume");
        List<Resume> list = query.getResultList();
        session.close();
        return list;
    }

    public static Configuration getaConf() {
        return aConf;
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
}
