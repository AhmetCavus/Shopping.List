package com.cavus.shlist.view;

import com.cavus.shlist.model.IProduct;
import com.vaadin.data.HasValue.ValueChangeEvent;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;

public interface ProductViewListener {
	void onProductSelect(ValueChangeEvent<IProduct> e);
	void onSearchProduct(ValueChangeEvent<String> e);
	void onClearSearch(ClickEvent e);
	void onShowForm(ClickEvent e);
}
