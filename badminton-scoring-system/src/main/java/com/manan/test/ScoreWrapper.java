package com.manan.test;

import java.util.List;

import javax.persistence.ElementCollection;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.Id;

public class ScoreWrapper {
	private int id;
	private List<Score> scores;

	public ScoreWrapper(){
		
	}
	
	public ScoreWrapper(List<Score> scores) {
		super();
		this.scores = scores;
	}

	public List<Score> getScores() {
		return scores;
	}

	public void setScores(List<Score> scores) {
		this.scores = scores;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
}
