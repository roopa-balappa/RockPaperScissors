package com.mavericks.tests.main;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.mavericks.main.HandGestures;
import com.mavericks.main.Player;

public class PlayerTest {
	
	Player testPlayer;

	@Before
	public void setUp() throws Exception {
		testPlayer = new Player();
	}

	@Test
	public void testGetPlayerName() {
		testPlayer.setPlayerName("testPlayer1");
		Assert.assertEquals("testPlayer1",testPlayer.getPlayerName());
	}


	@Test
	public void testSetHandGesture() {
		HandGestures val = testPlayer.setHandGesture(HandGestures.ROCK);
		Assert.assertEquals(HandGestures.ROCK,val); //1
		val = testPlayer.setHandGesture(HandGestures.PAPER);
		Assert.assertEquals(HandGestures.PAPER,val);
		val= testPlayer.setHandGesture(HandGestures.SCISSORS);
		Assert.assertEquals(HandGestures.SCISSORS,val);
	}

}
