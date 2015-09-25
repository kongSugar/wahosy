package de.kongsugar.wahosy.gui.splash;

import de.kongsugar.wahosy.gui.MainApp;
import javafx.concurrent.Task;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by nikog on 21.09.2015.
 */
public class SplashController implements Initializable {
    @FXML
    private Label countdown;
    private MainApp application;
    @FXML
    private ProgressBar progBar;

    private void startCountdown() {
        Task<Long> task = new Task<Long>() {
            @Override
            protected Long call() throws Exception {
                long iterations;
                for (iterations = 0; iterations <= 100; iterations++) {
                    if (isCancelled()) {
                        break;
                    }

                    Thread.sleep(50);
                    updateMessage("" + iterations);
                    updateProgress(iterations, 100);
                }
                return iterations;
            }
        };

        //application.gotoRoot();
        countdown.textProperty().bind(task.messageProperty());
        progBar.progressProperty().bind(task.progressProperty());
        progBar.progressProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue.intValue() == 1) {
                task.cancel();
                application.gotoRoot();
            }
        });

        Thread th = new Thread(task);
        th.setDaemon(true);
        th.start();
    }

    public void setApp(MainApp mainApp) {
        this.application = mainApp;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        startCountdown();
    }
}
