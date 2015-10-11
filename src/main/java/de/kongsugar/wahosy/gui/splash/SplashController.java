package de.kongsugar.wahosy.gui.splash;

import de.kongsugar.wahosy.gui.MainApp;
import javafx.concurrent.Task;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by nikog on 21.09.2015.
 */
public class SplashController implements Initializable {
    @FXML
    private Label countdown;
    @FXML
    private ImageView logo;
    @FXML
    private ProgressBar progBar;

    private MainApp application;

    private void startCountdown() {
        Task<Long> task = new Task<Long>() {
            @Override
            protected Long call() throws Exception {
                long time = 2;
                for (long i = 0; i <= time; i++) {
                    if (isCancelled()) {
                        break;
                    }
                    updateMessage("" + i);
                    updateProgress(i, time);
                    Thread.sleep(1000);

                }
                return time;
            }
        };
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
        logo.setImage(new Image(this.getClass().getClassLoader().getResourceAsStream("Images/test.jpg")));

    }
}
