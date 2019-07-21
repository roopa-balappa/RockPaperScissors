package com.mavericks.game;

import java.util.Scanner;

import com.mavericks.main.Computer;
import com.mavericks.main.ConfigLoader;
import com.mavericks.main.HandGestures;
import com.mavericks.main.Player;
import com.mavericks.utils.GameUtils;

/**
 * This class is used a gaming mode initialiser. Initialisation happens based on the user selection 
 * of the gaming mode 
 * @author RoopaBalappa
 * 
 */
public class GamingModeInitialiser {
	// Player vs Computer set to 1
	public static final int pvsc = 1;
	// player vs player set to 2
	public static final int pvsp = 2;
	// Computer vs computer set to 3
	public static final int cvsc = 3;

	public static ConfigLoader configLoader = ConfigLoader.getInstance();

	// user selected mode
	public int selectedMode;

	public GamingModeInitialiser(int mode) {
		this.selectedMode = mode;
		//loadTheSelectedGameMode(selectedMode);
	}

	public boolean loadTheSelectedGameMode(int mode) {
		boolean status = false;
		switch (mode) {
		// Player vs Computer
		case pvsc:
			System.out.println(configLoader.getValidGameMode1SelectMsg());
			status = startGamePlayerVSComputer();			
			return status;
			
		//palyer vs player
		case pvsp:
			System.out.println(configLoader.getValidGameMode2SelectMsg());
			status = startGamePlayerVSPlayer();
			return status;
			
		// Computer vs Computer
		case cvsc:
			System.out.println(configLoader.getValidGameMode3SelectMsg());
			status = startGameComputerVSComputer();
			return status;

		// Chose to exit
		default:
			System.out.println(configLoader.getChoseExitOptionMsg());
			return status;
		}
	}

	
	private int setComputerGestureOption(Computer compPlayer) {
		int compPlayerOption = 0;
		// if the randomiser returned a '0' try again
		while (compPlayerOption == 0) {
			compPlayerOption = compPlayer.getHandGesture(HandGestures.COMPUTER);
		}
		return compPlayerOption;
	}

	
	private boolean startGamePlayerVSPlayer() {
		// initialise  player1
		Player player1 = new Player();
		
		//initialise player2
		Player player2 = new Player();
		
		Scanner sc = new Scanner(System.in);
		// capture the player1 option
		System.out.println(configLoader.getSelectRPSMsg() + " for player " + player1.getPlayerName());
		String selectedOptionPlayer1 = sc.next().toUpperCase();
		
		// check for valid user input of player1
		boolean isInput1Valid = GameUtils.isValidOption(selectedOptionPlayer1);
		if(isInput1Valid){
			// capture the player1 option
			System.out.println(configLoader.getSelectRPSMsg() + " for player " + player2.getPlayerName());
			String selectedOptionPlayer2 = sc.next().toUpperCase();
			
			// check for valid user input of player2
			boolean isInput2Valid = GameUtils.isValidOption(selectedOptionPlayer2);
			if(isInput2Valid){
				// process the hand gesture selected by player1 and player2
				HandGestures player1SelectedGesture = GameUtils
						.processPlayerInputOption(selectedOptionPlayer1);
				HandGestures player2SelectedGesture = GameUtils
						.processPlayerInputOption(selectedOptionPlayer2);
				
				//set the players selected hand gestures
				player1.setHandGesture(player1SelectedGesture);
				player2.setHandGesture(player2SelectedGesture);
				
				//start the game
				IGameCommand rpsCommand = new RockPaperScissorGame();
				int gameResult = rpsCommand.execute(player1SelectedGesture, player2SelectedGesture);
				return rpsCommand.gameResult(gameResult, player1);
			}
		}else {
			System.out.println(configLoader.getInvalidGameModeSelectMsg());
			return false;
		}
		return isInput1Valid;
	}
	
	/**
	 * Computer vs Computer game
	 * @return 
	 */
	private boolean startGameComputerVSComputer() {

		// Computer player1
		Computer comp1 = new Computer();
		comp1.setPlayerName(configLoader.getComputerPlayer1());
		int comp1Option = setComputerGestureOption(comp1);
		HandGestures comp1HandGesture = GameUtils
				.processComputerOption(comp1Option);

		// Display computer1's selection
		System.out.println(configLoader.getComputerPlayer1());
		GameUtils.displaySelection(comp1,comp1HandGesture);

		// Computer player2
		Computer comp2 = new Computer();
		comp2.setPlayerName(configLoader.getComputerPlayer2());
		int comp2Option = setComputerGestureOption(comp2);

		HandGestures comp2HandGesture = GameUtils
				.processComputerOption(comp2Option);

		// Display computer2's selection
		System.out.println(configLoader.getComputerPlayer2());
		GameUtils.displaySelection(comp2,comp2HandGesture);

		//start the game
		IGameCommand rpsCommand = new RockPaperScissorGame();
		int gameResult = rpsCommand.execute(comp1HandGesture, comp2HandGesture);
		return rpsCommand.gameResult(gameResult, comp1);

	}

	/**
	 * Player vs Computer game
	 */
	private boolean startGamePlayerVSComputer() {
		// initialise the player
		Player player = new Player();
		Scanner sc = new Scanner(System.in);

		// capture the player option
		System.out.println(configLoader.getSelectRPSMsg());
		String selectedOption = sc.next().toUpperCase();
		sc.close();
		
		// check for valid user input
		boolean isValid = GameUtils.isValidOption(selectedOption);

		if (isValid) {
			// set the hand gesture selected by player
			HandGestures playerSelectedGesture = GameUtils
					.processPlayerInputOption(selectedOption);
			//if (playerSelectedGesture != null) 
			{
				// set the player hand gesture
				player.setHandGesture(playerSelectedGesture);

				// get computer selected hand gesture
				Computer computer = new Computer();
				int computerOption = setComputerGestureOption(computer);

				HandGestures computerSelected = GameUtils
						.processComputerOption(computerOption);

				// Display computer's selection
				GameUtils.displaySelection(computerSelected, computerSelected);
				
				// start the game
				IGameCommand rpsCommand = new RockPaperScissorGame();
				int gameResult = rpsCommand.execute(playerSelectedGesture,
						computerSelected);
				return rpsCommand.gameResult(gameResult, player);
			}
		} else {
			System.out.println(configLoader.getInvalidGameModeSelectMsg());
			return isValid;
		}
	}

}
