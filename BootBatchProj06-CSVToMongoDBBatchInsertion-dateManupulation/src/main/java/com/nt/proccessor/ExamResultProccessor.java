package com.nt.proccessor;

import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Component;

import com.nt.document.ExamResult;

@Component("proccessor")
public class ExamResultProccessor implements ItemProcessor<ExamResult, ExamResult> {

	private int count=0;
	@Override
	public ExamResult process(ExamResult item) throws Exception {
		if(item.getPercentage()>=95) {
			System.out.println(count++);
			return item;
		}
		else
		return null;
	}
}
