package com.nt.proccesor;

import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Component;

@Component("ibProccesor")
public class BookProccesor implements ItemProcessor<String, String> {
 
	private String book;
	@Override
	public String process(String item) throws Exception {
		
		if(item.equalsIgnoreCase("Finite and Infinite Games")) {
			book=item+" "+"by James P. Carse";
		}
		else if(item.equalsIgnoreCase("The Alchemist")) {
			book=item+" "+"by Paulo Coelho";
		}
		else if(item.equalsIgnoreCase("Principles")) {
			book=item+" "+"by Ray Dalio";
		} 
		else if(item.equalsIgnoreCase("Sapiens")) {
			book=item+" "+"by Yuval Noah Harari";
		} 
		else if(item.equalsIgnoreCase("The Psychology of Money")) {
			book=item+" "+" by Morgan Housel";
		}
		else if(item.equalsIgnoreCase("Atomic Habits")) {
			book=item+" "+" by James Clear";
		}
		else if(item.equalsIgnoreCase("Man’s Search For Meaning")) {
			book=item+" "+" by Viktor Frankl";
		} 
		else if(item.equalsIgnoreCase("Paris in the 20th Century")) {
			book=item+" "+" by Jules Verne";
		} 
		else 
			book=item;
		
		return book;
	}
}
