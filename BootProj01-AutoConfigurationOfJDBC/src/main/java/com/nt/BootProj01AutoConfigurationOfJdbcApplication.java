package com.nt;

import javax.sql.DataSource;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import com.nt.DAO.EmpDAO;


@SpringBootApplication
public class BootProj01AutoConfigurationOfJdbcApplication {

	@Bean
	public DataSource  createC3P0() throws Exception{
		ComboPooledDataSource ds=new ComboPooledDataSource();
		ds.setDriverClass("oracle.jdbc.driver.OracleDriver");
		ds.setJdbcUrl("jdbc:oracle:thin:@localhost:1521:orcl");
		ds.setUser("admin");
		ds.setPassword("admin");
		return ds;
	}
	public static void main(String[] args) throws Exception {
		ApplicationContext ctx=SpringApplication.run(BootProj01AutoConfigurationOfJdbcApplication.class, args);
		
		EmpDAO emp=ctx.getBean(EmpDAO.class);
		
		System.out.println("Total Employees  are  ::"+emp.getEmpCount());
		
		((ConfigurableApplicationContext) ctx).close();
		
	}

}
