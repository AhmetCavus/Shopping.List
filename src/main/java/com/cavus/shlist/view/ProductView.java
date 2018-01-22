package com.cavus.shlist.view;

import java.util.List;

import com.cavus.shlist.model.IProduct;

public interface ProductView {
	
	public void setListener(ProductViewListener listener);
	
	public void updateList(List<IProduct> products);
	
	public void setColumns(String... columns);
	
	public void clearSearch();
	
	public void clearSelection();
	
}
