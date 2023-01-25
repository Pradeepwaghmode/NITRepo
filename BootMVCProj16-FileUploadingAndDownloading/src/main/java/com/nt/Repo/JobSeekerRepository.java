package com.nt.Repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.nt.entity.JobSeekerInfo;

public interface JobSeekerRepository extends JpaRepository<JobSeekerInfo, Integer> {

	@Query("select resume from JobSeekerInfo where id=:id")
	public String getresumeFilePathById(int id);
	
	@Query("select photo from JobSeekerInfo where id=:id")
	public String getphotoFilePathById(int id);
}
