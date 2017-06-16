package com.findresume.app;

import com.fasterxml.classmate.AnnotationConfiguration;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.apache.commons.lang.StringEscapeUtils;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by lollipop on 16.06.2017.
 */
public class Model {
    private static final String AGE_MAX = "age_max";
    private static final String AGE_MIN = "age_min";
    private static final String AVERAGE_SALARY = "average_salary";
    private static final String GEO_ID = "geo_id";
    private static final String SALARY = "salary";
    private static final String EK_GEO_ID = "994";
    private static Configuration aConf;

    static {
        aConf = new Configuration()
                .addAnnotatedClass(Resume.class);
    }
    private List<Resume> resumes;

    public void getVacancies() throws IOException {

        String answer = HttpMethodUtils.getMethod("resumes/?age_max=25&age_min=20&average_salary=1&geo_id=994&salary=10000");
        GsonBuilder builder = new GsonBuilder();
        builder.registerTypeAdapter(List.class, new JsonResumeConverter());
        Gson gson = builder.create();
        List<Resume> resumeList = gson.fromJson(answer, List.class);
        for (Resume resume : resumeList) {
            System.out.println(resume.getBirthday());
        }
        this.resumes = resumeList;
    }

    public void addToDB() {
        Configuration conf = aConf.configure();
        SessionFactory factory = conf.buildSessionFactory();
        Session session = factory.openSession();
        session.beginTransaction();
        for (Resume resume : resumes) {
            session.saveOrUpdate(resume);
        }
        session.getTransaction().commit();
        session.close();
    }

}
