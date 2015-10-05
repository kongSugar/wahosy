package de.kongsugar.wahosy.gui.root.scene.store;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by Niko on 05.10.2015.
 */
public class NewBoxController implements Initializable {

    @FXML
    private Button cancel;

    public void close() {
        Stage s = (Stage) cancel.getScene().getWindow();
        s.close();
    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        Platform.runLater(() -> {
            cancel.getScene().getWindow().onCloseRequestProperty().set(event -> {
                close();
            });
        });
    }
}
