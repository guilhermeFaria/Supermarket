/*
 * @(#)Supermarket 1.0 26 de out de 2016
 *
 *Copyright (c) 2016, hyperCLASS. All rights reserved. hyperCLASS
 *proprietary/confidential. Use is subject to license terms.
 *
 */
package br.com.hyperclass.supermarket.restapi.wrapper;

import java.util.List;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import br.com.hyperclass.supermarket.domain.cashier.events.EventsSales;
import br.com.hyperclass.supermarket.restapi.serializers.SalesPerDayReportSerializer;

/**
 *A classe <code>SalesPerDayReportWrapper</code> é responsavel por contruir um modelo
 *de serialização de objeto Json relacionada ao relatorio de vendas.
 *
 * @author Guilherme Faria
 *
 * @version 1.0.0 26 de out de 2016
 */

@JsonSerialize(using=SalesPerDayReportSerializer.class)
public class SalesPerDayReportWrapper {
	List<EventsSales> events;
	
	public SalesPerDayReportWrapper(final List<EventsSales> events) {
		this.events = events;
	}
	
	public List<EventsSales> events() {
		return events;
	}

}