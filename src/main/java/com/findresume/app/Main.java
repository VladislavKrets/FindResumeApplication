package com.findresume.app;

import com.findresume.app.model.Model;
import com.findresume.app.model.dao.ResumeDaoImpl;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(Main.class.getResource("/view.fxml"));
        Parent root = loader.load();
        primaryStage.setTitle("Find resume");
        primaryStage.setResizable(false);
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
        Controller controller = loader.getController();
        controller.setMain(this);
    }

    @Override
    public void stop() throws Exception {
        ResumeDaoImpl.getSessionFactory().close();
        StandardServiceRegistryBuilder.destroy(ResumeDaoImpl.getSessionFactory()
                .getSessionFactoryOptions().getServiceRegistry());
        super.stop();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
