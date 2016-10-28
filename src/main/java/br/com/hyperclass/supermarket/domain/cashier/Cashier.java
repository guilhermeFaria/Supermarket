/*
 * @(#)Supermarket 1.0 11 de out de 2016
 *
 *Copyright (c) 2016, hyperCLASS. All rights reserved. hyperCLASS
 *proprietary/confidential. Use is subject to license terms.
 *
 */
package br.com.hyperclass.supermarket.domain.cashier;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import br.com.hyperclass.supermarket.domain.cashier.events.EventsSales;
import br.com.hyperclass.supermarket.domain.cashier.events.PurchaseCompleteEvent;
import br.com.hyperclass.supermarket.domain.shoppingcart.ShoppingCart;

/**
 * A classe <code>Cashier</code> é responsavel por registrar os eventos 
 * de venda ocorridos na aplicação.  
 * 
 * @author Guilherme Faria
 *
 * @version 1.0.0 11/10/2016
 */
public class Cashier {
	
	private final List<EventsSales> events = new ArrayList<>();
	private ShoppingCart cart;
	
	public Cashier() {
		super();
	}

	public void purchaseComplete(final String paymentMethod) {
		events.add(new PurchaseCompleteEvent(cart.shoppingList(), cart.currentPurchasePrice(), PaymentMethod.valueOf(paymentMethod)));
	}

	public List<EventsSales> events() {
		return Collections.unmodifiableList(events);
	}
	
	public List<EventsSales> salePerDay(final Long date) {
		LocalDate dateRequest = LocalDate.parse(date.toString(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));
		List<EventsSales> salesListPerDay = new ArrayList<>();
		for(EventsSales event: events) {
			if(event.getDate().equals(dateRequest)) {
				salesListPerDay.add(event);
			}
		}
		return Collections.unmodifiableList(salesListPerDay);
	}
	
	public void checkout(final ShoppingCart cart) {
		this.cart = cart;
	}
}