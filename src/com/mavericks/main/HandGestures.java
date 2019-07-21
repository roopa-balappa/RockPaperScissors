package com.mavericks.main;

/**
 * Enum to maintain all the constants used in the game
 * @author RoopaBalappa
 *
 */
public enum HandGestures {
	ROCK(1),
	PAPER(2),
	SCISSORS(3),
	COMPUTER(0);
	
	private int option;
	
	HandGestures(int val){
		this.option = val;
	}
	
	public int getOption(){
		return this.option;
	}
}
