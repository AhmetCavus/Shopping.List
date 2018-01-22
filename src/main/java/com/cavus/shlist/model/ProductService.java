package com.cavus.shlist.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * This is a in memory dummy "database" for the working example. 
 * Consider using a database for production mode.
 */
public class ProductService {

	private static volatile ProductService instance;
	private static Object mutex = new Object();
	private static final Logger LOGGER = Logger.getLogger(ProductService.class.getName());

	private long nextId = 0;
	private final HashMap<Long, IProduct> products = new HashMap<>();

	private ProductService() {
	}


	public static ProductService getInstance() {
		ProductService result = instance;
		if (result == null) {
			synchronized (mutex) {
				result = instance;
				if(result == null) {
					instance = result = new ProductService();
					instance.generateData();
				}
			}
		}
		return result;
	}

	/**
	 * @return all available products.
	 */
	public synchronized List<IProduct> findAll() {
		return findAll(null);
	}

	/**
	 * Finds all the products that match given filter.
	 *
	 * @param stringFilter
	 *            filter that returned objects should match or null/empty string
	 *            if all objects should be returned.
	 * @return get all products
	 */
	public List<IProduct> findAll(String stringFilter) {
		ArrayList<IProduct> arrayList = new ArrayList<>();
		for (IProduct product : products.values()) {
			try {
				boolean passesFilter = (stringFilter == null || stringFilter.isEmpty())
						|| product.toString().toLowerCase().contains(stringFilter.toLowerCase());
				if (passesFilter) {
					IProduct clone = product.clone();
					arrayList.add(clone);
				}
			} catch (CloneNotSupportedException ex) {
				Logger.getLogger(ProductService.class.getName()).log(Level.SEVERE, null, ex);
			}
		}
		Collections.sort(arrayList, (o1, o2) -> (int)(o2.getId() - o1.getId()));
		return arrayList;
	}

	/**
	 * Finds all products that match given filter and limits the resultset.
	 *
	 * @param stringFilter
	 *            filter that returned objects should match or null/empty string
	 *            if all objects should be returned.
	 * @param start
	 *            the index of first result
	 * @param maxresults
	 *            maximum result count
	 * @return get all products
	 */
	public synchronized List<IProduct> findAll(String stringFilter, int start, int maxresults) {
		ArrayList<IProduct> arrayList = new ArrayList<>();
		for (IProduct product : products.values()) {
			try {
				boolean passesFilter = (stringFilter == null || stringFilter.isEmpty())
						|| product.toString().toLowerCase().contains(stringFilter.toLowerCase());
				if (passesFilter) {
					arrayList.add(product.clone());
				}
			} catch (CloneNotSupportedException ex) {
				Logger.getLogger(ProductService.class.getName()).log(Level.SEVERE, null, ex);
			}
		}
		Collections.sort(arrayList, (o1, o2) -> (int) (o2.getId() - o1.getId()));
		int end = start + maxresults;
		if (end > arrayList.size()) {
			end = arrayList.size();
		}
		return arrayList.subList(start, end);
	}

	/**
	 * @return the size of products
	 */
	public synchronized long count() {
		return products.size();
	}

	/**
	 * Remove a product from a system
	 *
	 */
	public synchronized void delete(IProduct product) {
		products.remove(product.getId());
	}

	/**
	 * Saves or updates products in the local storage. Also assigns an identifier
	 * for new product objects.
	 */
	public synchronized void save(IProduct product) {
		if (product == null) {
			LOGGER.log(Level.SEVERE,
					"Product is null");
			return;
		}
		if (product.getId() == null) {
			nextId += 1;
			product.setId(nextId);
		}
		try {
			product = (IProduct) product.clone();
		} catch (Exception ex) {
			throw new RuntimeException(ex);
		}
		products.put(product.getId(), product);
	}
	
	/**
	 * Creates an empty product for the product form
	 */
	public IProduct createNewProduct() {
		return new BaseProduct(null, "", "");
	}

	/**
	 * Test data
	 */
	public void generateData() {
		if (findAll().isEmpty()) {
			final IProduct [] products = new BaseProduct [] { 
				new BaseProduct(nextId++, "Schoko & Keks", "250g"),
				new BaseProduct(nextId++, "Gebaeckstangen", "550g"),
				new BaseProduct(nextId++, "Milch", "3,5% Fett"),
				new BaseProduct(nextId++, "Kaffeepads Caffe Crema", "100 Pads"),
				new BaseProduct(nextId++, "Langkorn Reis", "1.00 kg"),
				new BaseProduct(nextId++, "Tempo Taschentuecher", "3 x 80 Tuecher"),
				new BaseProduct(nextId++, "Pasta Nudeln", "1 kg")
			};
			for (IProduct product : products) {
				product.setQuantity(1);
				save(product);
			}
		}
	}

}
