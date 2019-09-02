package com.beitech.informamos.ws;

import javax.xml.ws.Endpoint;

public class CalculateTotalValuePublish {

	public static void main(String[] args) {
		Endpoint.publish("http://localhost:8081/WS/CalculateTotalValue", new CalculateTotalValueImpl());

	}

}
