package com.nt.Listerner;

import java.util.Date;

import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobExecutionListener;
import org.springframework.stereotype.Component;

@Component("ibListener")
public class BookItemListener implements JobExecutionListener {

	private long start,end;
	
	@Override()
	public void beforeJob(JobExecution jobExecution) {
		// TODO Auto-generated method stub
		System.out.println("BookItemListener.beforeJob()");
		System.out.println("job status :: "+jobExecution.getStatus());
		start=System.currentTimeMillis();
		System.out.println("Strart time :: "+new Date());
	}

	
	@Override
	public void afterJob(JobExecution jobExecution) {
		System.out.println("BookItemListener.afterJob()");
		System.out.println("job status :: "+jobExecution.getStatus());
		end=System.currentTimeMillis();
		System.out.println("End time :: "+new Date());
		System.out.println("Totle Execution time :: "+(end-start));
		System.out.println("job exit status :: "+jobExecution.getExitStatus());
	}
}
