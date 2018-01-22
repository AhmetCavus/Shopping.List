package com.cavus.shlist.view;

import java.util.List;

import com.cavus.shlist.model.IProduct;

/**
 * This interface is an abstraction between the presenter and the view
 * @author Ahmet Cavus
 *
 */
public interface ProductView {
	
	/**
	 * Refresh the product grid data
	 * @param products is the data to be shown in the grid
	 */
	public void updateList(List<IProduct> products);
	
	/**
	 * Define the columns to be bind to the product properties
	 * @param columns is the definition of the properties in the bean
	 */
	public void setColumns(String... columns);
	
	/**
	 * Resets the typed text in the search bar
	 */
	public void clearSearch();
	
	/**
	 * Cancels the selection in the product grid
	 */
	public void clearSelection();
	
	/**
	 * The registration method to loosely wire the presenters.
	 * TODO: Consider using event busses
	 */
	public void setListener(ProductViewListener listener);
}
