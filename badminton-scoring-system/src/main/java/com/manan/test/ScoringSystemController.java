package com.manan.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ScoringSystemController {

	@Autowired
	private ScoringSystemService scoringSystemService;
	
	@RequestMapping(method=RequestMethod.POST, value="/scores")
	public void scoreInput(@RequestBody ScoreWrapper scores){
		scoringSystemService.computeScore(scores);
	}
	
	@RequestMapping("/result")
	public BadmintonMatch getResult(){
		return scoringSystemService.getResult();
	}
}
