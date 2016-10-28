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

import br.com.hyperclass.supermarket.domain.cashier.Cashier;
import br.com.hyperclass.supermarket.domain.shoppingcart.ShoppingCart;
import br.com.hyperclass.supermarket.domain.stock.SupermarketException;
import br.com.hyperclass.supermarket.restapi.wrapper.PaymentMethodWrapper;
import br.com.hyperclass.supermarket.restapi.wrapper.ProductWrapper;
import br.com.hyperclass.supermarket.restapi.wrapper.SalesPerDayReportWrapper;
import br.com.hyperclass.supermarket.restapi.wrapper.SalesPerDayWrapper;
import br.com.hyperclass.supermarket.restapi.wrapper.ShoppingCartWrapper;

/**
 * A classe  <code>CashierController</code> é responsavel por receber as
 * requisições referente ao caixa da aplicação.
 * 
 * @author Guilherme Faria
 *
 * @version 1.0.0 25 de out de 2016
 */
@RestController
public class CashierController {
	
	@Autowired
	private Cashier cashier;
	
	@Autowired
	private ShoppingCart cart;
	
	@RequestMapping(value = "/cashier", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<ProductWrapper> checkout() throws SupermarketException {
		cashier.checkout(cart);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@RequestMapping(value = "/cashier", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ShoppingCartWrapper finalizingPurchase(@RequestBody final PaymentMethodWrapper paymentMethodWrapper) throws SupermarketException {
		cashier.checkout(cart);
		cashier.purchaseComplete(paymentMethodWrapper.paymentMethod());
		return new ShoppingCartWrapper(cart.shoppingList(),cart.currentPurchasePrice());
	}
	
	@RequestMapping(value = "/report/sale-per-day", method = {RequestMethod.POST, RequestMethod.GET}, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public SalesPerDayReportWrapper salePerDay(@RequestBody final SalesPerDayWrapper salePerDayWrapper) throws SupermarketException {
		return new SalesPerDayReportWrapper(cashier.salePerDay(salePerDayWrapper.date()));
	}

}