package com.manan.test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ScoringSystemService {
	int MAX_SCORE = 5; //Assuming 21 is game point
	int DEFAULT_ID = 1; //Default id for match
	
	BadmintonMatch match = new BadmintonMatch();
	List<Game> games = new ArrayList<Game>();
	
	@Autowired
	private BadmintonMatchRepository matchRepository;
	
	public void computeScore(ScoreWrapper scores){
		
		HashMap<String, Integer> scoreMap = new HashMap<String, Integer>();
		int gameCounter = 1; //Number of games
		
		for(Score score : scores.getScores()){
			
			if(scoreMap.get(score.getScorer()) != null){
				int points = scoreMap.get(score.getScorer()) + 1; //Increase score point
				scoreMap.put(score.getScorer(), points);
				
				//considering game-over when either participant achieve 21 point score
				if(points == MAX_SCORE){
					
					Game game = new Game();
					game.setId(gameCounter);
					game.setWinner(score.getScorer());
					
					//Preparing Score List
					List<Score> scoreList = new ArrayList<Score>();
					for(String key : scoreMap.keySet()){
						scoreList.add(new Score(key, scoreMap.get(key).toString()));
					}
					
					game.setScores(new ScoreWrapper(scoreList));
					games.add(game);
					
					gameCounter++;
				}
			} else {
				scoreMap.put(score.getScorer(), 1); //Setting score point for the first time scorer
			}
		}
		
//		match.setId(DEFAULT_ID);
		
		//Setting Player information for given match
		List<String> players = new ArrayList<String>();
		for(String key : scoreMap.keySet()){
			players.add(key);
		}
		
		match.setPlayers(players);
		
		//Set Winner information for given match
		String matchWinner  = "";
		for(Game game : games){
			String winner = game.getWinner();
			Map<String, Integer> scoreInfo = new HashMap<String, Integer>();
			if(scoreInfo.get(winner) == null){
				scoreInfo.put(winner, 1);
			} else {
				scoreInfo.put(winner, scoreInfo.get(winner) + 1); //Increase existing count
			}
			
			//Now figure out player with highest count in the map
			int max = 0;
			
			for(String key : scoreInfo.keySet()){
				if(scoreInfo.get(key) > max) {
					max = scoreInfo.get(key);
					matchWinner = key;
				} 
			}
		}
		
		match.setWinner(matchWinner);
		match.setGames(games);
		
		matchRepository.save(match);
	}
	
	public BadmintonMatch getResult(){
		return match;
	}
}