package com.nt.consumer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class MessageListener {

	@Autowired
	private MessageStore store;
	
	@KafkaListener(topics = "${app.topic.name}",groupId = "group2")
	public void readMessage(String msg) {
		store.setMessage(msg);
	}
	
}
