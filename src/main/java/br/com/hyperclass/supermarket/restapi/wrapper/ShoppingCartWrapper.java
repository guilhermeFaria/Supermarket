/*
 * @(#)Supermarket 1.0 25 de out de 2016
 *
 *Copyright (c) 2016, hyperCLASS. All rights reserved. hyperCLASS
 *proprietary/confidential. Use is subject to license terms.
 *
 */
package br.com.hyperclass.supermarket.restapi.wrapper;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import br.com.hyperclass.supermarket.domain.product.Product;
import br.com.hyperclass.supermarket.restapi.serializers.ShoppingCartSerializer;

/**
 * A classe <code>ShoppingCartWrapper</code> é responsavel por contruir um modelo
 *de serialização de objeto Json relacionada ao produtos e valor total do carrinho de compras.
 * 
 * @author Guilherme Faria
 *
 * @version 1.0.0 25 de out de 2016
 */
@JsonSerialize(using = ShoppingCartSerializer.class)
public class ShoppingCartWrapper {
	private final List<Product> products;
	private final BigDecimal purchasePrice;
	
	public ShoppingCartWrapper(final List<Product> products, final BigDecimal purchasePrice) {
		this.products = products;
		this.purchasePrice = purchasePrice;
	}
	
	public List<Product> products() {
		return products;
	}
	
	public BigDecimal purchasePrice() {
		return purchasePrice;
	}

}