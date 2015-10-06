package de.kongsugar.wahosy.gui.root.scene.box;

import de.kongsugar.wahosy.gui.root.scene.SceneBuilder;
import de.kongsugar.wahosy.gui.root.scene.SceneHelper;
import javafx.fxml.Initializable;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by Niko on 06.10.2015.
 */
public class BoxViewController implements Initializable {
    SceneBuilder sb = new SceneBuilder(null);

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    public void newBox() throws IOException {
        sb.showDialog(SceneHelper.DIALOG_NEW_BOX);
    }
}
