package com.mavericks.main;

import java.util.Random;

/**
 * This class represents the Computer component that plays the game
 * @author RoopaBalappa
 *
 */
public class Computer {

	private int randomHandGesture;
	private String playerName;	
	
	

	public String getPlayerName() {
		return playerName;
	}


	public void setPlayerName(String playerName) {
		this.playerName = playerName;
	}


	private int randomizer(){
		Random random = new Random();
		int input = random.nextInt(4); //0 to 4
		if(input == 0){
			randomizer();
		}
		return input;
	}

	
	public int getHandGesture(HandGestures gesture) {
		this.randomHandGesture = randomizer();
		return randomizer();
	}
	
}
