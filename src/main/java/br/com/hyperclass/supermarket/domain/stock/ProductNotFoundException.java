/*
 * @(#)Supermarket 1.0 20 de out de 2016
 *
 *Copyright (c) 2016, hyperCLASS. All rights reserved. hyperCLASS
 *proprietary/confidential. Use is subject to license terms.
 *
 */
package br.com.hyperclass.supermarket.domain.stock;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * A classe <code>ProductNotFound</code> representa a situação em que 
 * passado um produto este não foi encontrado.
 * 
 * @author Guilherme Faria
 *
 * @version 1.0.0 20 de out de 2016
 */
@ResponseStatus(value = HttpStatus.NOT_FOUND, reason="Product not found")
public class ProductNotFoundException extends SupermarketException {

	private static final long serialVersionUID = 1L;

}
