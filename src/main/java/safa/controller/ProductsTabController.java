package safa.controller;

import static com.google.common.base.Preconditions.checkNotNull;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import org.apache.log4j.Logger;

public class ProductsTabController {
	
	@FXML private TableView<ObservableProduct> productsTableView;
	
	@FXML private TableColumn<ObservableProduct, String> colProductID;
	@FXML private TableColumn<ObservableProduct, String> colProductName;
	@FXML private TableColumn<ObservableProduct, String> colProductNumber;
	@FXML private TableColumn<ObservableProduct, Integer> colPrice;
	@FXML private TableColumn<ObservableProduct, Integer> colProductTotalCount;
	@FXML private TableColumn<ObservableProduct, Integer> colTotalPrice;
	
	@FXML private Button saveProductButton;
	@FXML private Button deleteProductButton;
	
	private Logger logger = Logger.getLogger(getClass());
	
	private final ObservableList<ObservableProduct> tableContent = FXCollections.observableArrayList();
	
	ProductsTabController() {
		initButtons();
		initTable();
		
		logger.debug("Initialize ProductsTabController success.");
	}
	
	private void initButtons() {
		saveProductButton.setDisable(true);
		deleteProductButton.setDisable(true);
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
