package de.kongsugar.wahosy.gui.root.scene;

import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.fxml.JavaFXBuilderFactory;
import javafx.scene.Node;
import javafx.scene.control.Dialog;
import javafx.scene.control.DialogPane;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;
import java.net.URL;

/**
 * SceneBuilder avoids duplicate code by providing a method for loading/switching scenes in
 * an AnchorPane.
 */
public class SceneBuilder {
    private AnchorPane content;

    /**
     * @param content AnchorPane of the owner-Class where the scenes shall be loaded into.
     */
    public SceneBuilder(AnchorPane content) {
        this.content = content;
    }

    /**
     * Loads a scene into the content-pane. Scenes are defined in SceneHelper.
     *
     * @param scene Scene that shall be loaded
     * @return
     */
    public Initializable build(SceneHelper scene) {
        try {
            URL url = getClass().getResource(scene.getFxml());
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(url);
            fxmlLoader.setBuilderFactory(new JavaFXBuilderFactory());
            AnchorPane node = fxmlLoader.load(url.openStream());

            if (content != null) {
                content.getChildren().setAll(node);
                node.prefHeightProperty().bind(content.heightProperty());
                node.prefWidthProperty().bind(content.widthProperty());
            }

            return (Initializable) fxmlLoader.getController();
        } catch (IOException e) {
            e.printStackTrace();
        } return null;
    }

    /**
     * Creates a Node of a scene. This is used to build wizards with Wizard of the controlsFX-Lib
     *
     * @param scene Scene the Node shall be created of
     * @return Node of the Scene
     */
    public Node getNode(SceneHelper scene) {
        URL url = getClass().getResource(scene.getFxml());
        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(url);
        fxmlLoader.setBuilderFactory(new JavaFXBuilderFactory());
        AnchorPane node = null;
        try {
            node = fxmlLoader.load(url.openStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return node;
    }


    /**
     * Creates a Dialog based on the scene passed as parameter.
     * @param dialog - Scene the Dialog shall be contain
     * @return created Dialog
     * @throws IOException
     */
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
