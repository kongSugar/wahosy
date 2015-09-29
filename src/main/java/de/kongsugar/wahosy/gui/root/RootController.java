package de.kongsugar.wahosy.gui.root;

import de.kongsugar.wahosy.gui.MainApp;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.fxml.JavaFXBuilderFactory;
import javafx.scene.control.Accordion;
import javafx.scene.control.Button;
import javafx.scene.control.TitledPane;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

enum SceneE {
    TEST_LAYOUT("scene/test/TestLayout.fxml");

    String path;

    SceneE(String path) {
        this.path = path;
    }
}

/**
 * Created by nikog on 25.09.2015.
 */
public class RootController implements Initializable {
    private MainApp application;

    @FXML
    private Accordion menuAccordion;
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

    public void loadStartpage() {
        setContent(Scenes.TEST_LAYOUT);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        Platform.runLater(() -> {
            menuAccordion.setExpandedPane(homeMenu);
            application.stage.minWidthProperty().bind(menuAccordion.minWidthProperty().multiply(3));
            application.stage.minHeightProperty().bind(menuAccordion.minHeightProperty());
        });


    }
}

class Scenes {
    static final String TEST_LAYOUT = "scene/test/TestLayout.fxml";
}
