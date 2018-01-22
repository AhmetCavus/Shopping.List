package com.cavus.shlist.model;

/**
 * A entity object, like in any other Java application. In a typical real world
 * application this could for example be a JPA entity.
 */
@SuppressWarnings("serial")
public class BaseProduct extends AbstractProduct {

	public BaseProduct(long id, String name, String desc) {
		setId(id);
		setName(name);
		setDescription(desc);
	}
	
}