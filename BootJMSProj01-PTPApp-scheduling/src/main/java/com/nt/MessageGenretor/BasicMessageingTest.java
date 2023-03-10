package com.nt.MessageGenretor;

import java.util.Date;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class BasicMessageingTest  {

	@Autowired
	private JmsTemplate template;
	private int i=0;	@Scheduled(cron = "*/10 * * * * *")
	public void MessageSender() {
		// TODO Auto-generated method stub
		
		/*template.send("testMQ", new MessageCreator() {
			
			@Override
			public Message createMessage(Session session) throws JMSException {
				// TODO Auto-generated method stub
				Message message=session.createTextMessage("Message From sender at :: "+new Date());
				return message;
			}
		});*/
		
		/*template.send("testMQ",ses->{
			Message message=ses.createTextMessage("Message From sender at :: "+new Date());
			return message;
		});*/
		template.send("testMQ",ses->ses.createTextMessage("Message From sender at :: "+new Date()));
		System.out.println("message send successfully"+i++);
	}
}
