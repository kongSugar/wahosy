package de.kongsugar.wahosy.gui.splash;

import de.kongsugar.wahosy.gui.MainApp;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by nikog on 21.09.2015.
 */
public class SplashController implements Initializable {
    @FXML
    private Label countdown;
    private MainApp application;

    public Label getCountdown() {
        return countdown;
    }

    public void setCountdown(Label countdown) {
        this.countdown = countdown;
    }

    public void setLabel(String s) {
        countdown.setText(s);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    public void setApp(MainApp mainApp) {
        this.application = application;
    }
}
