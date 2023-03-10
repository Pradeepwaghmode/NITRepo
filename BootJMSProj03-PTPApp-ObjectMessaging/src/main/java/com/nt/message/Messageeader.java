package com.nt.message;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import com.nt.model.Player;
@Component
public class Messageeader {

	@JmsListener(destination = "objMQ")
	public void readMessage(Player player) {
		System.out.println("Message( --- "+player+" --- )");
	}
}
