/*
 * @(#)Supermarket 1.0 26 de out de 2016
 *
 *Copyright (c) 2016, hyperCLASS. All rights reserved. hyperCLASS
 *proprietary/confidential. Use is subject to license terms.
 *
 */
package br.com.hyperclass.supermarket.restapi.serializers;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import br.com.hyperclass.supermarket.domain.cashier.events.EventsSales;
import br.com.hyperclass.supermarket.restapi.wrapper.ProductsListWrapper;
import br.com.hyperclass.supermarket.restapi.wrapper.SalesPerDayReportWrapper;

/**
 * A classe <code>SalesPerDayReportSerializer</code> é responsavel por efetuar a serialização
 * de um objeto json passando as informações de venda ocorrida.
 * 
 * @author Guilherme Faria
 *
 * @version 1.0.0 26 de out de 2016
 */
public class SalesPerDayReportSerializer extends JsonSerializer<SalesPerDayReportWrapper>{

	
	@Override
	public void serialize(final SalesPerDayReportWrapper sales, final JsonGenerator generator, final SerializerProvider serializers)
			throws IOException, JsonProcessingException {
		
		generator.writeStartArray();
		for(EventsSales event: sales.events()) {
			generator.writeStartArray();
			new ProductsListSerializer().serialize(new ProductsListWrapper(event.getProducts()), generator, serializers);
			generator.writeStartObject();
			generator.writeNumberField("value", event.getValue());
			generator.writeObjectField("payment method", event.getPaymentMethods());
			generator.writeEndObject();
			generator.writeEndArray();
		}
		generator.writeEndArray();
	}

}
