package com.nt.config;



import javax.sql.DataSource;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.database.builder.JdbcCursorItemReaderBuilder;
import org.springframework.batch.item.file.builder.FlatFileItemWriterBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.io.FileSystemResource;

import com.nt.listener.EmployeeListerner;
import com.nt.modul.ExamResult;
import com.nt.proccessor.ExamResultProccessor;

@Configuration
@PropertySource("com/nt/commns/application.properties")
@EnableBatchProcessing
//@EnableScheduling
public class BatchConfig {
	
	@Autowired
	private DataSource ds;
	@Autowired
	private JobBuilderFactory jbFactory;
	
	@Autowired
	private StepBuilderFactory sbFactory;
	
	@Autowired
	private ExamResultProccessor examResultProccessor;
	
	@Autowired
	private EmployeeListerner examResultListener;
	
	
	@Bean(name="reader")
	public  ItemReader<ExamResult>  createReader(){
	   return  new JdbcCursorItemReaderBuilder<ExamResult>()
			   																			.name("jdbc-reader")
	   																					.dataSource(ds)
	   																					.sql("SELECT ID,DOB,SEMESTER,PERCENTAGE FROM EXAM_RESULT")
	   																					.beanRowMapper(ExamResult.class)
	   																					.build();
	   																					
	}
	
	@Bean(name = "writer")
	public ItemWriter<ExamResult> createWriter(){
		return new FlatFileItemWriterBuilder<ExamResult>()
																				.name("flatfile-writer")
																				.resource( new FileSystemResource("f:\\csvs\\topBrain.csv"))
																				.delimited().delimiter(",")
																				.names("id","dob","semester","percentage")
																				.build();
	}
	
	@Bean(name="Step1")
	public Step createStep1() {
		
		return  sbFactory
					.get("Step1")
					.<ExamResult,ExamResult>chunk(10)
					.reader(createReader())
					.writer(createWriter())
					.processor(examResultProccessor)
					.build();
	}
	
	@Bean(name="Job1")
	public Job createJob1() {
		return jbFactory.get("Job1")
										.incrementer(new RunIdIncrementer())
										.listener(examResultListener)
										.start(createStep1())
										.build();
	}

}
