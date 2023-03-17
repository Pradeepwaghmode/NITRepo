package com.nt.producer;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
public class MessegeProducer {

	@Autowired
	private KafkaTemplate<String, String> template;
	
	@Value("${app.topic.name}")
	private String topic;
	
	public String sendMessage(String msg) {
		template.send(topic, msg);
		return "Message :: "+msg+" is sent successfully,Thank You!"+new Date();
	}
}
