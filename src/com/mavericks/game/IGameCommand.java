package com.mavericks.game;

import com.mavericks.main.HandGestures;

/**
 * The Command interface used to implement the game accordingly
 * @author RoopaBalappa
 *
 */
public interface IGameCommand {
	int execute(HandGestures selection1, HandGestures selection2);
	boolean gameResult(int execResult, Object obj) ;
}
