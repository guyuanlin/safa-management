package safa.model;

import javafx.beans.value.ObservableValue;

public interface ObservableProduct {
	public ObservableValue<String> idProperty();
    public ObservableValue<String> nameProperty();
    public ObservableValue<String> productNumberProperty();
    public ObservableValue<String> storeProperty();
    public ObservableValue<Integer> countProperty();
    public ObservableValue<String> colorProperty();
    public ObservableValue<String> sizeProperty();
}
