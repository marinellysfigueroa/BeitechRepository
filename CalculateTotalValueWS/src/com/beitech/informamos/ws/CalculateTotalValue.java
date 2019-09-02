package com.beitech.informamos.ws;

import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService
public interface CalculateTotalValue {
	@WebMethod
	public double total(Double price, String currency);

}
