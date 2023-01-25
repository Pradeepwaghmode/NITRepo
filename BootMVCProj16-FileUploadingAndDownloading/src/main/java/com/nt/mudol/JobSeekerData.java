package com.nt.mudol;

import javax.persistence.Column;

import org.springframework.web.multipart.MultipartFile;

import lombok.Data;
@Data
public class JobSeekerData {
	private String jsname;
	private String jsaddr;
	private MultipartFile resume;
	private MultipartFile photo;
}
