package com.nt.service;

import java.util.List;

import com.nt.entity.JobSeekerInfo;

public interface IJobPortalManagementServiceImpl {

	public String registerJobSeeker(JobSeekerInfo info);
	public List<JobSeekerInfo> featchAllDetails();
	
	public String getResumePathById(int id);
	public String getPhotoPathById(int id);
}
