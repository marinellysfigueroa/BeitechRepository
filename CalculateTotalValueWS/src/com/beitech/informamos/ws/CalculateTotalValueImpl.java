package com.beitech.informamos.ws;

import javax.jws.WebService;

@WebService(endpointInterface="com.beitech.informamos.ws.CalculateTotalValue")
public class CalculateTotalValueImpl implements CalculateTotalValue {

	@Override
	public double total(Double price, String currency) {
		final Double DOLAR_VALUE = 3442.00;
		final Double EURO_VALUE = 3789.81;

		Double valueConverter = 0.0;

		if (currency.contentEquals("USD")) {

			valueConverter = price / DOLAR_VALUE;
		} else {
			valueConverter = price / EURO_VALUE;

		}

		return valueConverter;
	}

}
