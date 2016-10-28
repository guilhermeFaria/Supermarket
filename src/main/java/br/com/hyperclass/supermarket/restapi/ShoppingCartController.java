/*
 * @(#)Supermarket 1.0 25 de out de 2016
 *
 *Copyright (c) 2016, hyperCLASS. All rights reserved. hyperCLASS
 *proprietary/confidential. Use is subject to license terms.
 *
 */
package br.com.hyperclass.supermarket.restapi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.hyperclass.supermarket.domain.shoppingcart.ShoppingCart;
import br.com.hyperclass.supermarket.domain.stock.SupermarketException;
import br.com.hyperclass.supermarket.restapi.wrapper.ProductWrapper;
import br.com.hyperclass.supermarket.restapi.wrapper.ShoppingCartWrapper;

/**
 * A classe <code>ShoppingCartController</code> é responsavel por receber as
 * requisições referente ao carrinho de compras da aplicação.
 * 
 * @author Guilherme Faria
 *
 * @version 1.0.0 25 de out de 2016
 */
@RestController
public class ShoppingCartController {
	
	@Autowired
	private ShoppingCart cart;

	
	@RequestMapping(value = "/shoppingcart", method = {RequestMethod.POST, RequestMethod.GET}, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ShoppingCartWrapper addProductInCart(@RequestBody final ProductWrapper productWrapper) throws SupermarketException {
		cart.addProductInCart(productWrapper.product(), productWrapper.quantity());
		return new ShoppingCartWrapper(cart.shoppingList(), cart.currentPurchasePrice());
	}
	
	@RequestMapping(value = "/shoppingcart", method = {RequestMethod.DELETE, RequestMethod.GET}, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ShoppingCartWrapper removeProductInCart(@RequestBody final ProductWrapper productWrapper) throws SupermarketException {
		cart.removeProductInCart(productWrapper.product(), productWrapper.quantity());
		return new ShoppingCartWrapper(cart.shoppingList(),cart.currentPurchasePrice());
	}
	
	@RequestMapping(value = "/shoppingcart", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ShoppingCartWrapper showProductInShoppingCart() throws SupermarketException {
		return new ShoppingCartWrapper(cart.shoppingList(),cart.currentPurchasePrice());
	}
	
}