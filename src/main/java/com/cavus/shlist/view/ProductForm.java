package com.cavus.shlist.view;

import com.cavus.shlist.model.IProduct;

/**
 * This interface is an abstraction between the presenter and the view
 * @author Ahmet Cavus
 *
 */
public interface ProductForm {
	
	/**
	 * Clear the fields
	 */
	public void clear();
	
	/**
	 * Control the visibility
	 */
	public void setVisible(boolean isVisible);
	
	/**
	 * Setting the current product shown in the form
	 */
	public void setProduct(IProduct product);
	
	/**
	 * The registration method to loosely wire the presenters.
	 * TODO: Consider using event busses
	 */
	public void setListener(ProductFormListener listener);
	
}
