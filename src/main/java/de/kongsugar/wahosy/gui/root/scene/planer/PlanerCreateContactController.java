package de.kongsugar.wahosy.gui.root.scene.planer;

import de.kongsugar.wahosy.gui.root.scene.SceneBuilder;
import de.kongsugar.wahosy.gui.root.scene.SceneHelper;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by Niko on 06.10.2015.
 */
public class PlanerCreateContactController implements Initializable {
    SceneBuilder sb = new SceneBuilder(null);

    @FXML
    Button cancel;

    public void cancelAction() {
        Stage s = (Stage) cancel.getScene().getWindow();
        s.close();
    }

    public void loadNext() throws IOException {
        sb.showDialog(SceneHelper.PLANER_CREATE_2_LIST);
    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}
