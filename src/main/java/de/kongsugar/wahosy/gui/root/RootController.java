package de.kongsugar.wahosy.gui.root;

import de.kongsugar.wahosy.gui.MainApp;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.fxml.JavaFXBuilderFactory;
import javafx.scene.control.Button;
import javafx.scene.control.TitledPane;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by nikog on 25.09.2015.
 */
public class RootController implements Initializable {
    private MainApp application;

    @FXML
    private AnchorPane menuLeft;
    @FXML
    private TitledPane homeMenu;
    @FXML
    private Button btn;
    @FXML
    private AnchorPane content;

    public void setApp(MainApp mainApp) {
        this.application = mainApp;
    }

    private void setContent(String scene) {
        try {
            URL url = getClass().getResource(scene);
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(url);
            fxmlLoader.setBuilderFactory(new JavaFXBuilderFactory());
            AnchorPane node = fxmlLoader.load(url.openStream());
            content.getChildren().setAll(node);

            node.prefHeightProperty().bind(content.heightProperty());
            node.prefWidthProperty().bind(content.widthProperty());


        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        Platform.runLater(() -> {
            application.stage.minWidthProperty().bind(menuLeft.minWidthProperty().multiply(3));
            application.stage.minHeightProperty().bind(menuLeft.minHeightProperty());
        });
        loadStartScene();
    }


    public void loadStartScene() {
        setContent(Scenes.STARTPAGE);

    }

    public void loadStoreOverview() {
        setContent(Scenes.STORE_OVERVIEW);
    }

    public void loadSettings() {
        setContent(Scenes.SETTINGS);
    }
}

final class Scenes {
    static final String STARTPAGE = "scene/start/StartpageLayout.fxml";
    static final String SETTINGS = "scene/settings/SettingsLayout.fxml";
    static final String STORE_OVERVIEW = "scene/store/OverviewLayout.fxml";

    private Scenes(){}

}
