package com.cavus.shlist.model;

/**
 * A entity object. In a typical production environment
 * this could be a JPA entity.
 */
public class BaseProduct extends AbstractProduct {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public BaseProduct(Long id, String name, String desc) {
		setId(id);
		setName(name);
		setDescription(desc);
	}
	
}