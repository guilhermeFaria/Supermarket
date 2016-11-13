/*
 * @(#)Supermarket 1.0 13 de out de 2016
 *
 *Copyright (c) 2016, hyperCLASS. All rights reserved. hyperCLASS
 *proprietary/confidential. Use is subject to license terms.
 *
 */
package br.com.hyperclass.supermarket.domain.cashier.events;

import java.math.BigDecimal;
import java.util.List;

import br.com.hyperclass.supermarket.domain.cashier.PaymentMethod;
import br.com.hyperclass.supermarket.domain.product.Product;

/**
 * A classe <code>PurchaseCompleteEvent</code> representa o evento 
 * de compra finalizada.
 * 
 * @author Guilherme Faria
 *
 * @version 1.0 13/10/2016
 */
public class PurchaseCompleteEvent extends EventsSales {

	private static final long serialVersionUID = 1L;

	public PurchaseCompleteEvent(final List<Product> products, final BigDecimal purchasePrice, final PaymentMethod paymentMethod) {
		super(new ContextEventSales(products, purchasePrice, paymentMethod));
	}
}
