package com.nt.config;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.*;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import com.nt.Listerner.BookItemListener;
import com.nt.proccesor.BookProccesor;
import com.nt.reader.BookItemReader;
import com.nt.writer.BookItemWriter;

@Configuration
@EnableBatchProcessing
@PropertySource("com/nt/commns/application.properties")
public class BatchConfiguration {

	@Autowired
	private JobBuilderFactory jobFactory;
	
	@Autowired
	private StepBuilderFactory stepFactory;
	
	@Autowired
	private BookProccesor ibProccesor;
	
	@Autowired
	private BookItemListener ibListener;
	
	@Autowired
	private BookItemReader ibReader;
	
	@Autowired
	private BookItemWriter ibWriter;
	
	
		@Bean(name="Step1")
		public Step createStep1() {
			return stepFactory.get("Step1")
											   .<String,String>chunk(1)
											   .reader(ibReader)
											   .writer(ibWriter)
											   .processor(ibProccesor)
											   .build();
		}
		
		@Bean(name = "Job1")
		public Job createJob() {
			return jobFactory.get("Job1")
											.incrementer(new RunIdIncrementer())
											.listener(ibListener)
											.start(createStep1())
											.build();
		}
	
	
}
