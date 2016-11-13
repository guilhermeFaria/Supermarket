/*
 * @(#)Supermarket 1.0 13 de out de 2016
 *
 *Copyright (c) 2016, hyperCLASS. All rights reserved. hyperCLASS
 *proprietary/confidential. Use is subject to license terms.
 *
 */
package br.com.hyperclass.supermarket.domain.cashier.events;


import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.EventObject;
import java.util.List;

import br.com.hyperclass.supermarket.domain.cashier.PaymentMethod;
import br.com.hyperclass.supermarket.domain.product.Product;

/**
 * A classe <code>EventSales</codes> representa um evento de venda na aplicação.
 * 
 * @author Guilherme Faria
 *
 * @version 1.0 13/10/2016
 */
public class EventsSales extends EventObject implements Comparable<EventsSales> {
	
	private static final long serialVersionUID = 1L;
	
	public EventsSales(final ContextEventSales context) {
		super(context);
	}
	
	public List<Product> getProducts() {
    	return getSource().getProducts();
    }
    
    public LocalDate getDate() {
    	return getSource().getData();
    }

    public BigDecimal getValue() {
        return getSource().getValue();
    }
    
    public PaymentMethod getPaymentMethods() {
    	return getSource().getPaymentMethod();
    }

	@Override
	public int compareTo(final EventsSales o) {
		return getDate().compareTo(o.getDate());
	}
	 
	@Override
	public ContextEventSales getSource() {
		return (ContextEventSales) super.getSource();
	}
}