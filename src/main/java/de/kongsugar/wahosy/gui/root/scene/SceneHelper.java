package de.kongsugar.wahosy.gui.root.scene;

/**
 * Created by Niko on 06.10.2015.
 */
public enum SceneHelper {
    BOX_VIEW("box/BoxViewLayout.fxml"),
    BOX_CREATE("box/NewBoxLayout.fxml"),
    DASHBOARD("dashboard/StartpageLayout.fxml"),
    ITEM_VIEW("item/ItemViewLayout.fxml"),
    ITEM_CREATE("item/NewItemLayout.fxml"),
    SETTINGS("setting/SettingsLayout.fxml"),
    STORE_VIEW("store/OverviewLayout.fxml"),
    DIALOG_NEW_ITEM("item/NewItemLayout.fxml"),
    DIALOG_NEW_BOX("box/NewBoxLayout.fxml"),
    ;

    public String getFxml() {
        return fxml;
    }

    private String fxml;
    SceneHelper(String s) {
        this.fxml = s;
    }
}
