package com.cavus.shlist.view;

import com.cavus.shlist.model.IProduct;

public interface ProductFormListener {
	void onSave(IProduct product);
	void onDelete(IProduct product);
}
