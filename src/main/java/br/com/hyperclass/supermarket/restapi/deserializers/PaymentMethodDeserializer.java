/*
 * @(#)Supermarket 1.0 23 de out de 2016
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

import br.com.hyperclass.supermarket.restapi.wrapper.PaymentMethodWrapper;

/**
 * A classe <code>PaymentMethodDeserializer</code> é responsavel por efetuar a deserialização
 * de objeto json com a informação relacionada do metodo de pagamento.
 * 
 * @author Guilherme Faria
 *
 * @version 1.0.0 23 de out de 2016
 */
public class PaymentMethodDeserializer extends JsonDeserializer<PaymentMethodWrapper> {
	
	@Override
	public PaymentMethodWrapper deserialize(final JsonParser jsonParser, final DeserializationContext ctxt)
			throws IOException, JsonProcessingException {
		ObjectCodec oc = jsonParser.getCodec();
        JsonNode node = oc.readTree(jsonParser);
		return new PaymentMethodWrapper(node.get("paymentmethod").asText());
	}
}