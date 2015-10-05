package de.kongsugar.wahosy.gui.root.view;

import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.fxml.JavaFXBuilderFactory;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;
import java.net.URL;

/**
 * Created by Niko on 05.10.2015.
 */
public class ViewBuilder {
    public void main(String[] args) {
        this.buildView(null, ViewScenes.BoxView);
    }

    //TODO HELPER CLASS!!
    public static Initializable buildView(AnchorPane content,ViewScenes view) {
        try {
            URL url = ViewBuilder.class.getClassLoader().getResource(view.getUrl());
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(url);
            fxmlLoader.setBuilderFactory(new JavaFXBuilderFactory());
            AnchorPane node = fxmlLoader.load(url.openStream());
            content.getChildren().setAll(node);

            node.prefHeightProperty().bind(content.heightProperty());
            node.prefWidthProperty().bind(content.widthProperty());
            return (Initializable) fxmlLoader.getController();
        } catch (IOException e) {
            e.printStackTrace();
        } return null;
    }
}
