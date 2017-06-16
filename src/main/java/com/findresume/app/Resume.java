package com.findresume.app;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by lollipop on 16.06.2017.
 */
@Entity
@Table(name = "resume")
public class Resume {
    @Id
    @Column(name = "id")
    private int id;
    @Column
    private String owner_id;
    @Column
    private String age;
    @Column
    private String header;
    @Column
    private String experience;
    @Column
    private String url;
    @Column
    private String birthday;
    @Column
    private String sex;

    public Resume(int id, String owner_id, String age, String header,
                  String experience, String url, String birthday, String sex) {
        this.id = id;
        this.owner_id = owner_id;
        this.age = age;
        this.header = header;
        this.experience = experience;
        this.url = url;
        this.birthday = birthday;
        this.sex = sex;
    }

    public int getId() {
        return id;
    }

    public String getOwner_id() {
        return owner_id;
    }

    public String getAge() {
        return age;
    }

    public String getHeader() {
        return header;
    }

    public String getExperience() {
        return experience;
    }

    public String getUrl() {
        return url;
    }

    public String getBirthday() {
        return birthday;
    }

    public String getSex() {
        return sex;
    }
}
