package com.nt.service;

import java.util.Date;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class Task1 {

//	@Scheduled(fixedDelay = 2000, initialDelay = 5000)
	//@Scheduled(fixedDelay = 2000)
	//@Scheduled(cron = "1 0-59 * * * *")
	@Scheduled(cron = "0/1 0/1 18,19,20,21 * * *")
	//@Scheduled(cron = "0 1 * * * *")
	public void taskFirst() {
		
		System.out.println("Task1(start)"+"..........."+new Date());
		/*try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
	//	System.out.println("Task1(end)"+"..........."+new Date());
		
	}
}
