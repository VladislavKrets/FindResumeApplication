package com.findresume.app.model.threads;

import com.findresume.app.Controller;
import com.findresume.app.model.Model;
import com.findresume.app.model.Resume;
import javafx.application.Platform;

import java.io.IOException;
import java.util.List;

/**
 * Created by lollipop on 16.06.2017.
 */
public class StartThread extends Thread {
    private Model model;
    private Controller controller;
    private String maxAge, minAge, salary;

    public StartThread(Controller controller, String maxAge,
                       String minAge, String salary) {
        model = new Model();
        this.controller = controller;
        this.maxAge = maxAge;
        this.minAge = minAge;
        this.salary = salary;
    }

    @Override
    public void run() {
        try {
            List<Resume> resumeList = model.getResumes(maxAge, minAge, salary);
            model.getResumeDao().putResumesIntoDB(resumeList);
            for (Resume resume : resumeList) {
                String itemLine = String.format("%s%nOwner id: %s, Owner sex: %s%n" +
                                (resume.getAge() == null ? "" : "Owner age: " + resume.getAge() + "%n") +
                                (resume.getBirthday() == null ? "" : "Owner birthday: " + resume.getBirthday() + "%n") +
                                ("Owner experience: %s%nResume url: https://ekb.zarplata.ru%s"),
                        resume.getHeader(), resume.getOwner_id(),
                        resume.getSex(), resume.getExperience(), resume.getUrl());

                Platform.runLater(() -> controller.addItemListView(itemLine));
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            Platform.runLater(() -> {
                controller.getStartButton().setDisable(false);
                controller.getDeleteFromDBButton().setDisable(false);
                controller.getLoadFromDBButton().setDisable(false);
            });
        }
    }
}
