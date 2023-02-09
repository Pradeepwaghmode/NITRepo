package com.nt;

import javax.sql.DataSource;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;

import com.zaxxer.hikari.HikariDataSource;

@SpringBootApplication
public class BootBatchProj03CscToDbBatchInsertionApplication {

	/*@Bean
	public DataSource createDataSource() {
		HikariDataSource ds=new HikariDataSource();
		ds.setDriverClassName("oracle.jdbc.driver.OracleDriver");
		ds.setJdbcUrl("jdbc:oracle:thin:@localhost:1521:orcl");
		ds.setUsername("admin");
		ds.setPassword("admin");
		return ds;
	}*/
	
	public static void main(String[] args) {
		SpringApplication.run(BootBatchProj03CscToDbBatchInsertionApplication.class, args);
		
	}

}
