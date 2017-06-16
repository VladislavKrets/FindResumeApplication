package com.findresume.app;

import com.findresume.app.model.Model;
import com.findresume.app.model.Resume;

import java.io.IOException;
import java.util.List;

/**
 * Created by lollipop on 16.06.2017.
 */
public class MainApp {
    public static void main(String[] args) throws IOException {
        Model model = new Model();
        List<Resume> list = model.getResumeDao().getResumesFromDB();
        System.out.println(list.get(0).getHeader());
    }
}
