package com.nt.service;

import java.util.List;

import com.nt.documnets.Player;

public interface IPlayerMgmtService {

	public List<Player> FeatchPlayrs();
	public String registoredPlayers(Player plyaer);
}
