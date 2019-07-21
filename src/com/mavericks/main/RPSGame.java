package com.mavericks.main;

import java.util.Scanner;

import com.mavericks.game.GamingModeInitialiser;

/**
 * Main class of the Rock Paper scissor game
 * @author RoopaBalappa
 *
 */
public class RPSGame {

	public static Scanner scanner = new Scanner(System.in);
	public static ConfigLoader configLoader = ConfigLoader.getInstance();
	public static String inputRegex = configLoader.getGameModeRegex();//"[0-2]+";
	public int gameMode;
	public GamingModeInitialiser gamingMode;

	public static void main(String[] args) {

		RPSGame rpsGameObj = new RPSGame();

		// Display welcome msg and game options
		configLoader = ConfigLoader.getInstance();
		System.out.println(configLoader.getWelcomeMsg());
		System.out.println(configLoader.getGamingModeMsg());
		System.out.println(configLoader.getGameMode1Msg());
		System.out.println(configLoader.getGameMode2Msg());
		System.out.println(configLoader.getGameMode3Msg());
		System.out.println(configLoader.getSelectOption());

		// read game mode selected from console
		String inputStr = scanner.next();
		
		// if valid mode selected
		if (inputStr.matches(inputRegex)) {
			rpsGameObj.gameMode = Integer.parseInt(inputStr);

			System.out.println(configLoader.getSelectedGameModeMsg()
					+ rpsGameObj.gameMode);
			rpsGameObj.gamingMode = new GamingModeInitialiser(rpsGameObj.gameMode);
			rpsGameObj.gamingMode.loadTheSelectedGameMode(rpsGameObj.gameMode);
			
		} else {
			System.out.println(configLoader.getInvalidGameModeSelectMsg());
			System.exit(0);
		}
		
		scanner.close();
	}

}
