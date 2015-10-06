package de.kongsugar.wahosy.gui.root.scene;

import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.fxml.JavaFXBuilderFactory;
import javafx.scene.control.Dialog;
import javafx.scene.control.DialogPane;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;
import java.net.URL;

/**
 * Created by Niko on 06.10.2015.
 */
public class SceneBuilder {
    private AnchorPane content;

    public SceneBuilder(AnchorPane content) {
        this.content = content;
    }

    public Initializable build(SceneHelper scene) {
        try {
            URL url = getClass().getResource(scene.getFxml());
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

    public Dialog showDialog(SceneHelper dialog) throws IOException {
        URL url = getClass().getResource(dialog.getFxml());
        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(url);
        fxmlLoader.setBuilderFactory(new JavaFXBuilderFactory());
        AnchorPane node = fxmlLoader.load(url.openStream());

        DialogPane dp = new DialogPane();
        dp.setContent(node);
        Dialog d = new Dialog();
        d.setDialogPane(dp);
        d.show();
        return d;
    }


}
