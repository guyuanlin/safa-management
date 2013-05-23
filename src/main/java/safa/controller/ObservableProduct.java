package safa.controller;

import javafx.beans.value.ObservableValue;
import safa.model.Store;

public interface ObservableProduct {
	public ObservableValue<String> idProperty();
    public ObservableValue<String> colorProperty();
    public ObservableValue<String> sizeProperty();
    public ObservableValue<String> nameProperty();
    public ObservableValue<Store> storeProperty();
    public ObservableValue<String> productNumberProperty();
    public ObservableValue<Number> priceProperty();
    public ObservableValue<Number> countProperty();
    public ObservableValue<Number> totalPriceProperty();
    public ObservableValue<String> createTimeProperty();
    public ObservableValue<String> updateTimeProperty();
}
