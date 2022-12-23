package com.nt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;


import com.zaxxer.hikari.HikariDataSource;

@SpringBootApplication
public class BootDataJpaProj13CallingPlsqlMysqlApplication {

//	@Bean
//	  public HikariDataSource ceateDataSource()throws Exception{
//	  
//		HikariDataSource ds=new HikariDataSource();
//	  ds.setDriverClassName("oracle.jdbc.driver.OracleDriver");
//	  ds.setJdbcUrl("jdbc:oracle:thin:@localhost:1521:orcl");
//	  ds.setUsername("admin");
//	  ds.setPassword("admin");
//	  return ds;
//	  }
	public static void main(String[] args) {
		SpringApplication.run(BootDataJpaProj13CallingPlsqlMysqlApplication.class, args);
	}

}
