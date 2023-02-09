package com.nt.writer;

import java.util.List;

import org.springframework.batch.item.ItemWriter;
import org.springframework.stereotype.Component;

@Component("ibWriter")
public class BookItemWriter implements ItemWriter<String>{
  
	@Override
	public void write(List<? extends String> items) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("BookItemWriter.write()");
		System.out.println("-------------------------------------------------------------------");
		items.forEach(System.out::println);
		System.out.println("-------------------------------------------------------------------");
	}
	
}
