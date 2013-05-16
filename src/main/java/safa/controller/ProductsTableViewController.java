package safa.controller;

import static com.google.common.base.Preconditions.checkNotNull;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class ProductsTableViewController implements Initializable {
	
	@FXML private TableView<ObservableProduct> productsTableView;
	
	@FXML private TableColumn<ObservableProduct, String> colProductID;
	@FXML private TableColumn<ObservableProduct, String> colProductName;
	@FXML private TableColumn<ObservableProduct, String> colProductNumber;
	@FXML private TableColumn<ObservableProduct, Integer> colPrice;
	@FXML private TableColumn<ObservableProduct, Integer> colProductTotalCount;
	@FXML private TableColumn<ObservableProduct, Integer> colTotalPrice;
	
	@FXML private Button btnAddProduct;
	@FXML private Button btnDeleteProduct;
	
	private final ObservableList<ObservableProduct> tableContent = FXCollections.observableArrayList();
	
	public void initialize(URL arg0, ResourceBundle arg1) {
		checkNotNull(btnAddProduct, "btnAddProduct was not injected!");
		
		initButtons();
		initTable();
	}
	
	private void initButtons() {
		btnAddProduct.setDisable(true);
		btnDeleteProduct.setDisable(true);
	}
	
	private void initTable() {
		colProductID.setCellValueFactory(new PropertyValueFactory<ObservableProduct, String>("id"));
		colProductName.setCellValueFactory(new PropertyValueFactory<ObservableProduct, String>("name"));
		colProductNumber.setCellValueFactory(new PropertyValueFactory<ObservableProduct, String>("productNumber"));
		colPrice.setCellValueFactory(new PropertyValueFactory<ObservableProduct, Integer>("price"));
		colProductTotalCount.setCellValueFactory(new PropertyValueFactory<ObservableProduct, Integer>("count"));
		colTotalPrice.setCellValueFactory(new PropertyValueFactory<ObservableProduct, Integer>("totalPrice"));
		
		productsTableView.setItems(tableContent);
	}
}
