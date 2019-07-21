package com.mavericks.utils;

import com.mavericks.main.ConfigLoader;
import com.mavericks.main.HandGestures;
import com.mavericks.main.Player;


/**
 * This is utility class for processing the player's input, validation of the input,
 * displays the seelction message
 * @author RoopaBalappa
 *
 */
public class GameUtils {

	public static ConfigLoader configLoader = ConfigLoader.getInstance();

	public static boolean isValidOption(String playerOption) {
		boolean isValid = false;
		isValid = playerOption.matches(configLoader.getUserInputRegEx());
		return isValid;
	}

	public static HandGestures processPlayerInputOption(String playerInput) {

		switch (playerInput) {
		case "R":
			return HandGestures.ROCK;

		case "P":
			return HandGestures.PAPER;

		case "S":
			return HandGestures.SCISSORS;

		default:
			return null;
		}
	}

	public static HandGestures processComputerOption(int computerOption) {

		switch (computerOption) {
		case 1:
			return HandGestures.ROCK;

		case 2:
			return HandGestures.PAPER;

		case 3:
			return HandGestures.SCISSORS;

		default:
			return null;
		}
	}
	
	
	public static void displaySelection(Object obj, HandGestures compSelection){
		switch (compSelection) {
		case ROCK:
			if(obj instanceof Player){
				Player player = (Player)obj;
				System.out.println( player.getPlayerName() + configLoader.getUserSelectedMsg() + HandGestures.ROCK);
			}else {
				System.out.println(configLoader.getComputerSelectedMsg() + HandGestures.ROCK);
			}
			break;
			
		case PAPER:
			if(obj instanceof Player){
				Player player = (Player)obj;
				System.out.println( player.getPlayerName() + configLoader.getUserSelectedMsg() + HandGestures.PAPER);
			}else {
			System.out.println(configLoader.getComputerSelectedMsg() + HandGestures.PAPER);
			}
			break;
			
		case SCISSORS:
			if(obj instanceof Player){
				Player player = (Player)obj;
				System.out.println( player.getPlayerName() + configLoader.getUserSelectedMsg() + HandGestures.SCISSORS);
			}else {
				System.out.println(configLoader.getComputerSelectedMsg() + HandGestures.SCISSORS);
			}			
			break;
			
		default:
			break;
		}
	}
	
}
