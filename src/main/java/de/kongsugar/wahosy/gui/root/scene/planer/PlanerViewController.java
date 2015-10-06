package de.kongsugar.wahosy.gui.root.scene.planer;

import de.kongsugar.wahosy.gui.root.scene.SceneBuilder;
import de.kongsugar.wahosy.gui.root.scene.SceneHelper;
import javafx.fxml.Initializable;
import javafx.scene.control.ButtonType;
import org.controlsfx.dialog.Wizard;
import org.controlsfx.dialog.WizardPane;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by Niko on 06.10.2015.
 */
public class PlanerViewController  implements Initializable{
    SceneBuilder sb = new SceneBuilder(null);

    public void loadCreateNewOrderScene() throws IOException {
        Wizard wizard = new Wizard();
        WizardPane p1 = new WizardPane();
        WizardPane p2 = new WizardPane();
        WizardPane p3 = new WizardPane();
        p1.setContent(sb.getNode(SceneHelper.PLANER_CREATE_1_CONTACT));
        p2.setContent(sb.getNode(SceneHelper.PLANER_CREATE_2_LIST));
        p3.setContent(sb.getNode(SceneHelper.PLANER_CREATE_3_CONFIRMATION));
        wizard.setFlow(new Wizard.LinearFlow(p1, p2, p3));
        wizard.setTitle("New Order");
        wizard.showAndWait().ifPresent(result -> {
            if (result == ButtonType.FINISH) {
                System.out.println("Könnte nun speichern! " + wizard.getSettings());
            }
        });
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}
