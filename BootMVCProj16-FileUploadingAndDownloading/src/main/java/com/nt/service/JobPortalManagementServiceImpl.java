package com.nt.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nt.Repo.JobSeekerRepository;
import com.nt.entity.JobSeekerInfo;
@Service
public class JobPortalManagementServiceImpl implements IJobPortalManagementServiceImpl {

	@Autowired
	private JobSeekerRepository repo;
	@Override
	public String registerJobSeeker(JobSeekerInfo info) {
		int id=repo.save(info).getId();
		return "Record Saved with id value : "+id;
	}
	
	@Override
	public List<JobSeekerInfo> featchAllDetails() {
		// TODO Auto-generated method stub
		return repo.findAll();
	}
	
	@Override
	public String getPhotoPathById(int id) {
		// TODO Auto-generated method stub
		return repo.getphotoFilePathById(id);
	}
	   
	@Override
	public String getResumePathById(int id) {
		// TODO Auto-generated method stub
		return repo.getresumeFilePathById(id);
	}

}
