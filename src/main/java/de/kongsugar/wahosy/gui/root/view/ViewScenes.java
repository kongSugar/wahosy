package de.kongsugar.wahosy.gui.root.view;

public enum ViewScenes {
    BoxView(""),
    ItemView("");

    private String url;

    ViewScenes(String s){
        this.url = s;
    }

    public String getUrl() {
        return url;
    }
}
