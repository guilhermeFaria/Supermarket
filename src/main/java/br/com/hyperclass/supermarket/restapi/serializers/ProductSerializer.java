/*
 * @(#)Supermarket 1.0 14 de out de 2016
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

import br.com.hyperclass.supermarket.restapi.wrapper.ProductWrapper;

/**
 *  A classe <code>ProductSerializer</code> é responsavel por efetuar a serialização
 * de um objeto json passando as informações de um determinado produto.
 * 
 * @author Guilherme Faria
 *
 * @version 1.0.0 14/10/2016
 */

public class ProductSerializer extends JsonSerializer<ProductWrapper>{

	@Override
	public void serialize(ProductWrapper productWrapper, JsonGenerator generator, SerializerProvider serializer)
			throws IOException, JsonProcessingException {
		generator.writeStartObject();
		generator.writeStringField("barcode", productWrapper.product().barCode());
		generator.writeStringField("product", productWrapper.product().nameProduct());
		generator.writeNumberField("value", productWrapper.product().value());
		generator.writeStringField("product information", productWrapper.product().productInformation());
		generator.writeNumberField("quantity", productWrapper.quantity());
		generator.writeEndObject();	
	}

}