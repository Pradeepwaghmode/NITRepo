package com.nt.config;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.data.builder.MongoItemWriterBuilder;
import org.springframework.batch.item.file.builder.FlatFileItemReaderBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.FileSystemResource;
import org.springframework.data.mongodb.core.MongoTemplate;

import com.nt.document.ExamResult;
import com.nt.listener.BatchProccessMonitorListener;
import com.nt.proccessor.ExamResultProccessor;

@Configuration
@EnableBatchProcessing
public class BatchConfig {

	@Autowired
	private JobBuilderFactory jbFactory;
	
	@Autowired
	private StepBuilderFactory sbFactory;
	
	@Autowired
	private ExamResultProccessor proccessor;
	
	@Autowired
	private BatchProccessMonitorListener listener;
	
	@Autowired
	private MongoTemplate template;
	
	
	@Bean
	public ItemReader< ExamResult> createReader(){
		return new FlatFileItemReaderBuilder<ExamResult>()
																				.name("flatFile-Reader")
																				.resource(new FileSystemResource("src/main/java/com/nt/commns/topBrain.csv"))
																				.delimited().delimiter(",")
																				.names("id","dob","semester","percentage")
																				.targetType(ExamResult.class)
																				.build();
	}
	
	@Bean
	public ItemWriter<ExamResult> createWriter(){
		return new MongoItemWriterBuilder<ExamResult>()
																					.collection("TopResults")
																					.template(template)
																					.build();
	}
	
	@Bean(name="Step1")
	public Step createStep1() {
		return sbFactory.get("Step1")
										.<ExamResult,ExamResult>chunk(10)
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
