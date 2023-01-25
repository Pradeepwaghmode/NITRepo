package com.nt.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.nt.entity.JobSeekerInfo;
import com.nt.mudol.JobSeekerData;
import com.nt.service.IJobPortalManagementServiceImpl;

@Controller
public class jobSeekerOperationsController {

	@Autowired
	private IJobPortalManagementServiceImpl service;
	
	@GetMapping
	public String showHome() {
		return "welcome";
	}
	
	@GetMapping("/register")
	public String loadRegisterForm(@ModelAttribute("js")JobSeekerData js) {
		
		return "registerForm";
	}
	
	@Autowired
	private Environment env;
	@PostMapping("/register")
	public String registerJobSeeker(@ModelAttribute("js")JobSeekerData js,Map<String,Object> map) throws Exception{
		 File f =new File(env.getRequiredProperty("upload.location"));
		 if(!f.isFile())
			 f.mkdir();
		 
		 MultipartFile resumeFile=js.getResume();
		 MultipartFile photoFile=js.getPhoto();
		 
		 InputStream isresume=resumeFile.getInputStream();
		 InputStream isphoto=photoFile.getInputStream();
		 
		 OutputStream osresume=new FileOutputStream(f.getAbsoluteFile()+"\\"+resumeFile.getOriginalFilename()) ;
		 OutputStream osphoto=new FileOutputStream(f.getAbsoluteFile()+"\\"+photoFile.getOriginalFilename()) ;
		 
		 IOUtils.copy(isresume, osresume);
		 IOUtils.copy(isphoto, osphoto);
		 
		 isphoto.close();
		 isresume.close();
		 osphoto.close();
		 isresume.close();
		 
		 JobSeekerInfo info=new JobSeekerInfo();
		 info.setJsaddr(js.getJsaddr());
		 info.setJsname(js.getJsname());
		 info.setResume(f.getAbsolutePath()+"\\"+resumeFile.getOriginalFilename());
		 info.setPhoto(f.getAbsolutePath()+"\\"+photoFile.getOriginalFilename());
		 
		 String msg=service.registerJobSeeker(info);
		 
		 map.put("msg", msg);
		 map.put("info", info);
		 map.put("file1", resumeFile.getOriginalFilename());
		 map.put("file2", photoFile.getOriginalFilename());
		 
		 
		return "Result";
	}
	
	@GetMapping("/jsList")
	public String report(Map<String,Object> map) {
		System.out.println("jobSeekerOperationsController.report()");
		List<JobSeekerInfo> list=service.featchAllDetails();
		map.put("jsList", list);
		return "report";
	}
	
	@Autowired
	private ServletContext sc;
	@GetMapping("/download")
	public String downlodeByid(HttpServletResponse res,
														@RequestParam("jsid")Integer id,
														@RequestParam("type")String type) throws Exception {
		
		String filePath;
		if(type.equalsIgnoreCase("resume"))
			filePath=service.getResumePathById(id);
		else
			filePath=service.getPhotoPathById(id);
		
		File file=new File(filePath);
		
		 res.setContentLengthLong(file.length());
		 
		 String mimeType=sc.getMimeType(filePath);
		 
		 mimeType=mimeType==null?"application/octet-stream":mimeType;
		 res.setContentType(mimeType);
		 
		 InputStream is=new FileInputStream(file);
		 
		 OutputStream os=res.getOutputStream();
		 
		res.setHeader("Content-Disposition", "attachment;fileName="+file.getName());
		 
		 IOUtils.copy(is, os);
		 
		 is.close();
		 os.close();
		 System.out.println("jobSeekerOperationsController.downlodeByid()");
		 System.out.println(filePath);
		 
		 
		
		return null;
	}
	
	
}
