package com.nt.config;

import javax.persistence.EntityManagerFactory;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.database.builder.JpaItemWriterBuilder;
import org.springframework.batch.item.file.builder.FlatFileItemReaderBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.io.FileSystemResource;

import com.nt.listener.BatchProccessMonitorListener;
import com.nt.model.IExamResult;
import com.nt.model.OExamResult;
import com.nt.proccessor.ExamResultItemProccessor;

@Configuration
@EnableBatchProcessing
@PropertySource("com/nt/commns/application.properties")
public class BatchConfig {

	@Autowired
	private JobBuilderFactory jbFactory;
	
	@Autowired
	private StepBuilderFactory sbFactory;
	
	@Autowired
	private ExamResultItemProccessor  proccessor;
	
	@Autowired
	private BatchProccessMonitorListener listener;
	
	@Autowired
	private EntityManagerFactory emFactory;
	
	
	@Bean
	public ItemReader< IExamResult> createReader(){
		return new FlatFileItemReaderBuilder<IExamResult>()
																				.name("flatFile-Reader")
																				.resource(new FileSystemResource("src/main/java/com/nt/commns/topBrain.csv"))
																				.delimited().delimiter(",")
																				.names("id","dob","semester","percentage")
																				.targetType(IExamResult.class)
																				.build();
	}
	
	@Bean
	public ItemWriter<OExamResult> createWriter(){
		return new JpaItemWriterBuilder<OExamResult>()
																				.entityManagerFactory(emFactory)
																				.build();
	}
	
	@Bean(name="Step1")
	public Step createStep1() {
		return sbFactory.get("Step1")
										.<IExamResult,OExamResult>chunk(10)
										.reader(createReader())
										.writer(createWriter())
										.processor(proccessor)
										.build();
	}
	
	@Bean(name="Job1")
	public Job createJob1() {
		return  jbFactory.get("Job1")
										.incrementer(new RunIdIncrementer())
										.listener(listener)
										.start(createStep1())
										.build();
	}
	
	
}
