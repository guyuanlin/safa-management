package safa.controller;

import static com.google.common.base.Preconditions.checkNotNull;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
import safa.model.Product;
import safa.model.Store;

public class ObservableProductStub implements ObservableProduct {
	private Product _product;
	private DateFormat dateFormat;
	
	private final SimpleStringProperty id;
	private final SimpleStringProperty size;
	private final SimpleStringProperty color;
	private final SimpleStringProperty name;
	private final SimpleObjectProperty<Store> store;
	private final SimpleStringProperty productNumber;
	private final SimpleIntegerProperty price;
	private final SimpleIntegerProperty count;
	private final SimpleIntegerProperty totalPrice;
	private final SimpleStringProperty updateTime;
	private final SimpleStringProperty createTime;
	
	public ObservableProductStub(Product product) {
		checkNotNull(product, "Cannot create ObservableProductStub from null product.");
		_product = product;
		dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		
		id = new SimpleStringProperty(_product.getID());
		size = new SimpleStringProperty(_product.getSize());
		color = new SimpleStringProperty(_product.getColor());
		name = new SimpleStringProperty(_product.getName());
		store = new SimpleObjectProperty<Store>(_product.getStore());
		productNumber = new SimpleStringProperty(_product.getProductNumber());
		price = new SimpleIntegerProperty(_product.getPrice());
		count = new SimpleIntegerProperty(_product.getCount());
		totalPrice = new SimpleIntegerProperty(_product.getTotalPrice());
		updateTime = new SimpleStringProperty(dateFormat.format(_product.getUpdateTime()));
		createTime = new SimpleStringProperty(dateFormat.format(_product.getCreateTime()));
	}
	public ObservableValue<String> idProperty() {
		return id;
	}
	public ObservableValue<String> colorProperty() {
		return color;
	}
	public ObservableValue<String> sizeProperty() {
		return size;
	}
	public ObservableValue<String> nameProperty() {
		return name;
	}
	public ObservableValue<Store> storeProperty() {
		return store;
	}
	public ObservableValue<String> productNumberProperty() {
		return productNumber;
	}
	public ObservableValue<Number> priceProperty() {
		return price;
	}
	public ObservableValue<Number> countProperty() {
		return count;
	}
	public ObservableValue<String> createTimeProperty() {
		return createTime;
	}
	
	public ObservableValue<String> updateTimeProperty() {
		return updateTime;
	}
	public ObservableValue<Number> totalPriceProperty() {
		return totalPrice;
	}
}
