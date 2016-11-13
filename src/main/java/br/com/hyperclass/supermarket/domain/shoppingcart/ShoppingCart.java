/*
 * @(#)Supermarket 1.0 11 de out de 2016
 *
 *Copyright (c) 2016, hyperCLASS. All rights reserved. hyperCLASS
 *proprietary/confidential. Use is subject to license terms.
 *
 */
package br.com.hyperclass.supermarket.domain.shoppingcart;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import br.com.hyperclass.supermarket.domain.product.Product;
import br.com.hyperclass.supermarket.domain.stock.Stock;
import br.com.hyperclass.supermarket.domain.stock.SupermarketException;

/**
 * A Classe <code>ShoppingCart</code> é responsavel por gerenciar
 * os produtos passado pelo usuario.
 * 
 * @author Guilherme Faria
 *
 * @version 1.0.0 11/10/2016
 */

public class ShoppingCart {

	private final List<Product> productsInCart; 
	private Stock stock;

	public ShoppingCart(final Stock stock) {
		this.stock = stock;
		productsInCart = new ArrayList<>();
	}
	
	/**
	 * Metodo que retorna o valor atual do carrinho de compra.
	 * 
	 * @return 
	 */
	public final BigDecimal currentPurchasePrice() {
		BigDecimal valueFinal = BigDecimal.ZERO;
		for (Product product : productsInCart) {
			valueFinal = valueFinal.add(product.value());
		}	
		return valueFinal;
	}

	/**
	 * Metodo que acrescenta um novo produto ao carrinho de compras
	 * e retira do estoque com base na quantidade
	 * 
	 * @param product
	 * @param quantity
	 * @throws SupermarketException
	 */
	public void addProductInCart(final Product product, final int quantity) throws SupermarketException {
		if (stock.containsProduct(product, quantity)) {
			productsInCart.addAll(loadingProduct(product, quantity));
			stock.removeProductOfStock(product, quantity);
		}
		
	}
	
	/**
	 * Efetua a remoção do produto informado no carrinho de compras e 
	 * devolve ao estoque
	 * 
	 * @param product
	 * @param quantity
	 * @throws SupermarketException
	 */
	public void removeProductInCart(final Product product, final int quantity) throws SupermarketException {
		int cont = 0;
		if (productsInCart.contains(product)) {
			for (int contList = 0; contList <= productsInCart.size(); contList++) {
				if (cont <= quantity) {
					if (productsInCart.get(contList).equals(product)) {
						productsInCart.remove(cont);
						cont++;
					}
				}
			}
		}
		stock.addProductInStock(product, quantity);
	}

	/**
	 * Retorna a lista de produtos dentro do carrinho de compras
	 * 
	 * @return
	 */
	public final List<Product> shoppingList() {
		return Collections.unmodifiableList(productsInCart);
	}
	
	/**
	 * Metodo responsavel por retornar uma lista populada de 
	 * produtos de acordo com a quantidade informada
	 * 
	 * @param product
	 * @param quantity
	 * @return
	 */
	private final List<Product> loadingProduct(final Product product, final int quantity) {
		List<Product> productsList = new ArrayList<Product>(quantity);
		
		for (int cont = 0; cont < quantity; cont++) {
			productsList.add(new Product(product.barCode(), product.nameProduct(), product.value(),
					product.productInformation()));
		}
		return Collections.unmodifiableList(productsList);
	}
}