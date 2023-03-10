package com.nt.message;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;
@Component
public class Messageeader {

	@JmsListener(destination = "testMQ")
	public void readMessage(String text) {
		System.out.println("Message( --- "+text+" --- )");
	}
}
