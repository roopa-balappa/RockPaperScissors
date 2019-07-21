package com.mavericks.tests.main;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;

import com.mavericks.main.Computer;
import com.mavericks.main.HandGestures;

public class ComputerTest {

	@Test
	public void testGetPlayerName() {
		Computer computer = new Computer();
		computer.setPlayerName("Computer test player");
		Assert.assertEquals("Computer test player", computer.getPlayerName());
	}

	
	@Test
	public void testGetHandGesture() {
		Computer computer = new Computer();
		int computerDefaultGesture = computer.getHandGesture(HandGestures.COMPUTER);
		Assert.assertTrue("Value with range", computerDefaultGesture < 4);
	}

}
