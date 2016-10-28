/*
 * @(#)Supermarket 1.0 14 de out de 2016
 *
 *Copyright (c) 2016, hyperCLASS. All rights reserved. hyperCLASS
 *proprietary/confidential. Use is subject to license terms.
 *
 */
package br.com.hyperclass.supermarket.restapi.serializers;

import java.io.IOException;
import java.util.Map;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import br.com.hyperclass.supermarket.domain.product.Product;
import br.com.hyperclass.supermarket.restapi.wrapper.ProductWrapper;
import br.com.hyperclass.supermarket.restapi.wrapper.ProductsListWrapper;


/**
 * A classe <code>ProductsListSerializer</code> é responsavel por efetuar a serialização
 * de um objeto json passando as informações de uma lista de produtos.
 * 
 * @author Guilherme Faria
 *
 * @version 1.0.0 14/10/2016
 */
public class ProductsListSerializer extends JsonSerializer<ProductsListWrapper>{
	
	@Override
	public void serialize(ProductsListWrapper productsListWrapper, JsonGenerator generator, SerializerProvider serializer)
			throws IOException, JsonProcessingException {
		
		generator.writeStartArray();
		for (Map.Entry<Product, Integer> product : productsListWrapper.products().entrySet()) {
			new ProductSerializer().serialize(
					new ProductWrapper(product.getKey(), product.getValue()), 
					generator, serializer);
		}
		generator.writeEndArray();		
	}
}