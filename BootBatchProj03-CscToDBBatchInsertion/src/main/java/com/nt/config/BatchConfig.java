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
import org.springframework.batch.item.database.builder.JdbcBatchItemWriterBuilder;
import org.springframework.batch.item.file.builder.FlatFileItemReaderBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.FileSystemResource;
import org.springframework.scheduling.annotation.EnableScheduling;

import com.nt.listener.EmployeeListerner;
import com.nt.modul.Employee;
import com.nt.proccessor.EmployeeProccessor;

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
	private EmployeeProccessor empProccessor;
	
	@Autowired
	private EmployeeListerner empListener;
	
	
	@Bean(name="reader")
	public  ItemReader<Employee>  createReader(){
	   return  new  FlatFileItemReaderBuilder<Employee>()
			                   .name("file-reader")
			                   .resource(new FileSystemResource("src/main/java/com/nt/commns/EmployeeInfo.csv"))
			                   .delimited().delimiter(",")
			                   .names("empno","empname","empaddrs","salary")
			                   .targetType(Employee.class)
			                   .build();
	}
	
	@Bean(name = "writer")
	public ItemWriter<Employee> createWriter(){
		return new JdbcBatchItemWriterBuilder<Employee>()
								.dataSource(ds)
								.sql("INSERT INTO BATCH_EMPLOYEE VALUES (:empno,:empname,:empaddrs,:salary,:netSalary,:grossSalary)")
								.beanMapped()
								.build();
	}
	
	@Bean(name="Step1")
	public Step createStep1() {
		
		return  sbFactory
					.get("Step1")
					.<Employee,Employee>chunk(10)
					.reader(createReader())
					.writer(createWriter())
					.processor(empProccessor)
					.build();
	}
	
	@Bean(name="Job1")
	public Job createJob1() {
		return jbFactory.get("Job1")
										.incrementer(new RunIdIncrementer())
										.listener(empListener)
										.start(createStep1())
										.build();
	}

}
