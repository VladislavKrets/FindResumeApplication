package com.findresume.app.model.threads;

import com.findresume.app.Controller;
import com.findresume.app.model.Model;
import com.findresume.app.model.Resume;
import javafx.application.Platform;

import java.util.List;

/**
 * Created by lollipop on 16.06.2017.
 */
public class LoadingFromDBThread extends Thread{
    private Controller controller;
    private Model model;

    public LoadingFromDBThread(Controller controller) {
        this.controller = controller;
        model = new Model();
    }

    @Override
    public void run() {
        List<Resume> resumeList = model.getResumeDao().getResumesFromDB();
        for (Resume resume : resumeList) {
            String itemLine = String.format("%s%nOwner id: %s, Owner sex: %s%n" +
                            (resume.getAge() == null ? "" : "Owner age: " + resume.getAge() + "%n") +
                            (resume.getBirthday() == null ? "" : "Owner birthday: " + resume.getBirthday() + "%n") +
                            ("Owner experience: %s%nResume url: https://ekb.zarplata.ru%s"),
                    resume.getHeader(), resume.getOwner_id(),
                    resume.getSex(), resume.getExperience(), resume.getUrl());

            Platform.runLater(() -> controller.addItemListView(itemLine));
        }
        Platform.runLater(() -> {
            controller.getStartButton().setDisable(false);
            controller.getDeleteFromDBButton().setDisable(false);
            controller.getLoadFromDBButton().setDisable(false);
        });
    }
}
