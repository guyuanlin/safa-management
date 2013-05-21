package safa.controller;

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

public class SafaManagementController implements Initializable {
	
	@FXML private TabPane tabPane;
	@FXML private Tab productsTab;
	@FXML private Tab customsTab;
	@FXML private Button addButton;
	
	@FXML private TableView<ObservableProduct> productsTableView;
	@FXML private TableColumn<ObservableProduct, String> productIDCol;
	@FXML private TableColumn<ObservableProduct, String> productNameCol;
	@FXML private TableColumn<ObservableProduct, String> productNumberCol;
	@FXML private TableColumn<ObservableProduct, String> productStoreCol;
	@FXML private TableColumn<ObservableProduct, String> productColorCol;
	@FXML private TableColumn<ObservableProduct, Integer> colPrice;
	@FXML private TableColumn<ObservableProduct, Integer> colProductTotalCount;
	@FXML private TableColumn<ObservableProduct, Integer> colTotalPrice;
	
	@FXML private Button saveProductButton;
	@FXML private Button deleteProductButton;
	
	private Logger logger = Logger.getLogger(getClass());
	private ObservableList<ObservableProduct> productList = FXCollections.observableArrayList();

	public void initialize(URL arg0, ResourceBundle arg1) {
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
	
	private void initTable() {
		colProductID.setCellValueFactory(new PropertyValueFactory<ObservableProduct, String>("id"));
		colProductName.setCellValueFactory(new PropertyValueFactory<ObservableProduct, String>("name"));
		colProductNumber.setCellValueFactory(new PropertyValueFactory<ObservableProduct, String>("productNumber"));
		colPrice.setCellValueFactory(new PropertyValueFactory<ObservableProduct, Integer>("price"));
		colProductTotalCount.setCellValueFactory(new PropertyValueFactory<ObservableProduct, Integer>("count"));
		colTotalPrice.setCellValueFactory(new PropertyValueFactory<ObservableProduct, Integer>("totalPrice"));
		
		productsTableView.setItems(productList);
	}
}
