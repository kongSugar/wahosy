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
 * MainApp is the entry-point of the application.
 * It is responsible for loading the stage and to switch from the splashscreen to the root.
 */
public class MainApp extends Application {
    public Stage stage;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        stage = primaryStage;
        //TODO
        gotoSplash();
        //gotoRoot();
        stage.show();
    }

    /**
     * Calling this method replaces the scene to display the splashscreen
     */
    public void gotoSplash() {
        try {
            SplashController splash = (SplashController) replaceSceneContent("splash/SplashLayout.fxml");
            splash.setApp(this);
            stage.setResizable(false);
            stage.setTitle("Wahosy");
            stage.centerOnScreen();
            stage.setWidth(600);
            stage.setHeight(400);
            stage.centerOnScreen();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Calling this method replaces the scene to display the root scene
     */
    public void gotoRoot() {
        try {
            stage.setResizable(true);
            stage.setWidth(1000);
            stage.setHeight(800);
            stage.centerOnScreen();
            stage.setMaximized(true);
            stage.setTitle("Wahosy");

            RootController root = (RootController) replaceSceneContent("root/RootLayout.fxml");
            root.setApp(this);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Replaces the scene in the stage of the app and returns the instance of it´s controller
     *
     * @param fxml - location of the fxml-file to load
     * @return controller addressed with the fxml file
     * @throws IOException
     */
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
        stage.setScene(new Scene(page));
        return (Initializable) loader.getController();
    }

}
