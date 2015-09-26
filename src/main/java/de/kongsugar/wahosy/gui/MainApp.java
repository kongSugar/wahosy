package de.kongsugar.wahosy.gui;

import de.kongsugar.wahosy.gui.root.RootController;
import de.kongsugar.wahosy.gui.splash.SplashController;
import javafx.application.Application;
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

    public void gotoSplash() {
        try {
            SplashController splash = (SplashController) replaceSceneContent("splash/SplashLayout.fxml");
            splash.setApp(this);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void gotoRoot() {
        try {
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
            page = loader.load(in);
        } finally {
            in.close();
        }
        //root.getChildren().removeAll();
        root.getChildren().clear();
        root.getChildren().addAll(page);
        return (Initializable) loader.getController();
    }

}
