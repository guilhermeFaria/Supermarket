/*
 * @(#)Supermarket 1.0 21 de out de 2016
 *
 *Copyright (c) 2016, hyperCLASS. All rights reserved. hyperCLASS
 *proprietary/confidential. Use is subject to license terms.
 *
 */
package br.com.hyperclass.supermarket.domain.cashier.events;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import br.com.hyperclass.supermarket.domain.cashier.PaymentMethod;
import br.com.hyperclass.supermarket.domain.product.Product;

/**
 * A classe <code>ContextSales</code> contem os dados de operação de venda.
 * 
 * @author Guilherme Faria
 *
 * @version 1.0.0 21 de out de 2016
 */
public class ContextEventSales {
	
	private final List<Product> products = new ArrayList<>();
    private final LocalDate date;
    private final BigDecimal value;
    private final PaymentMethod paymentMethod;
    private final DateTimeFormatter timeFormat = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    public ContextEventSales(final List<Product> products, final BigDecimal purchasePrice, final PaymentMethod paymentMethod) {
        this.date = LocalDate.now();
        date.format(timeFormat);
        this.value = purchasePrice;
        this.paymentMethod = paymentMethod;
    }
    
    public List<Product> getProducts() {
    	return products;
    }
    
    public LocalDate getData() {
        return date;
    }

    public BigDecimal getValue() {
        return value;
    }
    public PaymentMethod getPaymentMethod() {
    	return paymentMethod;
    }
}