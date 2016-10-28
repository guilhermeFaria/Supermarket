/*
 * @(#)Supermarket 1.0 14 de out de 2016
 *
 *Copyright (c) 2016, hyperCLASS. All rights reserved. hyperCLASS
 *proprietary/confidential. Use is subject to license terms.
 *
 */
package br.com.hyperclass.supermarket.restapi.deserializers;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.ObjectCodec;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;

import br.com.hyperclass.supermarket.domain.product.Product;
import br.com.hyperclass.supermarket.restapi.wrapper.ProductWrapper;

/**
 * * A classe <code>ProductDeserializer</code> é responsavel por efetuar a deserialização
 * de objeto json retornando a informação de um produto.
 * 
 * @author Guilherme Faria
 *
 * @version 1.0.0 14/10/2016
 */
public class ProductDeserializer extends JsonDeserializer<ProductWrapper>{

	@Override
	public ProductWrapper deserialize(final JsonParser jsonParser, final DeserializationContext context)
			throws IOException, JsonProcessingException {
		ObjectCodec oc = jsonParser.getCodec();
        JsonNode node = oc.readTree(jsonParser);
		
        return new ProductWrapper(new Product(node.get("codebar").asText(), node.get("product").asText(), node.get("value").decimalValue(), node.get("productinformation").asText()), node.get("quantity").asInt());
	}
}