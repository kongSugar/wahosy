package de.kongsugar.wahosy.gui.root.scene.store;

import de.kongsugar.wahosy.gui.MainApp;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.fxml.JavaFXBuilderFactory;
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

    public void setApplication(MainApp application) {
        this.application = application;
    }

    private void showDialog(String dialog) throws IOException {
        URL url = getClass().getResource(dialog);
        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(url);
        fxmlLoader.setBuilderFactory(new JavaFXBuilderFactory());
        AnchorPane node = fxmlLoader.load(url.openStream());

        DialogPane dp = new DialogPane();
        dp.setContent(node);
        Dialog d = new Dialog();
        d.setDialogPane(dp);
        d.show();
    }

    public void showInsertDialog() {
        try {
            showDialog(Dialoges.NEW_ITEM);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}

final class Dialoges {
    static final String NEW_ITEM = "NewItemLayout.fxml";

    private Dialoges() {
    }
}

