/*
 * @(#)Supermarket 1.0 11 de out de 2016
 *
 *Copyright (c) 2016, hyperCLASS. All rights reserved. hyperCLASS
 *proprietary/confidential. Use is subject to license terms.
 *
 */
package br.com.hyperclass.supermarket.domain.stock;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import br.com.hyperclass.supermarket.domain.product.Product;

/**
 * 
 * A classe <code>Stock</code> é responsavel pelo gerenciamento 
 * dos produtos disponiveis na aplicação.
 * 
 * @author Guilherme Faria
 *
 * @version 1.0.0 11/10/2016
 */

public class Stock {

	private final List<Product> productsInStock = new ArrayList<>();
	
	/**
	 * 
	 * @param product
	 * @param quantity
	 */
	public void addProductInStock(final Product product, final int quantity) {
		productsInStock.addAll(loadingProductInList(product, quantity));
	}

	public void removeProductOfStock(final Product product, final int quantity) throws SupermarketException {
		int cont = 0;
		if (productsInStock.contains(product)) {
			for (int contList = 0; contList <= productsInStock.size(); contList++) {
				if (cont <= quantity) {
					if ((productsInStock.get(contList).compareTo(product)) == 0) {
						productsInStock.remove(cont);
						cont++;
					}
				}
			}
		} else {
			throw new ProductNotFoundException();
		}
	}

	public Boolean containsProduct(final Product product, final int quantity) throws SupermarketException {
		int cont = 0;
		for (Product productEntry : productsInStock) {
			if (productEntry.equals(product)) {
				cont++;
			}
		}
		if (cont >= quantity) {
			return true;
		} else {
			throw new ProductUnavailableException();
		}

	}

	public List<Product> showProductsOfStock() {
		return Collections.unmodifiableList(productsInStock);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((productsInStock == null) ? 0 : productsInStock.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Stock other = (Stock) obj;
		if (productsInStock == null) {
			if (other.productsInStock != null)
				return false;
		} else if (!productsInStock.equals(other.productsInStock))
			return false;
		return true;
	}

	private List<Product> loadingProductInList(final Product product, final int quantity) {
		final List<Product> productsList = new ArrayList<Product>(quantity);
		for (int cont = 0; cont < quantity; cont++) {
			productsList.add(new Product(product.barCode(), product.nameProduct(), product.value(),
					product.productInformation()));
		}
		return productsList;
	}
}