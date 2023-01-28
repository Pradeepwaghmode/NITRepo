package com.nt.service;

import java.util.Arrays;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ClassPathResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import jakarta.mail.internet.MimeMessage;

@Service("shopping")
public class ShoppingServiceImpl implements IShopingImpl {

	@Autowired
	private JavaMailSender sender;
	@Value("${spring.mail.username}")
	private String fromMail;
	private String regards="Yours sincerely,\r\n"
			+ "\r\n"
			+ "Pradeep Waghmode\r\n"
			+ "\r\n"
			+ "pradeepwaghmode952728@gmail.com\r\n"
			+ "\r\n"
			+ "☏ Mobile: +91 7709064144\r\n"
			+ "\r\n"
			+ "Pune, INDIA\r\n"
			+ "\r\n"
			+ "\r\n"
			+ "";
	@Override
	public String FinalBill(Float[] prices, String[] items, String[] tomail) throws Exception {
		
		Float billAmt=0.0f;
		for(Float p:prices) {
			billAmt=billAmt+p;
		}
		String msg="the items "+Arrays.toString(items)+" with prices "+Arrays.toString(prices)+" purches having bill amount :: "+billAmt;
		String status=sendMail(msg,tomail);
		return msg+"---------"+status;
	}
	
	public String sendMail(String msg,String[] tomail) throws Exception{
		MimeMessage message=sender.createMimeMessage();
		MimeMessageHelper helper=new MimeMessageHelper(message,true);
		helper.setFrom(fromMail);
		helper.setCc(tomail);
	//	helper.setTo("pradeepwaghmode8@gmail.com");
		helper.setSentDate(new Date());
		helper.setSubject("open it to know it ");
		helper.setText("Hi All ,"
				+ "  \\r\\n 	"+msg+regards);
		helper.addAttachment("nit.jpg",new ClassPathResource("oracle.png"));
		sender.send(message);
		return "Mail Send";
	}
	

}
