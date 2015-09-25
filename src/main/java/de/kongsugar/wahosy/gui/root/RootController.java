package de.kongsugar.wahosy.gui.root;

import de.kongsugar.wahosy.gui.MainApp;
import javafx.fxml.Initializable;
import javafx.scene.Node;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by nikog on 25.09.2015.
 */
public class RootController implements Initializable {
    private MainApp application;
    private Node content;

    public void setApp(MainApp mainApp) {
        this.application = mainApp;
    }

    private void setContent(Node content) {
        this.content = content;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}
