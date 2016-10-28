/*
 * @(#)Supermarket 1.0 14 de out de 2016
 *
 *Copyright (c) 2016, hyperCLASS. All rights reserved. hyperCLASS
 *proprietary/confidential. Use is subject to license terms.
 *
 */
package br.com.hyperclass.supermarket.restapi.wrapper;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import br.com.hyperclass.supermarket.domain.product.Product;
import br.com.hyperclass.supermarket.restapi.deserializers.ProductDeserializer;
import br.com.hyperclass.supermarket.restapi.serializers.ProductSerializer;

/**
 * A classe <code>ProductWrapper</code> é responsavel por contruir um modelo
 *de serialização e deserialização de objeto Json relacionado a um determinado produto.
 * 
 * @author Guilherme Faria
 *
 * @version 1.0.0 14/10/2016
 */
@JsonDeserialize(using = ProductDeserializer.class)
@JsonSerialize(using = ProductSerializer.class)
public class ProductWrapper {
	private final Product product;
	private final int quantity;
	
	public ProductWrapper(final Product product, final int quantity) {
		this.product = product;
		this.quantity = quantity;
	}
	
	public Product product() {
		return product;
	}
	
	public int quantity() {
		return quantity;
	}
}