package de.kongsugar.wahosy.gui;

import de.kongsugar.wahosy.database.ConnectionFactory;
import de.kongsugar.wahosy.gui.splash.SplashController;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * Created by nikog on 21.09.2015.
 */
public class MainApp extends Application {


    public static void main(String[] args) {
        ConnectionFactory.setProperties("bla", "bla", "bla", "bla", "bla");
        launch(args);
    }

    @Override
    public void start(Stage initStage) throws Exception {
        showSplashscreen(initStage);

    }

    public void showSplashscreen(Stage initStage) throws IOException {
        FXMLLoader loader = new FXMLLoader(MainApp.class.getResource("splash/SplashLayout.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root);
        initStage.setTitle("AxxG - FXML Beispiel");
        initStage.setScene(scene);

        initStage.show();


        SplashController c = loader.getController();

        c.setLabel("Thr");
        Platform.runLater(() -> {
            c.getCountdown();
            System.out.println("Is Running . . .");
            for (int i = 0; i < 10; i++) {
                c.setLabel("Time = " + i);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            c.getCountdown().setText("JAAA");
        });

    }

}
