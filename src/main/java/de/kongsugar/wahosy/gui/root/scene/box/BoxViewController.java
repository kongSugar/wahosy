package de.kongsugar.wahosy.gui.root.scene.box;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TreeTableView;

import de.kongsugar.wahosy.gui.root.scene.SceneBuilder;
import de.kongsugar.wahosy.gui.root.scene.SceneHelper;
import de.kongsugar.wahosy.model.to.Box;

/**
 * Created by Niko on 06.10.2015.
 */
public class BoxViewController implements Initializable {
    SceneBuilder sb = new SceneBuilder(null);
	@FXML
	private TreeTableView<Box> tableView;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
		Platform.runLater(() -> {

		});

    }

    public void newBox() throws IOException {
        sb.showDialog(SceneHelper.DIALOG_NEW_BOX);
    }
}
