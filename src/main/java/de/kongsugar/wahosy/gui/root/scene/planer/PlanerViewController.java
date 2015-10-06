package de.kongsugar.wahosy.gui.root.scene.planer;

import de.kongsugar.wahosy.gui.root.scene.SceneBuilder;
import de.kongsugar.wahosy.gui.root.scene.SceneHelper;
import javafx.fxml.Initializable;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by Niko on 06.10.2015.
 */
public class PlanerViewController  implements Initializable{
    SceneBuilder sb = new SceneBuilder(null);

    public void loadCreateNewOrderScene() throws IOException {
        sb.showDialog(SceneHelper.PLANER_CREATE_1_CONTACT);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}
