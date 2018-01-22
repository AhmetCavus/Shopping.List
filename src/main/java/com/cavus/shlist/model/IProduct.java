package com.cavus.shlist.model;

public interface IProduct extends Cloneable{
	
	Long getId();
	void setId(Long id);
	
	String getName();
	void setName(String name);
	
	String getDescription();
	void setDescription(String name);
	
	double getQuantity();
	void setQuantity(double value);
	
	public IProduct clone() throws CloneNotSupportedException;
	
	boolean isPersisted();
	
	default void printContent() {
		System.out.println(String.format("%s:%s:%d", getId(), getName(), getQuantity()));
	}
	
}
