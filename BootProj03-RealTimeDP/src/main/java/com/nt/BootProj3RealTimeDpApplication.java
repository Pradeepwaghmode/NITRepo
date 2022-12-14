package com.nt;

import java.sql.SQLException;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;

import com.nt.controller.MainController;
import com.nt.modal.Employee;

@SpringBootApplication
public class BootProj3RealTimeDpApplication {

	public static void main(String[] args) {
		ApplicationContext ctx = SpringApplication.run(BootProj3RealTimeDpApplication.class, args);
      System.out.println("===============================================");
		MainController controller = ctx.getBean("controller", MainController.class);

		System.out.println("===============================================");
		
		try {
			List<Employee> emplist = controller.gatherEmpByDesg("CLERK", "MANAGER", "SELSMAN");
			System.out.println("================================");
			emplist.forEach(emp -> {
				System.out.println(emp.getEName());
			});
			System.out.println("================================");
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
