package de.kongsugar.wahosy.gui.root;

import de.kongsugar.wahosy.gui.MainApp;
import de.kongsugar.wahosy.gui.root.scene.SceneBuilder;
import de.kongsugar.wahosy.gui.root.scene.SceneHelper;
import de.kongsugar.wahosy.gui.root.scene.store.OverviewController;
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

    private SceneBuilder sb;

    public void setApp(MainApp mainApp) {
        this.application = mainApp;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        Platform.runLater(() -> {
            application.stage.minWidthProperty().bind(menuLeft.minWidthProperty().multiply(3));
            application.stage.minHeightProperty().bind(menuLeft.minHeightProperty());
        });
        sb = new SceneBuilder(content);
        loadStartScene();
    }


    public void loadStartScene() {
        sb.build(SceneHelper.DASHBOARD);
    }

    public void loadStoreOverview() {
        OverviewController o = (OverviewController) sb.build(SceneHelper.STORE_VIEW);
        o.setApplication(application);
    }

    public void loadSettings() {
        sb.build(SceneHelper.SETTINGS);
    }
    public void loadItemView(){sb.build(SceneHelper.ITEM_VIEW);}
    public void loadBoxView(){sb.build(SceneHelper.BOX_VIEW);}
    public void loadPlanerView(){
        sb.build(SceneHelper.PLANER_VIEW);
    }

}


