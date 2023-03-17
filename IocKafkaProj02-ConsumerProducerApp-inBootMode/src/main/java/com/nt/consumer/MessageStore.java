package com.nt.consumer;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class MessageStore {

	private List<String> list=new ArrayList();
	
	public void setMessage(String msg) {
		list.add(msg);
	}
	
	public List<String> getMessage(){
		return this.list;
	}
}
