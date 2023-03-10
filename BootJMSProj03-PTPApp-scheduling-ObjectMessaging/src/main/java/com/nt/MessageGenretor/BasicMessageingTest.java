package com.nt.MessageGenretor;

import java.time.LocalDateTime;
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

import com.nt.model.Player;

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
		Player player=new Player();
		player.setId(101);
		player.setBithPalace("Delhi");
		player.setName("Virat");
		player.setDob(LocalDateTime.of(1988, 10, 05, 10, 20));
//		template.send("objMQ",ses->ses.createObjectMessage(player));
		template.convertAndSend("objMQ",player);
		System.out.println("message send successfully  "+i++);
	}
}
