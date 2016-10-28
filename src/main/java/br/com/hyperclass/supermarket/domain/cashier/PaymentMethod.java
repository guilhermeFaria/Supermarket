/*
 * @(#)Supermarket 1.0 11 de out de 2016
 *
 *Copyright (c) 2016, hyperCLASS. All rights reserved. hyperCLASS
 *proprietary/confidential. Use is subject to license terms.
 *
 */
package br.com.hyperclass.supermarket.domain.cashier;

/**
 * A enumeração <code>PaymentMethod</code> contem os
 * tipos de pagamento que podem ocorrer na aplicação
 *  
 * @author Guilherme Faria
 *
 * @version 1.0.0 23/10/2016
 */
public enum PaymentMethod {
	
	debit("debit"), 
	credit("credit"), 
	cash("cash"), 
	foodStamp("foodStamp");
	
	private String payment;
	
	private PaymentMethod(final String payment) {
		this.payment = payment;
	}
	
	public String getPayment() {
		return payment;
	}
	
}