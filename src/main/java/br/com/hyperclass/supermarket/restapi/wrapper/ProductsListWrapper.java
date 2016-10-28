/*
 * @(#)Supermarket 1.0 14 de out de 2016
 *
 *Copyright (c) 2016, hyperCLASS. All rights reserved. hyperCLASS
 *proprietary/confidential. Use is subject to license terms.
 *
 */
package br.com.hyperclass.supermarket.restapi.wrapper;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import br.com.hyperclass.supermarket.domain.product.Product;
import br.com.hyperclass.supermarket.restapi.serializers.ProductsListSerializer;

/**
 * A classe <code>ProductsListWrapper</code> é responsavel por contruir um modelo
 *de serialização de objeto Json passando uma lista de produtos.
 * 
 * @author Guilherme Faria
 *
 * @version 1.0 14/10/2016
 */

@JsonSerialize(using = ProductsListSerializer.class)
public class ProductsListWrapper {
	
	private final Map<Product, Integer> products = new TreeMap<>();
	private final List<Product> listReceived;
	
	public ProductsListWrapper(final List<Product> listReceived) {
		this.listReceived = listReceived;
	}
	
	public Map<Product, Integer> products() {
		this.products.putAll(loadingMap(listReceived));
		return products;
	}
	
	public Map<Product, Integer> loadingMap(List<Product> list) {
		Map<Product, Integer> productsMap = new HashMap<Product, Integer>();
		for (Product product : list) {
			if(!productsMap.containsKey(product)) {
				productsMap.put(product, 1);
			} else {
				productsMap.put(product, productsMap.get(product)+1);
			}
		}
		return Collections.unmodifiableMap(productsMap);
	}

}
