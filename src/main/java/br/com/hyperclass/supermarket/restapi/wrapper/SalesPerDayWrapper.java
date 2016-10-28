/*
 * @(#)Supermarket 1.0 26 de out de 2016
 *
 *Copyright (c) 2016, hyperCLASS. All rights reserved. hyperCLASS
 *proprietary/confidential. Use is subject to license terms.
 *
 */
package br.com.hyperclass.supermarket.restapi.wrapper;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import br.com.hyperclass.supermarket.restapi.deserializers.SalesPerDayDeserializer;

/**
 *A classe <code>SalesPerDayWrapper</code> é responsavel por contruir um modelo
 *de deserialização de objeto Json relacionada a data.
 * 
 * @author Guilherme Faria
 *
 * @version 1.0.0 26 de out de 2016
 */

@JsonDeserialize(using = SalesPerDayDeserializer.class)
public class SalesPerDayWrapper {
	private final Long date;
	
	public SalesPerDayWrapper(final Long date) {
		this.date = date;
	}
	
	public Long date() {
		return date;
	}
}
