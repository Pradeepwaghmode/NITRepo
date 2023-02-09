package com.nt.listener;

import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobExecutionListener;
import org.springframework.stereotype.Component;

@Component
public class BatchProccessMonitorListener implements JobExecutionListener {

	@Override
	public void beforeJob(JobExecution jobExecution) {
		System.out.println("Job Status :: " + jobExecution.getStatus());
		System.out.println("start time :: " + jobExecution.getStartTime());
	}

	@Override
	public void afterJob(JobExecution jobExecution) {
		
		System.out.println("end time :: " + jobExecution.getEndTime());
		System.out.println("Job Status :: " + jobExecution.getStatus());
		System.out.println("batch exit status :: " + (jobExecution.getExitStatus()));
	}
}
