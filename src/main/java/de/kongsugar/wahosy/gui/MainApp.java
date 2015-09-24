package de.kongsugar.wahosy.gui;

import de.kongsugar.wahosy.gui.splash.SplashController;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.fxml.JavaFXBuilderFactory;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.io.InputStream;

/**
 * Created by nikog on 21.09.2015.
 */
public class MainApp extends Application {
    private Group root = new Group();


    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setResizable(true);
        primaryStage.setScene(new Scene(createContent()));
        primaryStage.show();

    }

    private Parent createContent() {
        gotoSplash();
        return root;
    }

    private void gotoSplash() {
        try {
            SplashController start = (SplashController) replaceSceneContent("splash/SplashLayout.fxml");
            start.setApp(this);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void gotoStart() {
        try {
            StartController start = (StartController) replaceSceneContent("Start.fxml");
            start.setApp(this);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void gotoSettings() {

    }

    private Initializable replaceSceneContent(String fxml) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        InputStream in = MainApp.class.getResourceAsStream(fxml);
        loader.setBuilderFactory(new JavaFXBuilderFactory());
        loader.setLocation(MainApp.class.getResource(fxml));
        AnchorPane page;
        try {
            page = loader.load(in);
        } finally {
            in.close();
        }
        root.getChildren().removeAll();
        root.getChildren().addAll(page);
        return (Initializable) loader.getController();
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
