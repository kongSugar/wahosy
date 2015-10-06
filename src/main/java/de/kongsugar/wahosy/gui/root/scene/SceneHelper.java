package de.kongsugar.wahosy.gui.root.scene;

/**
 * Created by Niko on 06.10.2015.
 */
public enum SceneHelper {
    BOX_VIEW("box/BoxViewLayout.fxml"),
    DASHBOARD("dashboard/StartpageLayout.fxml"),
    ITEM_VIEW("item/ItemViewLayout.fxml"),
    SETTINGS("setting/SettingsLayout.fxml"),
    STORE_VIEW("store/OverviewLayout.fxml"),
    DIALOG_NEW_ITEM("item/NewItemLayout.fxml"),
    DIALOG_NEW_BOX("box/NewBoxLayout.fxml"),
    PLANER_VIEW("planer/PlanerViewLayout.fxml"),
    PLANER_CREATE_1_CONTACT("planer/PlanerCreate_1_Contact_Layout.fxml"),
    PLANER_CREATE_2_LIST("planer/PlanerCreate_2_List_Layout.fxml"),
    PLANER_CREATE_3_CONFIRMATION("planer/PlanerCreate_3_Confirmation_Layout.fxml")
    ;

    public String getFxml() {
        return fxml;
    }

    private String fxml;
    SceneHelper(String s) {
        this.fxml = s;
    }
}
