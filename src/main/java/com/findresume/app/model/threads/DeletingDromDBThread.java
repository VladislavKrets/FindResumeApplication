package com.findresume.app.model.threads;

import com.findresume.app.Controller;
import com.findresume.app.model.Model;
import javafx.application.Platform;

/**
 * Created by lollipop on 16.06.2017.
 */
public class DeletingDromDBThread extends Thread{
    private Model model;
    private Controller controller;

    public DeletingDromDBThread(Controller controller) {
        model = new Model();
        this.controller = controller;
    }

    @Override
    public void run() {
        model.getResumeDao().deleteAllResumesFromDB();
        Platform.runLater(() -> {
            controller.getStartButton().setDisable(false);
            controller.getDeleteFromDBButton().setDisable(false);
            controller.getLoadFromDBButton().setDisable(false);
        });
    }
}
