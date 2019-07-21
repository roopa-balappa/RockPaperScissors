package com.mavericks.tests.game;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.mavericks.game.GamingModeInitialiser;

public class GamingModeInitialiserTest {

	
	@Test
	public void testLoadTheSelectedGameMode() {
		//player vs computer
		int playerVsComputer = 1;
		GamingModeInitialiser testInitialiser = new GamingModeInitialiser(playerVsComputer);
		boolean run1Status = testInitialiser.loadTheSelectedGameMode(playerVsComputer);
		Assert.assertTrue(run1Status);
		
		
		int computerVsComputer = 2;
		GamingModeInitialiser testInitialiser2 = new GamingModeInitialiser(computerVsComputer);
		boolean run2Status = testInitialiser2.loadTheSelectedGameMode(computerVsComputer);
		Assert.assertTrue(run2Status);
		
		int wrongMode = 3;
		GamingModeInitialiser testInitialiser3 = new GamingModeInitialiser(wrongMode);
		boolean run3Status = testInitialiser3.loadTheSelectedGameMode(wrongMode);
		Assert.assertEquals(false, run3Status);
	}

}
