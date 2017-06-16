package com.findresume.app.model.dao;

import com.findresume.app.model.Resume;

import java.util.List;

/**
 * Created by lollipop on 16.06.2017.
 */
public interface ResumeDao {

    void putResumesIntoDB(List<Resume> resumeList);
    void deleteAllResumesFromDB();
    List<Resume> getResumesFromDB();
}
