package com.beitech.informamos.ws;

import static org.junit.Assert.*;

import org.junit.Test;

public class CalculateTotalValueTest {

	@Test
	public void testTotal() {
		CalculateTotalValue service = 	new CalculateTotalValueImplService().getCalculateTotalValueImplPort();
		double total=service.total(172100.00, "USD");
		System.out.println("total "+total);
		assertTrue(total==50.00);
		
	}

}
