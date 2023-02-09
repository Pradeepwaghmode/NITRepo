package com.nt.Service;

import java.util.Date;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service("batch")
public class BulkEmployeeInsertionThroughBatch implements CommandLineRunner{

	@Autowired
	private Job job;
	
	@Autowired
	private JobLauncher launcher;
	
	/*//@Scheduled(cron="0 42 17 * * *")
	public void run()  throws Exception {
		JobParameters param=new JobParametersBuilder().addDate("sysDate", new Date()).toJobParameters();
		
		JobExecution execution=launcher.run(job, param);
		System.out.println("Final Status is :: "+execution.getExitStatus());
	}*/
	
	@Override
	public void run(String... args) throws Exception {
JobParameters param=new JobParametersBuilder().addDate("sysDate", new Date()).toJobParameters();
		
		JobExecution execution=launcher.run(job, param);
		System.out.println("Final Status is :: "+execution.getExitStatus());
		
	}
}
