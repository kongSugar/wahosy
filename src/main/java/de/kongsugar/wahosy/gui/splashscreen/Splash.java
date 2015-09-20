package de.kongsugar.wahosy.gui.splashscreen;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * Created by nikog on 21.09.2015.
 */
public class Splash extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(Splash.class.getResource("SplashLayout.fxml"));
        Scene scene = new Scene(root);

        primaryStage.setTitle("AxxG - FXML Beispiel");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
