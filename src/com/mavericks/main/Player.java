package com.mavericks.main;

import java.util.Scanner;

/**
 * This class represents the Player who plays the game
 * @author RoopaBalappa
 *
 */
public class Player {
	private String playerName;
	private HandGestures selectedHandGesture;	
	private static ConfigLoader configLoader = ConfigLoader.getInstance();
	private Scanner scanner = new Scanner(System.in);

	
	public Player(){
		System.out.println(configLoader.getEnterPlayerNameMsg());
		this.playerName = scanner.next();
	}
	
	public String getPlayerName() {
		return playerName;
	}

	public void setPlayerName(String playerName) {
		this.playerName = playerName;
	}

	public HandGestures setHandGesture(HandGestures gesture) {
		
		switch (gesture) {
		case ROCK:
			selectedHandGesture = HandGestures.ROCK;
			break;

		case PAPER:
			selectedHandGesture = HandGestures.PAPER;
			break;
		
		case SCISSORS :
			selectedHandGesture = HandGestures.SCISSORS;
			break;
			
		default:
			break;
		}
		return selectedHandGesture;
	}

}
