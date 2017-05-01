package com.manan.test;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Score {
	@Id
	String id;
	String scorer;
	
	public Score(){
		
	}
	
	public Score(String id, String scorer) {
		super();
		this.id = id;
		this.scorer = scorer;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getScorer() {
		return scorer;
	}

	public void setScorer(String scorer) {
		this.scorer = scorer;
	}
}
