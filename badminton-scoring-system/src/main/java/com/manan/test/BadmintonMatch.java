package com.manan.test;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class BadmintonMatch {
	@Id @GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	
	@ElementCollection
	private List<String> players;
	private String winner;
	
	@ElementCollection
	private List<Game> games;
	
	public BadmintonMatch(){
		
	}	

	public BadmintonMatch(int id, String winner, List<String> players, List<Game> games) {
		super();
		this.id = id;
		this.winner = winner;
		this.players = players;
		this.games = games;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getWinner() {
		return winner;
	}
	public void setWinner(String winner) {
		this.winner = winner;
	}
	public List<Game> getGames() {
		return games;
	}
	public void setGames(List<Game> games) {
		this.games = games;
	}

	public List<String> getPlayers() {
		return players;
	}

	public void setPlayers(List<String> players) {
		this.players = players;
	}
}
