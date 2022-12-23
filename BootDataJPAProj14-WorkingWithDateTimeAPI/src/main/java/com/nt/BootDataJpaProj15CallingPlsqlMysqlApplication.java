package com.nt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;


import com.zaxxer.hikari.HikariDataSource;

@SpringBootApplication
public class BootDataJpaProj15CallingPlsqlMysqlApplication {


	public static void main(String[] args) {
		SpringApplication.run(BootDataJpaProj15CallingPlsqlMysqlApplication.class, args);
	}

}
