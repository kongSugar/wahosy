package de.kongsugar.wahosy.gui.root;

import de.kongsugar.wahosy.gui.MainApp;
import javafx.scene.Node;

/**
 * Created by nikog on 25.09.2015.
 */
public class RootController {
    private MainApp application;
    private Node content;

    public void setApp(MainApp mainApp) {
        this.application = application;
    }

    private void setContent(Node content) {
        this.content = content;
    }
}
