package de.kongsugar.calendar;/**
 * Created by Niko on 07.10.2015.
 */

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Control;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class Sample extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        AnchorPane pane = new AnchorPane();
        Control c = new Button("Btn");
        pane.getChildren().add(c);
        primaryStage.setScene(new Scene(pane));
        primaryStage.setTitle("Calendar");
        primaryStage.show();


    }
}
