package de.kongsugar.wahosy.gui.root.scene.item;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

import de.kongsugar.wahosy.gui.root.scene.SceneBuilder;
import de.kongsugar.wahosy.gui.root.scene.SceneHelper;
import de.kongsugar.wahosy.model.dao.ItemDAO;
import de.kongsugar.wahosy.model.dao.batis.DbItem;
import de.kongsugar.wahosy.model.fx.FXItem;

/**
 * Created by Niko on 06.10.2015.
 */
public class ItemViewController implements Initializable{
	@FXML
	TableColumn<FXItem, String> noteColumn;
	@FXML
	TableColumn<FXItem, String> nameColumn;
	@FXML
	TableColumn<FXItem, String> manufacturerColumn;
	@FXML
	TableColumn<FXItem, Integer> weightColumn;
    SceneBuilder sb = new SceneBuilder(null);
	@FXML
	private TableView<FXItem> tableView;
	@FXML
	private TableColumn<FXItem, String> itemIdColumn;

    public void addItem() throws IOException {
        sb.showDialog(SceneHelper.DIALOG_NEW_ITEM);
    }

    public void removeItem(){};

    @Override
    public void initialize(URL location, ResourceBundle resources) {
		Platform.runLater(() -> {
			ObservableList<FXItem> items = FXCollections.observableArrayList();
			ItemDAO dao = new DbItem();
			dao.getAll().stream().forEach(item -> items.add(new FXItem(item)));

			itemIdColumn.setCellValueFactory(d -> d.getValue().storeIDProperty());
			noteColumn.setCellValueFactory(d -> d.getValue().noteProperty());
			nameColumn.setCellValueFactory(d -> d.getValue().nameProperty());
			manufacturerColumn.setCellValueFactory(d -> d.getValue().manufacturerProperty());
			weightColumn.setCellValueFactory(d -> d.getValue().weightProperty().asObject());

			tableView.setItems(items);
		});
    }
}
