package com.nt.runners;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Reader;
import java.io.Writer;
import java.util.Scanner;

import org.hibernate.result.Output;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.nt.modul.Person_Info_Lob;
import com.nt.service.IPersonInfoMngtService;



@Component
public class LOBs_Runner_Test implements CommandLineRunner {

	@Autowired
	private IPersonInfoMngtService service;
	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		
		/*//logic for storing 
		Scanner sc=new Scanner(System.in);
		
		System.out.println("Enter Name :");
		String name=sc.next();
		
		System.out.println("Enter marride or not ? ");
		boolean married=sc.nextBoolean();
		
		System.out.println("Eneter the photo path : ");
		String photo=sc.next();
		System.out.println(photo);
		
		System.out.println("Enter the Resume path : ");
		String resume=sc.next();
		System.out.println(resume);
		
		
		
		
		
		
		//read the photo path in file 
		InputStream is=new FileInputStream(photo);
		byte[] photoContaint=new byte[is.available()];
		photoContaint=is.readAllBytes();
		
		//read the resume path
		
		Reader reader=new FileReader(resume);
		File file=new File(resume);
		char[] resumeContaint=new char[(int) file.length()];
		
		
		Person_Info_Lob person=new Person_Info_Lob(1, name, married, photoContaint, resumeContaint);
		
		
		
		
		System.out.println("=============================");
		//LocalDateTime t=new LocalDateTimeJavaType();
		
		System.out.println(service.registerPerson(person));
		
		System.out.println("=============================");
		
		service.featchAllPersonDetails().forEach(System.out::println);
		
		*/
		
		//logic for retrieving 
		
		System.out.println("========Retrieving ================");
		
		Person_Info_Lob per=service.findById(252);
		
		if(per!=null) {
		
		System.out.println(per.getPid() +" "+per.getPname()+" ");
		
		//retrieving img
		byte[] photo=per.getPhoto();
		
		OutputStream io=new FileOutputStream("Natu.jpg");
		io.write(photo);
		io.flush();
		io.close();
		System.out.println("Photo retrivied !!");
		//retrieving text
		
		char[] resume=per.getResume();
		
		Writer witer=new FileWriter("NatarajResume.txt");
		
		witer.write(resume);
		witer.flush();
		witer.close();
		
		System.out.println("IMG retrivied !!");
		}
		else {
			System.out.println("Record not found !!");
		}
		
		
		
		

	}

}
