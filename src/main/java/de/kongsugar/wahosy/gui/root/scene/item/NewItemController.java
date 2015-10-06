package de.kongsugar.wahosy.gui.root.scene.item;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import org.controlsfx.control.textfield.TextFields;

import java.net.URL;
import java.util.ArrayList;
import java.util.Collection;
import java.util.ResourceBundle;

/**
 * Created by Niko on 04.10.2015.
 */
public class NewItemController implements Initializable {
    @FXML
    TextField manufacturer = new TextField();

    @FXML
    Button cancel;

    public void cancelAction() {
        Stage s = (Stage) cancel.getScene().getWindow();
        s.close();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        Collection<String> comp = new ArrayList<>();
        comp.add("niko");
        comp.add("nein");
        comp.add("nikolaus");
        comp.add("nikola");
        comp.add("niko laus");
        TextFields.bindAutoCompletion(manufacturer, comp);
    }
}
