package de.kongsugar.wahosy.gui;

import de.kongsugar.wahosy.gui.root.RootController;
import de.kongsugar.wahosy.gui.splash.SplashController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.fxml.JavaFXBuilderFactory;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.io.InputStream;

/**
 * Created by nikog on 21.09.2015.
 */
public class MainApp extends Application {
    public Stage stage;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        stage = primaryStage;
        gotoSplash();
        stage.show();
    }

    public void gotoSplash() {
        try {
            SplashController splash = (SplashController) replaceSceneContent("splash/SplashLayout.fxml");
            splash.setApp(this);
            stage.setResizable(false);
            stage.centerOnScreen();
            stage.setWidth(600);
            stage.setHeight(400);
            stage.centerOnScreen();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void gotoRoot() {
        try {
            stage.setResizable(true);
            stage.setWidth(1000);
            stage.setHeight(800);
            stage.centerOnScreen();
            stage.setMaximized(true);

            RootController root = (RootController) replaceSceneContent("root/RootLayout.fxml");
            root.setApp(this);
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
            page = (AnchorPane) loader.load(in);
        } finally {
            in.close();
        }
        stage.setScene(new Scene(page));
        return (Initializable) loader.getController();
    }

}
