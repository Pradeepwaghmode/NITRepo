package com.nt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

@SpringBootApplication
public class BootMvcProj16FileUploadingAndDownloadingApplication {

	@Bean("multipartResolver")
	public CommonsMultipartResolver createFileResolver() {
		CommonsMultipartResolver cmfr=new CommonsMultipartResolver();
		cmfr.setMaxUploadSize(-1);
		cmfr.setMaxUploadSizePerFile(1042*1024*50);
		return cmfr;
	}
	public static void main(String[] args) {
		SpringApplication.run(BootMvcProj16FileUploadingAndDownloadingApplication.class, args);
	}

}
