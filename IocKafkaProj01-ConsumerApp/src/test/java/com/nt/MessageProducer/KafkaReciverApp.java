package com.nt.MessageProducer;

import java.time.Duration;
import java.util.Arrays;
import java.util.Properties;
import java.util.Scanner;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.serialization.StringDeserializer;


public class KafkaReciverApp {

	public static void main(String[] args) {
	   
			
		
		Properties props=new Properties();
		props.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
		props.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG,StringDeserializer.class.getName());
		props.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG,StringDeserializer.class.getName());
		props.put(ConsumerConfig.GROUP_ID_CONFIG, "group1");
		//create KafkaProducer object
		KafkaConsumer<String, String> consumer=new KafkaConsumer<String, String>(props);
		
		consumer.subscribe(Arrays.asList("nit-tp1"));
		while(true) {
			ConsumerRecords<String, String> records=consumer.poll(Duration.ofMillis(1000));
			
			for(ConsumerRecord<String, String> record : records) {
				System.out.println("Message is :: "+record.value());
			}
			
		}
		
	
		
		

	}

}