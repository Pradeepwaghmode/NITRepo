package com.nt;

import java.util.Set;
import java.util.stream.Stream;

import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import ch.qos.logback.core.net.SyslogOutputStream;

@SpringBootApplication
public class BootProj12LambdaExpresionWithRunnersApplication {

	@Bean
	public CommandLineRunner CreatCmdRunner() {
		
		/*
		 * CommandLineRunner alr=args->{
		 * System.out.println("Command Line Runners :"+Arrays.toString(args)); };
		 */
		
		
		/*
		 * CommandLineRunner alr=args->{ System.out.println("Runner of comd : ");
		 * for(String name:args) { System.out.println(Arrays.toString(args)); } };
		 */
		
		/*
		 * CommandLineRunner alr=args->{ System.out.println("Runner of comd : ");
		 * 
		 * Stream.of(args).forEach(System.out::println);
		 * 
		 * };
		 */
		
		
		
		return  args->Stream.of(args).forEach(System.out::println);
	}
	
	@Bean
	public ApplicationRunner createApplicationRunnerImpl() {
		
		return args->{
			System.out.println("Application Runner");
			System.out.println("Non-Optional : "+args.getNonOptionArgs());
			System.out.println("argument name and value");

			Set<String> optionArgs=args.getOptionNames();
			optionArgs.forEach(name->{
					System.out.println("argument name "+name);
					System.out.println(args.getOptionValues(name));
							
			});
					
					
		};
	}
	public static void main(String[] args) {
		SpringApplication.run(BootProj12LambdaExpresionWithRunnersApplication.class, args);
		
		System.out.println("========================");
	}

}
