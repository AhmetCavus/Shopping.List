package com.cavus.shlist.view;

import java.util.List;

import org.springframework.stereotype.Component;

import com.cavus.shlist.model.IProduct;
import com.cavus.shlist.model.ProductService;
import com.vaadin.data.Binder;
import com.vaadin.ui.Button;

@Component
public class ProductViewImpl extends ProductViewDesign implements ProductView {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private ProductViewListener listener;
	
	@Override
	public void setListener(ProductViewListener listener) {
		if(listener == null) return;
		this.listener = listener;
		grid.asSingleSelect().addValueChangeListener(listener::onProductSelect);
		search.addValueChangeListener(listener::onSearchProduct);
		clear.addClickListener(listener::onClearSearch);
		add.addClickListener(listener::onShowForm);
	}

	@Override
	public void updateList(List<IProduct> products) {
		grid.setItems(products);
	}

	@Override
	public void setColumns(String... columns) {
		grid.setColumns(columns);
	}

	@Override
	public void clearSearch() {
		search.clear();
	}
	
	@Override
	public void clearSelection() {
		grid.asSingleSelect().clear();
	}

}
