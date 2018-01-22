package com.cavus.shlist.view;

import com.cavus.shlist.model.IProduct;
import com.vaadin.data.Binder;


public class ProductFormImpl extends ProductFormDesign implements ProductForm {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private ProductFormListener listener;
    private IProduct currentProduct;
    private Binder<IProduct> binder = new Binder<>(IProduct.class);

    public ProductFormImpl() {
        
        setSizeUndefined();

        binder.bindInstanceFields(this);
    }

    public void setProduct(IProduct product) {
        this.currentProduct = product;
        binder.setBean(product);

        // Show delete button for only customers already in the database
        remove.setVisible(product.isPersisted());
        setVisible(true);
        name.selectAll();
    }

	@Override
	public void setListener(ProductFormListener listener) {
		if(listener == null) return;
		this.listener = listener;
        save.addClickListener(e -> listener.onSave(currentProduct));
        remove.addClickListener(e -> listener.onDelete(currentProduct));
	}

	@Override
	public void clear() {
		// Clear inner state
	}

}
