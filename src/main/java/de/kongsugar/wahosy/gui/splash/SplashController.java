package de.kongsugar.wahosy.gui.splash;

import de.kongsugar.wahosy.gui.MainApp;
import javafx.concurrent.Task;
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

    public void startCountdown() {

        Task<Long> task = new Task<Long>() {
            @Override
            protected Long call() throws Exception {
                long iterations;
                for (iterations = 0; iterations < 1000000000; iterations++) {
                    if (isCancelled()) {
                        break;
                    }

                    Thread.sleep(1);
                    updateMessage("" + iterations);
                }
                return iterations;
            }
        };

        countdown.textProperty().bind(task.messageProperty());

        Thread th = new Thread(task);
        th.setDaemon(true);
        th.start();
    }

    public void setApp(MainApp mainApp) {
        this.application = application;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}
