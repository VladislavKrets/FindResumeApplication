package com.findresume.app;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(Main.class.getResource("/view.fxml"));
        Parent root = loader.load();
        primaryStage.setTitle("Find resume");
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
        Controller controller = loader.getController();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
