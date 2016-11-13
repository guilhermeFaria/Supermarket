/*
 * @(#)Supermarket 1.0 23 de out de 2016
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

import br.com.hyperclass.supermarket.restapi.wrapper.PaymentMethodWrapper;

/**
 * * A classe <code>PaymentMethodSerializer</code> é responsavel por efetuar a serialização
 * de objeto json com a informação relacionada do metodo de pagamento.
 * 
 * @author Guilherme Faria
 *
 * @version 1.0.0 23 de out de 2016
 */

public class PaymentMethodSerializer extends JsonSerializer<PaymentMethodWrapper> {

	
	@Override
	public void serialize(final PaymentMethodWrapper paymentMethodWrapper, final JsonGenerator generator, final SerializerProvider serializer)
			throws IOException, JsonProcessingException {
		generator.writeStartObject();
		generator.writeStringField("paymentMethod", paymentMethodWrapper.paymentMethod());
		generator.writeEndObject();
		
	}

}