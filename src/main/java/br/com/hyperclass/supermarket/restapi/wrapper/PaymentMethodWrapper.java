/*
 * @(#)Supermarket 1.0 23 de out de 2016
 *
 *Copyright (c) 2016, hyperCLASS. All rights reserved. hyperCLASS
 *proprietary/confidential. Use is subject to license terms.
 *
 */
package br.com.hyperclass.supermarket.restapi.wrapper;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import br.com.hyperclass.supermarket.restapi.deserializers.PaymentMethodDeserializer;
import br.com.hyperclass.supermarket.restapi.serializers.PaymentMethodSerializer;

/**
 *A classe <code>PaymentMethodWrapper</code> é responsavel por contruir um modelo
 *de serialização e deserialização de objeto Json relacionada ao metodo de pagamento.
 * 
 * @author Guilherme Faria
 *
 * @version 1.0.0 23 de out de 2016
 */
@JsonDeserialize(using = PaymentMethodDeserializer.class)
@JsonSerialize(using = PaymentMethodSerializer.class)
public class PaymentMethodWrapper {
	
	private final String paymentMethod;
	
	public PaymentMethodWrapper(final String paymentMethod) {
		this.paymentMethod = paymentMethod;
	}

	public String paymentMethod() {
		return paymentMethod;
	}
}