/*
 * @(#)Supermarket 1.0 13 de out de 2016
 *
 *Copyright (c) 2016, hyperCLASS. All rights reserved. hyperCLASS
 *proprietary/confidential. Use is subject to license terms.
 *
 */
package br.com.hyperclass.supermarket.domain.stock;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * A classe <code>ProductUnavailable</code> representa a situação em que não há a 
 * quantidade solicitada disponivel de um produto no estoque.   
 * 
 * @author Guilherme Faria
 *
 * @version
 */
@ResponseStatus(value = HttpStatus.SERVICE_UNAVAILABLE, reason= "Product Unavailable")
public class ProductUnavailableException extends SupermarketException {

	private static final long serialVersionUID = 1L;

}
