package com.example.melody;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;

public class HomeUi extends Application {


    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("homeUi-view.fxml"));
        Scene scene = new Scene(root, 1600 , 900);

        String css = this.getClass().getResource("styles.css").toExternalForm();
        scene.getStylesheets().add(css);


        Image icon = new Image(getClass().getResourceAsStream("images/musical-note.png"));


        primaryStage.getIcons().add(icon);
        primaryStage.setTitle("Melody v1.0!");

        primaryStage.setResizable(true);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
