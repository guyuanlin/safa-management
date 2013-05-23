package safa.controller;

import static com.google.common.base.Preconditions.checkNotNull;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import org.apache.log4j.Logger;

import safa.model.Store;

public class SafaManagementController implements Initializable {
	
	@FXML private TabPane tabPane;
	@FXML private Tab productsTab;
	@FXML private Tab customsTab;
	@FXML private Button addButton;
	
	@FXML private TableView<ObservableProduct> productsTableView;
	@FXML private TableColumn<ObservableProduct, String> productIDCol;
	@FXML private TableColumn<ObservableProduct, String> productNameCol;
	@FXML private TableColumn<ObservableProduct, String> productNumberCol;
	@FXML private TableColumn<ObservableProduct, Store> productStoreCol;
	@FXML private TableColumn<ObservableProduct, String> productColorCol;
	@FXML private TableColumn<ObservableProduct, String> productSizeCol;
	@FXML private TableColumn<ObservableProduct, Integer> productPriceCol;
	@FXML private TableColumn<ObservableProduct, Integer> productCountCol;
	@FXML private TableColumn<ObservableProduct, Integer> totalPriceCol;
	@FXML private TableColumn<ObservableProduct, String> updateTimeCol;
	@FXML private TableColumn<ObservableProduct, String> createTimeCol;
	
	@FXML private Button saveProductButton;
	@FXML private Button deleteProductButton;
	
	private Logger logger = Logger.getLogger(getClass());
	private ObservableList<ObservableProduct> productList = FXCollections.observableArrayList();

	public void initialize(URL arg0, ResourceBundle arg1) {
		checkComponentsInit();
		initTable();
		logger.debug("Initial TabPaneController success.");
	}
	
	public void addButtonFired(ActionEvent event) {
		if(productsTab.isSelected()) {
			// TODO
		} else if (customsTab.isSelected()) {
			// TODO 
		}
	}
	
	private void checkComponentsInit() {
		checkNotNull(tabPane, "tabPane does not inject.");
		checkNotNull(productsTab, "productsTab does not inject.");
		checkNotNull(customsTab, "customsTab does not inject.");
		checkNotNull(addButton, "addButton does not inject.");
		checkNotNull(productsTableView, "productsTableView does not inject.");
		checkNotNull(productIDCol, "productIDCol does not inject.");
		checkNotNull(productNameCol, "productNameCol does not inject.");
		checkNotNull(productNumberCol, "productNumberCol does not inject.");
		checkNotNull(productStoreCol, "productStoreCol does not inject.");
		checkNotNull(productColorCol, "productColorCol does not inject.");
		checkNotNull(productSizeCol, "productSizeCol does not inject.");
		checkNotNull(productPriceCol, "productPriceCol does not inject.");
		checkNotNull(productCountCol, "productCountCol does not inject.");
		checkNotNull(totalPriceCol, "totalPriceCol does not inject.");
		checkNotNull(updateTimeCol, "updateTimeCol does not inject.");
		checkNotNull(createTimeCol, "createTimeCol does not inject.");
		checkNotNull(saveProductButton, "saveProductButton does not inject.");
		checkNotNull(deleteProductButton, "deleteProductButton does not inject.");
	}
	
	private void initTable() {
		productIDCol.setCellValueFactory(new PropertyValueFactory<ObservableProduct, String>("id"));
		productNameCol.setCellValueFactory(new PropertyValueFactory<ObservableProduct, String>("name"));
		productNumberCol.setCellValueFactory(new PropertyValueFactory<ObservableProduct, String>("productNumber"));
		productStoreCol.setCellValueFactory(new PropertyValueFactory<ObservableProduct, Store>("store"));
		productColorCol.setCellValueFactory(new PropertyValueFactory<ObservableProduct, String>("color"));
		productSizeCol.setCellValueFactory(new PropertyValueFactory<ObservableProduct, String>("size"));
		productPriceCol.setCellValueFactory(new PropertyValueFactory<ObservableProduct, Integer>("price"));
		productCountCol.setCellValueFactory(new PropertyValueFactory<ObservableProduct, Integer>("count"));
		totalPriceCol.setCellValueFactory(new PropertyValueFactory<ObservableProduct, Integer>("totalPrice"));
		updateTimeCol.setCellValueFactory(new PropertyValueFactory<ObservableProduct, String>("updateTime"));
		createTimeCol.setCellValueFactory(new PropertyValueFactory<ObservableProduct, String>("createTime"));
		
		productsTableView.setItems(productList);
	}
}
