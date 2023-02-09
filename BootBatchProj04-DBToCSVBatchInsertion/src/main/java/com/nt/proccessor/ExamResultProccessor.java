package com.nt.proccessor;

import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Component;

import com.nt.modul.ExamResult;

@Component("empProccesor")
public class ExamResultProccessor implements ItemProcessor<ExamResult, ExamResult> {

	@Override
	public ExamResult process(ExamResult item) throws Exception {
		if(item.getPercentage()>=90)
			return item;
		else
		return null;
	}

	
}
