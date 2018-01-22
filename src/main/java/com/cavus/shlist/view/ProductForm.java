package com.cavus.shlist.view;

import com.cavus.shlist.model.IProduct;

public interface ProductForm {
	
	public void clear();
	public void setVisible(boolean isVisible);
	public void setProduct(IProduct product);
	public void setListener(ProductFormListener listener);
	
}
