/*
 * @(#)Supermarket 1.0 25 de out de 2016
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

import br.com.hyperclass.supermarket.restapi.wrapper.ProductsListWrapper;
import br.com.hyperclass.supermarket.restapi.wrapper.ShoppingCartWrapper;

/**
 * A classe <code>ShoppingCartSerializer</code> é responsavel por efetuar a serialização
 * de um objeto json passando uma lista de produtos e tambem o valor total do carrinho de compras.
 * 
 * @author Guilherme Faria
 *
 * @version 1.0.0 25 de out de 2016
 */
public class ShoppingCartSerializer extends JsonSerializer<ShoppingCartWrapper>{ 
	
	@Override
	public void serialize(ShoppingCartWrapper shoppingCartWrapper, JsonGenerator generator, SerializerProvider serializer)
			throws IOException, JsonProcessingException {
		
		new ProductsListSerializer().serialize(new ProductsListWrapper(shoppingCartWrapper.products()), generator, serializer);
		generator.writeStartObject();
		generator.writeNumberField("total", shoppingCartWrapper.purchasePrice());
		generator.writeEndObject();
	}
}