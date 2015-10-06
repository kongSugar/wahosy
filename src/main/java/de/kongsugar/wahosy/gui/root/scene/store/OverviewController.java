package de.kongsugar.wahosy.gui.root.scene.store;

import de.kongsugar.wahosy.gui.MainApp;
import de.kongsugar.wahosy.gui.root.scene.SceneBuilder;
import de.kongsugar.wahosy.gui.root.scene.SceneHelper;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.fxml.JavaFXBuilderFactory;
import javafx.scene.Scene;
import javafx.scene.control.Dialog;
import javafx.scene.control.DialogPane;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by Niko on 04.10.2015.
 */
public class OverviewController implements Initializable {
    private MainApp application;
    private SceneBuilder sb = new SceneBuilder(null);

    public void setApplication(MainApp application) {
        this.application = application;
    }


    public void showInsertDialog() throws IOException {
        sb.showDialog(SceneHelper.DIALOG_NEW_ITEM);
    }

    public void showNewBoxDialog() throws IOException {
        sb.showDialog(SceneHelper.DIALOG_NEW_BOX);    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}

