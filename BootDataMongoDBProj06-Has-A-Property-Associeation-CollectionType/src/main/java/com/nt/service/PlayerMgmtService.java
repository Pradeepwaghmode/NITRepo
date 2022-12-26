package com.nt.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nt.documnets.Player;
import com.nt.repository.IMedalRepository;
import com.nt.repository.IPlayerRepository;
import com.nt.repository.ISportRepository;

@Service
public class PlayerMgmtService implements IPlayerMgmtService {

	@Autowired
	private IPlayerRepository playerRepo;
	@Autowired
	private ISportRepository sportRepo;
	@Autowired
	private IMedalRepository medalRepo;
	
	@Override
	public List<Player> FeatchPlayrs() {
		// TODO Auto-generated method stub
		return playerRepo.findAll();
	}

	@Override
	public String registoredPlayers(Player plaer) {
		// TODO Auto-generated method stub
		return "Player Rgistorted with id: "+ playerRepo.save(plaer).getPid()+", Thank you !!";
	}

}
