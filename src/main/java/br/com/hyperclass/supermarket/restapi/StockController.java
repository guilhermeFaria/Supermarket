/*
 * @(#)Supermarket 1.0 25 de out de 2016
 *
 *Copyright (c) 2016, hyperCLASS. All rights reserved. hyperCLASS
 *proprietary/confidential. Use is subject to license terms.
 *
 */
package br.com.hyperclass.supermarket.restapi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.hyperclass.supermarket.domain.stock.Stock;
import br.com.hyperclass.supermarket.domain.stock.SupermarketException;
import br.com.hyperclass.supermarket.restapi.wrapper.ProductWrapper;
import br.com.hyperclass.supermarket.restapi.wrapper.ProductsListWrapper;

/**
 * A classe <code>StockController</code> é responsavel por receber as
 * requisições referente ao estoque da aplicação.
 * 
 * @author Guilherme Faria
 *
 * @version 1.0.0 25 de out de 2016
 */

@RestController
public class StockController {
	@Autowired
	private Stock stock;
	
	@RequestMapping(value = {"", "/stock"}, method=RequestMethod.GET)
	public ProductsListWrapper showProducts() {
		return new ProductsListWrapper(stock.showProductsOfStock());
	}
	
	@RequestMapping(value= "/stock", method=RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<ProductWrapper> addProductStock(@RequestBody final ProductWrapper productWrapper) {
		stock.addProductInStock(productWrapper.product(), productWrapper.quantity());
		return new ResponseEntity<>(HttpStatus.CREATED);
	}
	
	@RequestMapping(value= "/stock", method=RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<ProductWrapper> removeProductStock(@RequestBody final ProductWrapper productWrapper) throws SupermarketException {
		stock.removeProductOfStock(productWrapper.product(), productWrapper.quantity());
		return new ResponseEntity<>(HttpStatus.ACCEPTED);
	}	
}