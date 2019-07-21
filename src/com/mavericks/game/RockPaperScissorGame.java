package com.mavericks.game;

import com.mavericks.main.Computer;
import com.mavericks.main.ConfigLoader;
import com.mavericks.main.HandGestures;
import com.mavericks.main.Player;

/**
 * The main business logic of the game resides here.
 * 
 * @author RoopaBalappa
 * 
 */
public class RockPaperScissorGame implements IGameCommand {

	public static ConfigLoader configLoader = ConfigLoader.getInstance();

	@Override
	/*
	 * Actual execution output for the selected hand gestures from both parties
	 * is done here
	 * 
	 * @see
	 * com.mavericks.main.game.IGameCommand#execute(com.mavericks.main.HandGestures
	 * , com.mavericks.main.HandGestures)
	 */
	public int execute(HandGestures selection1, HandGestures selection2) {

		if (selection1 == selection2)
			return 0;
		switch (selection1) {
		case ROCK:
			return (selection2 == HandGestures.SCISSORS ? 1 : -1);

		case PAPER:
			return (selection2 == HandGestures.ROCK ? 1 : -1);

		case SCISSORS:
			return (selection2 == HandGestures.PAPER ? 1 : -1);

		default:
			break;
		}
		return 0;
	}

	/*
	 * Displays the result of the game based on the execution result got from the execute method 
	 *
	 */
	@Override
	public boolean gameResult(int execResult, Object obj) {
		Player player = null;
		Computer computer = null;
		if (obj instanceof Player) {
			player = (Player) obj;
		} else {
			computer = (Computer) obj;
		}

		switch (execResult) {
		case 0: // Tie
			System.out.println(configLoader.getTieMsg());
			return true;
			
		case 1: // player wins
			if (obj instanceof Computer) {
				System.out.println(computer.getPlayerName() + " beats "
						+ "computer." + computer.getPlayerName() +" "
						+ configLoader.getWonMsg());
			} else {
				System.out.println(player.getPlayerName() + " beats "
						+ "computer." + player.getPlayerName()+ " "
						+ configLoader.getWonMsg());
			}
			return true;
			
		case -1: // Computer wins
			if (obj instanceof Computer) {
				System.out.println("Computer" + " beats "
						+ computer.getPlayerName() + "."
						+ computer.getPlayerName() + " "
						+ configLoader.getLostMsg());
			}else if(obj instanceof Player){
				System.out.println(player.getPlayerName() + " "+ configLoader.getLostMsg());
			}else {
				System.out.println("Computer" + " beats "
						+ player.getPlayerName() + "." 
						+ player.getPlayerName() + " "
						+ configLoader.getLostMsg());
			}
			return true;
		
		default : return false;
		}

	}
}
