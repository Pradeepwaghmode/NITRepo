package com.nt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.nt.service.IShopingImpl;
import com.nt.service.ShoppingServiceImpl;

@SpringBootApplication
public class BootMailProj01SendMailApplication {

	public static void main(String[] args) {
		ApplicationContext ctx=SpringApplication.run(BootMailProj01SendMailApplication.class, args);
		IShopingImpl shopping=ctx.getBean("shopping",ShoppingServiceImpl.class);
		String msg=null;
		try {
		 msg=shopping.FinalBill(new Float[] {100f,323f,444f,2323f}, new String[] {"Shart","pant","trauser","T-Shart"},new String[] {"pradeepwaghmode8@gmail.com","pradeepwaghmode952728@gmail.com","sanvisapisal07@gmail.com"} );
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		System.out.println(msg);
	}
		

}
