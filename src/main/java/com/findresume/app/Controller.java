package com.findresume.app;

import com.findresume.app.model.StartThread;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

public class Controller {
    @FXML
    private TextField minAgeTextField;
    @FXML
    private TextField maxAgeTextField;
    @FXML
    private TextField salaryTextField;
    @FXML
    private Button startButton;
    @FXML
    private Button loadFromDBButton;
    @FXML
    private Button deleteFromDBButton;
    @FXML
    private ListView<String> resumeListView;
    @FXML
    public void onStartButtonListener() {
        System.out.println("click");
        startButton.setDisable(true);
        loadFromDBButton.setDisable(true);
        deleteFromDBButton.setDisable(true);
        resumeListView.getItems().clear();
        new StartThread(this, maxAgeTextField.getText(),
                minAgeTextField.getText(), salaryTextField.getText()).start();

    }
    public void addItemListView(String item) {
        resumeListView.getItems().add(item);
    }

    public Button getStartButton() {
        return startButton;
    }

    public Button getLoadFromDBButton() {
        return loadFromDBButton;
    }

    public Button getDeleteFromDBButton() {
        return deleteFromDBButton;
    }
}

