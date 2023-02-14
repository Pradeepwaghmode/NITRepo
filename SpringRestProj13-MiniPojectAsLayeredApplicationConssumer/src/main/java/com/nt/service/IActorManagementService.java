package com.nt.service;

import java.util.List;

import com.nt.model.Actor;

public interface IActorManagementService {

	public String register(Actor act);
	public List<Actor> getAllRecords();
	public Actor getActorById(int id);
	public List<Actor> getActorsBycategory(String c1,String c2);
	public String updateActor(Actor act);
	public String deleteById(int id);
	public String updateActorMoNo(int id,Long newMobileNo);
}
