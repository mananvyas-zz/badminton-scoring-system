package com.manan.test;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Transient;

@Entity
public class Game {
	@Id
	private int id;
	private String winner;
	
	@Transient
	private ScoreWrapper scores;
	
	public Game(){
		
	}

	public Game(int id, ScoreWrapper scores, String winner) {
		super();
		this.id = id;
		this.scores = scores;
		this.winner = winner;
	}


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public ScoreWrapper getScores() {
		return scores;
	}

	public void setScores(ScoreWrapper scores) {
		this.scores = scores;
	}

	public String getWinner() {
		return winner;
	}

	public void setWinner(String winner) {
		this.winner = winner;
	}
}
