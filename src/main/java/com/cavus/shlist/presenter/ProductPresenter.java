package com.cavus.shlist.presenter;

import java.util.List;

import com.cavus.shlist.model.BaseProduct;
import com.cavus.shlist.model.IProduct;
import com.cavus.shlist.model.ProductService;
import com.cavus.shlist.view.ProductForm;
import com.cavus.shlist.view.ProductFormListener;
import com.cavus.shlist.view.ProductView;
import com.cavus.shlist.view.ProductViewListener;
import com.vaadin.data.HasValue.ValueChangeEvent;
import com.vaadin.ui.Button.ClickEvent;

public class ProductPresenter implements ProductViewListener, ProductFormListener{

	private ProductForm productForm;
	private ProductView productView;
	private ProductService service = ProductService.getInstance();
	
	public ProductPresenter(ProductView productView, ProductForm productForm) {
		this.productView = productView;
		this.productForm = productForm;
		
		productView.setListener(this);
		productForm.setListener(this);
		
		productForm.setVisible(false);
		
		productView.updateList(service.findAll());
		productView.setColumns("name", "description", "quantity");
	}

	@Override
	public void onSave(IProduct product) {
		service.save(product);
		productForm.clear();
		productForm.setVisible(false);
		productView.updateList(service.findAll());
	}

	@Override
	public void onDelete(IProduct product) {
		service.delete(product);
		productForm.clear();
		productForm.setVisible(false);
		productView.updateList(service.findAll());
	}

	@Override
	public void onProductSelect(ValueChangeEvent<IProduct> e) {
	    if (e.getValue() == null) {
	        productForm.setVisible(false);
	    } else {
	        productForm.setProduct(e.getValue());
	    }
	}

	@Override
	public void onSearchProduct(ValueChangeEvent<String> e) {
		List<IProduct> products = service.findAll(e.getValue());
		productView.updateList(products);
	}

	@Override
	public void onShowForm(ClickEvent e) {
	    productView.clearSelection();
	    productForm.setProduct(new BaseProduct(-1, "", ""));
	    productForm.setVisible(true);
	}

	@Override
	public void onClearSearch(ClickEvent e) {
		productView.clearSearch();
	}
}
