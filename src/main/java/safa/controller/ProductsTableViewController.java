package safa.controller;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import safa.model.Product;

public class ProductsTableViewController implements Initializable {
	
	@FXML private TableView<Product> productsTableView;
	
	@FXML private TableColumn<Product, String> idCol;
	@FXML private TableColumn<Product, String> nameCol;
	@FXML private TableColumn<Product, String> productNumberCol;
	@FXML private TableColumn<Product, String> storeCol;
	@FXML private TableColumn<Product, Integer> countCol;
	@FXML private TableColumn<Product, String> colorCol;
	@FXML private TableColumn<Product, String> sizeCol;
	
	
	public void initialize(URL arg0, ResourceBundle arg1) {
		
	}
}
