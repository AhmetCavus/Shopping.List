package com.cavus.shlist.model;

import java.io.Serializable;

public abstract class AbstractProduct implements IProduct, Serializable, Cloneable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	protected Long id;
	protected String name;
	protected String desc;
	protected double quantity = 1.0;

	
	@Override
	public Long getId() {
		return id;
	}

	@Override
	public void setId(Long id) {
		this.id = id;
	}
	
	@Override
	public String getName() {
		return name;
	}

	@Override
	public void setName(String name) {
		this.name = name;
	}
	
	@Override
	public String getDescription() {
		return desc;
	}

	@Override
	public void setDescription(String desc) {
		this.desc = desc;
	}

	@Override
	public double getQuantity() {
		return quantity;
	}

	@Override
	public void setQuantity(double value) {
		if(value < 0.0) {
			throw new RuntimeException("");
		} else {
			quantity = value;
		}
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (obj instanceof IProduct && obj.getClass().equals(getClass())) {
			return this.id == ((IProduct) obj).getId();
		}

		return false;
	}

	@Override
	public IProduct clone() throws CloneNotSupportedException {
		return (IProduct) super.clone();
	}
	
	@Override
	public boolean isPersisted() {
		return id != null;
	}
	
	@Override
	public String toString() {
		return String.format("%s:%s:%s:%.2f", getId(), getName(), getDescription(), getQuantity());
	}
	
}
