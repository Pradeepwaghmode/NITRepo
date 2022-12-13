package com.nt;

import java.sql.SQLException;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import com.nt.controller.MainController;
import com.nt.modal.Employee;

@SpringBootApplication
public class BootProj01RealDpApplication {
	
	  
	  @Bean
	  @Profile({"uat"})
	  public ComboPooledDataSource ceateDataSource()throws Exception{
	  
		  ComboPooledDataSource ds=new ComboPooledDataSource();
	  ds.setDriverClass("oracle.jdbc.driver.OracleDriver");
	  ds.setJdbcUrl("jdbc:oracle:thin:@localhost:1521:orcl");
	  ds.setUser("admin");
	  ds.setPassword("admin");
	  return ds;
	  }
	 

	public static void main(String[] args) {
		ApplicationContext ctx = SpringApplication.run(BootProj01RealDpApplication.class, args);

		System.out.println("BootProj01RealDpApplication.main()");
		MainController controller = ctx.getBean("controller", MainController.class);

		try {
			List<Employee> emplist = controller.gatherEmpByDesg("CLERK", "MANAGER", "SELSMAN");

			emplist.forEach(emp -> {
				System.out.println(emp);
			});
		} catch (SQLException e) {
			// TODO: handle exception
			System.out.println("Internal DB Exception come !!!");
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Unkownon Exception come !!!");
		}

		((ConfigurableApplicationContext) ctx).close();
	}

}
